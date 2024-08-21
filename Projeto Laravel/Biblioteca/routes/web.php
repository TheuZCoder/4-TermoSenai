<?php

use App\Http\Controllers\BookController;
use App\Http\Controllers\Admin\BookControllerAdmin;
use App\Http\Middleware\IsAdmin;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Route;

Auth::routes();

// Rota inicial e de exibição de livros
Route::get('/', [BookController::class, 'index'])->name('books.index');
Route::get('/books', [BookController::class, 'index'])->name('books.index');
Route::post('/books/{book}/loan', [BookController::class, 'loan'])->name('books.loan');
Route::put('/loans/{loan}/return', [BookController::class, 'returnBook'])->name('books.return');

// Rota para a página inicial do usuário logado
Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');

// Rotas para o CRUD de livros na página de administração
Route::middleware(IsAdmin::class)->group(function () {
    Route::get('/admin/books', [BookControllerAdmin::class, 'index'])->name('admin.books.index');
    Route::get('/admin/books/create', [BookControllerAdmin::class, 'create'])->name('admin.books.create');
    Route::post('/admin/books', [BookControllerAdmin::class, 'store'])->name('admin.books.store');
    Route::get('/admin/books/{book}/edit', [BookControllerAdmin::class, 'edit'])->name('admin.books.edit');
    Route::put('/admin/books/{book}', [BookControllerAdmin::class, 'update'])->name('admin.books.update');
    Route::delete('/admin/books/{book}', [BookControllerAdmin::class, 'destroy'])->name('admin.books.destroy');
});



