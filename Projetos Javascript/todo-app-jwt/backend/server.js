const express = require('express');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const PORT = 5000;
const JWT_SECRET = 'your_jwt_secret'; // Troque por uma chave secreta mais segura

app.use(cors());
app.use(bodyParser.json());

let users = [];
let todos = [];

// Registro de usuário
app.post('/register', (req, res) => {
  const { username, password } = req.body;
  const hashedPassword = bcrypt.hashSync(password, 10);
  users.push({ username, password: hashedPassword });
  res.status(201).send('User registered');
});

// Login de usuário
app.post('/login', (req, res) => {
  const { username, password } = req.body;
  const user = users.find(u => u.username === username);
  if (user && bcrypt.compareSync(password, user.password)) {
    const token = jwt.sign({ username }, JWT_SECRET, { expiresIn: '1h' });
    res.json({ token });
  } else {
    res.status(401).send('Invalid credentials');
  }
});

// Middleware de autenticação
const authenticateToken = (req, res, next) => {
  const authHeader = req.headers['authorization'];
  const token = authHeader && authHeader.split(' ')[1];
  if (token == null) return res.sendStatus(401);

  jwt.verify(token, JWT_SECRET, (err, user) => {
    if (err) return res.sendStatus(403);
    req.user = user;
    next();
  });
};

// Adicionar uma tarefa
app.post('/todos', authenticateToken, (req, res) => {
  const { task } = req.body;
  todos.push({ task, username: req.user.username });
  res.status(201).send('Task added');
});

// Listar tarefas
app.get('/todos', authenticateToken, (req, res) => {
  const userTodos = todos.filter(t => t.username === req.user.username);
  res.json(userTodos);
});

app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
