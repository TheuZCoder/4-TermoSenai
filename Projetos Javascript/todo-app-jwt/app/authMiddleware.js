import jwt from "jsonwebtoken";
import { NextResponse } from 'next/server';




export async function middleware(request) {
  const token = request.headers.get('Authorization')?.split(' ')[1];
 
  if (!token) {
    return NextResponse.redirect(new URL('/login', request.url));
  }


  try {
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    request.user = decoded;
  } catch (error) {
    return NextResponse.redirect(new URL('/login', request.url));
  }


  return NextResponse.next();
}


export const config = {
  matcher: ['/api/tasks/:path*', '/tasks/:path*'],
};
