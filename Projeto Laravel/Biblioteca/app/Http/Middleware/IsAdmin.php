<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Support\Facades\Auth;

class IsAdmin
{
    public function handle($request, Closure $next)
    {
        if (Auth::user()->isAdmin) { // Corrigido de is_admin para isAdmin
            return $next($request);
        }

        return redirect('/'); // ou qualquer outra rota para usuários não administradores
    }
}
