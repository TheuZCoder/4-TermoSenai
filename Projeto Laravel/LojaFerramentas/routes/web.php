<?php

use App\Http\Controllers\UserController;
use App\Http\Controllers\ProdutoController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('home');
});

Route::get('/registro', [UserController::class, 'showRegistroForm'])->
name('usuarios.registro');

Route::post('/registro', [UserController::class, 'registro'])->
name('usuarios.registro');

Route::get('/login', [UserController::class, 'showLoginForm'])->
name('usuarios.login');

Route::post('/login', [UserController::class, 'login'])->
name('usuarios.login');

//rota pagina interna

Route::get('/dashboard', function () {
    return view('usuarios.dashboard');
})->middleware(['auth'])->name('dashboard');


Route::post('/logout', [UserController::class, 'logout'])->
name('usuarios.logout');

//rota para Produtos
Route::resource('produtos', ProdutoController::class);





