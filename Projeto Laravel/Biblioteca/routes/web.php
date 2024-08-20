<?php

use App\Http\Controllers\BookController;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Route;

Auth::routes();

Route::get('/', [BookController::class, 'index'])->name('books.index');
Route::get('/books', [BookController::class, 'index'])->name('books.index');
Route::post('/books/{book}/loan', [BookController::class, 'loan'])->name('books.loan');
Route::put('/loans/{loan}/return', [BookController::class, 'returnBook'])->name('books.return');



