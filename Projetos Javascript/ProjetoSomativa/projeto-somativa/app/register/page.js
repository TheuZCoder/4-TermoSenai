'use client';


import { useState } from 'react';
import { useRouter } from 'next/navigation';
import styles from '../page.module.css';
import '../globals.css';


export default function RegisterPage() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);
    const router = useRouter();


    const handleRegister = async () => {
        const response = await fetch('/api/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password }),
        });


        if (response.ok) {
            router.push('/tasks');
        } else {
            setError('Erro ao registrar');
        }
    };


    return (
        <div className={styles.container}>
            <div className={styles.authContainer}>
                <h1>Registrar</h1>
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
                <button onClick={handleRegister} className={styles.button}>
                    Registrar
                </button>
                <p className={styles.text}>
                    Já tem uma conta? <a href="/login" className={styles.link}>Faça login</a>
                </p>
            </div>
        </div>
    );
}
