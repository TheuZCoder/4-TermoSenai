// models/User.js
import mongoose from 'mongoose';
import bcrypt from 'bcrypt';

// Definindo o schema do usuário
const userSchema = new mongoose.Schema({
  username: {
    type: String,
    required: true,
    unique: true,
  },
  password: {
    type: String,
    required: true,
  },
  isAdmin: {
    type: Boolean,
    default: false,
  },
});

// Função para criptografar a senha antes de salvar
userSchema.pre('save', async function (next) {
  if (!this.isModified('password')) return next();
  const salt = await bcrypt.genSalt(10);
  this.password = await bcrypt.hash(this.password, salt);
  next();
});

// Criando o modelo de usuário
const User = mongoose.models.User || mongoose.model('User', userSchema);

export default User;
