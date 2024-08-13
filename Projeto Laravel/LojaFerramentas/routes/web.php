<?php

use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('home');
});

Route::get('/registro', [UserController::class, 'showRegistroForm'])->
name('usuarios.registro');

Route::post('/registro', [UserController::class, 'registro'])->
name('usuarios.registro');
