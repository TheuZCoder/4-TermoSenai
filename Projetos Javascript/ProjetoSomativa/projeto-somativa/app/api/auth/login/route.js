import User from "@/models/User";
import connectMongo from "@/utils/dbConnect";
import { NextResponse } from "next/server";
import jwt from "jsonwebtoken";
import bcrypt from 'bcryptjs';

export async function POST(request) {
    try {
      const { username, password } = await request.json();
      console.log("Dados recebidos:", { username, password }); // Log dos dados recebidos
      await connectMongo();
  
      const user = await User.findOne({ username });
      console.log("Usuário encontrado:", user); // Log do usuário encontrado
  
      if (!user) {
        return NextResponse.json({ success: false, message: "Usuário não encontrado" }, { status: 400 });
      }
  
      const isPasswordValid = await bcrypt.compare(password, user.password);
      console.log("Senha válida:", isPasswordValid); // Log da validade da senha
  
      const token = jwt.sign({ userId: user._id }, process.env.JWT_SECRET, { expiresIn: '1h' });
      console.log('Token gerado:', token); // Log do token gerado
  
      return NextResponse.json({ success: true, token });
    } catch (error) {
      console.error("Erro ao processar login:", error);
      return NextResponse.json({ success: false, message: "Erro ao processar login" }, { status: 500 });
    }
  }
  
