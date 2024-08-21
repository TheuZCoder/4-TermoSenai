@extends('layouts.app')

@section('content')
<div class="DivFora">
    <div class="top">
        <h1>Manage Books</h1>
        <a href="{{ route('admin.books.create') }}" class="btn btn-primary custom-button">Add New Book</a>
    </div>

    @if(session('success'))
    <div class="alert alert-success">
        {{ session('success') }}
    </div>
    @endif

    <table class="table">
        <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Genre</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            @foreach($books as $book)
            <tr>
                <td class="title">{{ $book->title }}</td>
                <td class="autor">{{ $book->author }}</td>
                <td class="genre">{{ $book->genre }}</td>
                <td>
                    <a href="{{ route('admin.books.edit', $book->id) }}" class="btn btn-edit">Edit</a>
                    <form action="{{ route('admin.books.destroy', $book->id) }}" method="POST" class="d-inline">
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-delete" onclick="return confirm('Are you sure?')">Delete</button>
                    </form>
                </td>
            </tr>
            @endforeach
        </tbody>
    </table>
</div>
@endsection