@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Add New Book</h1>

    <form action="{{ route('admin.books.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" name="title" id="title" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="author">Author</label>
            <input type="text" name="author" id="author" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="genre">Genre</label>
            <input type="text" name="genre" id="genre" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-success">Add Book</button>
    </form>
</div>
@endsection
