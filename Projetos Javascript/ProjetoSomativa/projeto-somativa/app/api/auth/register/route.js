import User from "@/models/User";
import connectMongo from "@/utils/dbConnect";
import { NextResponse } from "next/server";
import jwt from "jsonwebtoken";

export async function POST(request) {
    const data = await request.json(); // Obtém os dados de registro do usuário
    await connectMongo(); // Conecta ao banco de dados

    try {
        // Cria um novo usuário no banco de dados com os dados fornecidos
        const user = await User.create(data);

        // Gera um token JWT assim que o usuário é criado
        const token = jwt.sign({ userId: user._id }, process.env.JWT_SECRET, { expiresIn: '1h' }); // Token expira em 1 hora

        // Retorna o token para o frontend, junto com a confirmação de sucesso
        return NextResponse.json({ success: true, token });

    } catch (error) {
        // Em caso de erro, retorna uma resposta de falha
        return NextResponse.json({ success: false, message: "Erro ao criar usuário" }, { status: 400 });
    }
}
