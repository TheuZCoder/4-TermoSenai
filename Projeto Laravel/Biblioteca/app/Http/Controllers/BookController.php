<?php

namespace App\Http\Controllers;

use App\Models\Book;
use App\Models\Loan;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class BookController extends Controller
{
    public function index()
    {
        $books = Book::all();
        return view('books.index', compact('books'));
    }

    public function loan(Book $book)
    {
        if (Auth::check()) {
            if ($book->is_available) {
                Loan::create([
                    'user_id' => Auth::id(),
                    'book_id' => $book->id,
                    'loan_date' => now(),
                    'status' => 'ongoing',
                ]);

                $book->update(['is_available' => false]);

                return redirect()->route('books.index')->with('status', 'Book loaned successfully!');
            } else {
                return redirect()->route('books.index')->with('error', 'Book is not available for loan.');
            }
        } else {
            return redirect()->route('login')->with('error', 'You need to be logged in to loan a book.');
        }
    }

    public function returnBook(Loan $loan)
    {
        // Verifica se o usuário está autenticado e se o empréstimo pertence ao usuário
        if (Auth::check() && $loan->user_id === Auth::id()) {
            $loan->update([
                'return_date' => now(),
                'status' => 'returned',
            ]);

            $loan->book->update(['is_available' => true]);

            return redirect()->route('books.index')->with('status', 'Book returned successfully!');
        }

        return redirect()->route('books.index')->with('error', 'You are not authorized to return this book.');
    }
}

