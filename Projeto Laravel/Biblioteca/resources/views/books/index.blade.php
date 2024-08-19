@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Available Books for Loan</h1>

    <div class="row">
        @foreach($books as $book)
        <div class="col-md-4">
            <div class="card mb-4">
                <div class="card-body">
                    <h5 class="card-title">{{ $book->title }}</h5>
                    <p class="card-text">Author: {{ $book->author }}</p>
                    <p class="card-text">Genre: {{ $book->genre }}</p>
                    <p class="card-text">Status: {{ $book->is_available ? 'Available' : 'Not Available' }}</p>

                    @if($book->is_available)
                    <form action="{{ route('books.loan', $book->id) }}" method="POST">
                        @csrf
                        <button type="submit" class="btn btn-primary">Loan Book</button>
                    </form>
                    @else
                    <button class="btn btn-secondary" disabled>Not Available</button>
                    @endif
                </div>
            </div>
        </div>
        @endforeach
    </div>
</div>
@endsection
