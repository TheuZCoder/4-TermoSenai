<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Support\Facades\Auth;

class LoginController extends Controller
{
    use AuthenticatesUsers;

    protected $redirectTo = '/'; // ou qualquer rota padrão

    // Redireciona com base no tipo de usuário após a autenticação
    protected function authenticated($request, $user)
    {
        if ($user->isAdmin) { // Corrigido de is_admin para isAdmin
            return redirect()->route('admin.books.index'); // Redireciona para a página de administração
        }

        return redirect()->route('books.index'); // Redireciona para a página inicial padrão para usuários comuns
    }

    public function __construct()
    {
        $this->middleware('guest')->except('logout');
    }
}
