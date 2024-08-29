// Função para preencher o formulário com os dados armazenados no localStorage
function carregarDadosLivro() {
  const livro = JSON.parse(localStorage.getItem("livroParaEditar"));

  if (livro) {
    document.getElementById("livroId").value = livro._id;
    document.getElementById("titulo").value = livro.titulo;
    document.getElementById("autor").value = livro.autor;
    document.getElementById("ano").value = livro.ano;
    document.getElementById("genero").value = livro.genero;
    document.getElementById("submitButton").textContent = "Atualizar Livro";

    // Remove os dados do localStorage após o carregamento
    localStorage.removeItem("livroParaEditar");
  }
}

// Chama a função ao carregar a página
window.onload = carregarDadosLivro;
