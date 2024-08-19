<?php

use App\Http\Controllers\BookController;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Route;

Auth::routes();

Route::get('/', [BookController::class, 'index'])->name('books.index');
Route::post('/books/{book}/loan', [BookController::class, 'loan'])->name('books.loan');

