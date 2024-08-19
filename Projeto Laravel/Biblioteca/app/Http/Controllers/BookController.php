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
        if ($book->is_available) {
            Loan::create([
                'user_id' => Auth::id(),
                'book_id' => $book->id,
                'loan_date' => now(),
                'status' => 'ongoing',
            ]);

            $book->update(['is_available' => false]);
        }

        return redirect()->route('books.index')->with('status', 'Book loaned successfully!');
    }
}
