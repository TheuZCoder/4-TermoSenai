@extends('layouts.app')

@section('content')
<div class="DivFora">
    <h1 class="my-4">Available Books for Loan</h1>

    <div class="row">
        @foreach($books as $book)
        <div class="Card">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">{{ $book->title }}</h5>
                    <p class="card-text">Author: {{ $book->author }}</p>
                    <p class="card-text">Genre: {{ $book->genre }}</p>
                    <p class="card-text">Status: {{ $book->is_available ? 'Available' : 'Not Available' }}</p>

                    @if($book->is_available)
                    <form action="{{ route('books.loan', $book->id) }}" method="POST">
                        @csrf
                        <button type="submit" class="btn btn-success">Loan Book</button>
                    </form>
                    @else
                    @php
                    $loan = $book->loans()->where('user_id', Auth::id())->whereNull('return_date')->first();
                    @endphp

                    @if($loan)
                    <form action="{{ route('books.return', $loan->id) }}" method="POST">
                        @csrf
                        @method('PUT')
                        <button type="submit" class="btn btn-danger">Return Book</button>
                    </form>
                    @else
                    <button class="btn btn-secondary" disabled>Not Available</button>
                    @endif
                    @endif
                </div>
            </div>
        </div>
        @endforeach
    </div>
</div>
@endsection