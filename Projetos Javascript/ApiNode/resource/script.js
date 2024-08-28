const apiUrl = 'http://localhost:3000/livros'; // URL da API

// Função para buscar os livros na API e renderizar na tabela
function buscarLivros() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(livros => {
            const tabelaCorpo = document.getElementById('livrosCorpo');
            tabelaCorpo.innerHTML = '';

            livros.forEach(livro => {
                const linha = document.createElement('tr');

                const idCelula = document.createElement('td');
                

                const tituloCelula = document.createElement('td');
                tituloCelula.textContent = livro.titulo;

                const autorCelula = document.createElement('td');
                autorCelula.textContent = livro.autor;

                const anoCelula = document.createElement('td');
                anoCelula.textContent = livro.ano;

                const generoCelula = document.createElement('td');
                generoCelula.textContent = livro.genero;

                const acoesCelula = document.createElement('td');
                const updateButton = document.createElement('button');
                updateButton.textContent = 'Atualizar';
                updateButton.classList.add('update');
                updateButton.onclick = () => carregarLivro(livro);

                const deleteButton = document.createElement('button');
                deleteButton.textContent = 'Deletar';
                deleteButton.classList.add('delete');
                deleteButton.onclick = () => deletarLivro(livro._id);

                acoesCelula.appendChild(updateButton);
                acoesCelula.appendChild(deleteButton);

                
                linha.appendChild(tituloCelula);
                linha.appendChild(autorCelula);
                linha.appendChild(anoCelula);
                linha.appendChild(generoCelula);
                linha.appendChild(acoesCelula);

                tabelaCorpo.appendChild(linha);
            });
        })
        .catch(error => console.error('Erro ao buscar livros:', error));
}

// Função para adicionar ou atualizar um livro
document.getElementById('livroForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const id = document.getElementById('livroId').value;
    const titulo = document.getElementById('titulo').value;
    const autor = document.getElementById('autor').value;
    const ano = document.getElementById('ano').value;
    const genero = document.getElementById('genero').value;

    const livro = { titulo, autor, ano, genero };

    if (id) {
        // Atualizar livro existente
        fetch(`${apiUrl}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(livro)
        })
        .then(response => {
            if (response.ok) {
                resetForm();
                buscarLivros();
            } else {
                console.error('Erro ao atualizar livro:', response.statusText);
            }
        })
        .catch(error => console.error('Erro ao atualizar livro:', error));
    } else {
        // Adicionar novo livro
        fetch(apiUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(livro)
        })
        .then(response => {
            if (response.ok) {
                resetForm();
                buscarLivros();
            } else {
                console.error('Erro ao adicionar livro:', response.statusText);
            }
        })
        .catch(error => console.error('Erro ao adicionar livro:', error));
    }
});

// Função para deletar um livro
function deletarLivro(id) {
    fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            buscarLivros();
        } else {
            console.error('Erro ao deletar livro:', response.statusText);
        }
    })
    .catch(error => console.error('Erro ao deletar livro:', error));
}

// Função para carregar os dados do livro no formulário para edição
function carregarLivro(livro) {
    document.getElementById('livroId').value = livro._id;
    document.getElementById('titulo').value = livro.titulo;
    document.getElementById('autor').value = livro.autor;
    document.getElementById('ano').value = livro.ano;
    document.getElementById('genero').value = livro.genero;
    document.getElementById('submitButton').textContent = 'Atualizar Livro';
}

// Função para resetar o formulário
function resetForm() {
    document.getElementById('livroId').value = '';
    document.getElementById('titulo').value = '';
    document.getElementById('autor').value = '';
    document.getElementById('ano').value = '';
    document.getElementById('genero').value = '';
    document.getElementById('submitButton').textContent = 'Adicionar Livro';
}

// Chama a função para buscar e renderizar os livros ao carregar a página
window.onload = buscarLivros;
