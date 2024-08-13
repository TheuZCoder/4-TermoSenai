@extends('layouts.master')

@section('content')

<div class="container">
    <h1 class="my-4">Detalhes do Produto</h1>

    <div class="form-group">
        <strong>Titulo:</strong>
        {{ $vaga->titulo }}
    </div>

    <div class="form-group">
        <strong>Setor:</strong>
        {{ $vaga->setor }}
    </div>

    <div class="form-group">
        <strong>Descrição:</strong>
        {{ $vaga->descricao }}
    </div>

    <div class="form-group">
        <strong>Remuneração:</strong>
        {{ $vaga->remuneracao }}
    </div>

    <div class="form-group">
        <strong>Empresa:</strong>
        {{ $vaga->empresa }}
    </div>

    <a class="btn btn-primary" href="{{ route('vagas.index') }}">Voltar</a>
</div>
