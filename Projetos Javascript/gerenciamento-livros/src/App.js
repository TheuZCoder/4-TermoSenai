import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ListaLivros from './Components/ListaLivros';
import NovoLivro from './Components/NovoLivro';
import EditarLivro from './Components/EditarLivro';


function App() {
    return (
        <Router>
            <div className="App">
                <Routes>
                    <Route path="/" element={<ListaLivros />} />
                    <Route path="/novo" element={<NovoLivro />} />
                    <Route path="/editar/:id" element={<EditarLivro />} />
                </Routes>
            </div>
        </Router>
    );
}


export default App;