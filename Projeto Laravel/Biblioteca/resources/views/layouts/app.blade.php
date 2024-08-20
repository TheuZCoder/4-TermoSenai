<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>{{ config('app.name', 'Library') }}</title>
    <link href="{{ asset('css/app.css') }}" rel="stylesheet">
    <link href="{{ asset('css/books.css') }}" rel="stylesheet">
    @yield('styles')
</head>

<body>
    @include('layouts.header') <!-- Inclua o componente de cabeçalho -->

    <main class="py-4">
        @yield('content')
    </main>

    @include('layouts.footer')
</body>

</html>