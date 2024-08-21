@extends('layouts.app')

@section('content')
<div class="containerFora">
    <div class="pedit">
        <h1>Edit Book</h1>
    </div>
    <div class="cardedit">


        <form action="{{ route('admin.books.update', $book->id) }}" method="POST">
            @csrf
            @method('PUT')

            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" name="title" id="title" class="form-control" value="{{ $book->title }}" required>
            </div>

            <div class="form-group">
                <label for="author">Author</label>
                <input type="text" name="author" id="author" class="form-control" value="{{ $book->author }}" required>
            </div>

            <div class="form-group">
                <label for="genre">Genre</label>
                <input type="text" name="genre" id="genre" class="form-control" value="{{ $book->genre }}" required>
            </div>

            <button type="submit" class="btn btn-primary">Update Book</button>
        </form>
    </div>
</div>
@endsection