<div>
    <h1>Adicionar Produto</h1>
    <form action="{{ route('produtos.store') }}" method="POST">
  
        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" class="form-control">
        </div>
        <div class="form-group">
            <label for="descricao">Descrição</label>
            <input type="text" name="descricao" id="descricao" class="form-control">
        </div>
        <div class="form-group">
            <label for="preco">Preço</label>
            <input type="text" name="preco" id="preco" class="form-control">
        </div>
        <div class="form-group">
            <label for="quantidade">Quantidade</label>
            <input type="text" name="quantidade" id="quantidade" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Adicionar</button>
</div>