package theuz.com;

import theuz.com.Controller.UsuarioController;

public class Main {
    public static void main(String[] args) {
    
        UsuarioController usuario = new UsuarioController();

        usuario.Read();

        //usuario.createUsuario(new Usuario("adk4", "matheus", 21, "rua 3"));

        //usuario.excluirUsuario("b41d");

       
    }
}