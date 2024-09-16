'use client'; 

import { useState } from 'react';
import { useRouter } from 'next/navigation';
import styles from '../page.module.css';
import '../globals.css';

export default function LoginPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const router = useRouter();

  const handleLogin = async () => {
    try {
      // Enviar requisição de login
      const response = await fetch('/api/auth/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      });

      // Verificar se a resposta foi bem-sucedida
      if (response.ok) {
        const { token } = await response.json();
        // Armazenar o token no localStorage
        localStorage.setItem('token', token);
        // Redirecionar para a página de tarefas
        router.push('/tasks');
      } else {
        // Manipular erro retornado pela API
        const errorData = await response.json();
        setError(errorData.message || 'Credenciais inválidas');
      }
    } catch (error) {
      // Manipular erro de rede ou outros erros inesperados
      setError('Erro ao se conectar com o servidor');
    }
  };

  return (
    <div className={styles.container}>
        <div className={styles.authContainer}>
            <h1>Login</h1>
            {error && <p className={styles.errorMessage}>{error}</p>}
            <input
                type="text"
                placeholder="Username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                className={styles.input}
            />
            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                className={styles.input}
            />
            <button onClick={handleLogin} className={styles.button}>
                Login
            </button>
            <p className={styles.text}>
                Não tem uma conta? <a href="/register" className={styles.link}>Registre-se</a>
            </p>
        </div>
    </div>
);
}
