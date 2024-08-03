<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale='1.0'">
    <link rel="stylesheet" href="../css/app.css">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
</head>

<body>
    @include('components.header')
    <div class="container">
        <section id="inicio">
            <h1>Bem-vindo à nossa Loja de Celulares</h1>
            <p>Explore os melhores celulares do mercado.</p>
        </section>
        <section id="produtos">
            <h2>Produtos</h2>
            <p>Aqui você encontrará uma vasta gama de celulares de várias marcas.</p>
        </section>
        <section id="contato">
            <h2>Contato</h2>
            <p>Entre em contato conosco para mais informações.</p>
        </section>
    </div>
    @include('components.footer')

</body>

</html>