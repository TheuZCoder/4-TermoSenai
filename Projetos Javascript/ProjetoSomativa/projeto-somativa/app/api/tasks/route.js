import Task from "@/models/Task";
import connectMongo from "@/utils/dbConnect";
import { NextResponse } from "next/server";
import jwt from "jsonwebtoken";

export async function GET(request) {
  try {
    await connectMongo();
    const tasks = await Task.find();
    return NextResponse.json(tasks);
  } catch (error) {
    console.error("Erro ao buscar tarefas:", error);
    return NextResponse.json({ success: false, message: "Erro ao buscar tarefas" }, { status: 500 });
  }
}

export async function POST(request) {
  try {
    await connectMongo();
    const { title } = await request.json();
    const token = request.headers.get('Authorization')?.split(' ')[1];

    if (!token) {
      return NextResponse.json({ success: false, message: 'Token de autenticação ausente' }, { status: 401 });
    }

    // Verifique o token JWT e obtenha o ID do usuário
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    const userId = decoded.userId;

    const task = new Task({ title, userId });
    await task.save();

    return NextResponse.json(task);
  } catch (error) {
    console.error("Erro ao criar tarefa:", error);
    return NextResponse.json({ success: false, message: "Erro ao criar tarefa" }, { status: 500 });
  }
}


export async function PUT(request) {
  try {
    await connectMongo();
    const { id, title, status } = await request.json();

    if (!id) {
      return NextResponse.json({ success: false, message: 'ID da tarefa ausente' }, { status: 400 });
    }

    const task = await Task.findById(id);
    if (!task) {
      return NextResponse.json({ success: false, message: 'Tarefa não encontrada' }, { status: 404 });
    }

    // Atualize o título e o status
    task.title = title !== undefined ? title : task.title;
    task.status = status !== undefined ? status : task.status;

    await task.save();

    return NextResponse.json(task);
  } catch (error) {
    console.error("Erro ao atualizar tarefa:", error);
    return NextResponse.json({ success: false, message: "Erro ao atualizar tarefa" }, { status: 500 });
  }
}

export async function DELETE(request) {
  try {
    await connectMongo();
    const { id } = await request.json();
    
    const deletedTask = await Task.findByIdAndDelete(id);
    
    if (!deletedTask) {
      return NextResponse.json({ success: false, message: "Tarefa não encontrada" }, { status: 404 });
    }
    
    return NextResponse.json({ success: true, message: "Tarefa excluída com sucesso" });
  } catch (error) {
    console.error("Erro ao excluir tarefa:", error);
    return NextResponse.json({ success: false, message: "Erro ao excluir tarefa" }, { status: 500 });
  }
}
