import connectMongo from "@/utils/dbConnect";
import User from "@/models/User";
import { NextResponse } from "next/server";
import jwt from "jsonwebtoken";

export async function GET(request) {
  try {
    await connectMongo();
    const token = request.headers.get('Authorization')?.split(' ')[1];

    if (!token) {
      return NextResponse.json({ success: false, message: 'Token de autenticação ausente' }, { status: 401 });
    }

    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    const userId = decoded.userId;

    const user = await User.findById(userId);
    if (!user) {
      return NextResponse.json({ success: false, message: 'Usuário não encontrado' }, { status: 404 });
    }

    return NextResponse.json({ isAdmin: user.isAdmin });
  } catch (error) {
    console.error("Erro ao obter informações do usuário:", error);
    return NextResponse.json({ success: false, message: "Erro ao obter informações do usuário" }, { status: 500 });
  }
}
