import { getTask,createTask } from "@/controllers/TaskController";
import { NextResponse } from "next/server";


export async function GET(request) {
    try {
        const userId = request.userId;
        const tasks = await getTask(userId);
        return NextResponse.json({
            success:true,
            data:tasks
        });
    } catch (error) {
        console.error(error,"Route");
        return NextResponse.json(
            {success:false},
            {status:400}
        );
    }
}


export async function POST(request) {
    try {
        const data = await request.json();
        const task = await createTask(data);
        return NextResponse.json({
            success:true,
            data:task
        })
    } catch (error) {
        console.error(error,"Route");
        return NextResponse.json(
            {success:false},
            {status:400}
        );
    }
   
}


app/api/tasks/[id]/route


import { updateTask, deleteTask } from "@/controllers/TaskController"
import { NextResponse } from "next/server"


export async function PUT(request, { params }) {
    try {
        const data = await request.json();
        const task = await updateTask(params.id, data);
        if (!task) {
            return NextResponse.json({ success: false }, { status: 400 });
        }
        return NextResponse.json({ success: true, data: task });
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 400 });
    }
}


export async function DELETE({params}) {
    try {
        const task = await deleteTask(params.id);
        if (!task) {
            return NextResponse.json({ success: false }, { status: 400 });
        }
        return NextResponse.json({success: true, message: "Deletado com Sucesso"});
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 400 });
    }
}
