@if (Auth::check())
    <div>
        <h3>
            Olá, {{ Auth::user()->name }}
        </h3>
        <h4>
            {{Auth::user()->tipo_usuario}}
        </h4>
    </div>
    <form action="/logout" method="POST">
        @csrf
        <button type="submit">Logout</button>
    </form>
@else
    <div>
        <a href="/login">Login</a>
        <a href="/registro">Registro</a>
    </div>

@endif