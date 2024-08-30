const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const livroRoutes = require('./src/routes/livroRoutes');
require('dotenv').config();
require('./src/config/database'); // Conectando ao banco de dados
const PORT = process.env.PORT || 3000; // Use a porta do ambiente ou 3000 por padrão

const app = express();

// Middlewares
app.use(bodyParser.json());

// Habilitando CORS para permitir que o front-end interaja com a API
app.use(cors());

// Rotas
app.use('/livros', livroRoutes);

// Configurar a aplicação para escutar na porta especificada
app.listen(PORT, () => {
  console.log(`API está funcionando na porta ${PORT}`);
});

// Exportando a aplicação configurada
module.exports = app;
