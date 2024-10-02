package theuz.com.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import theuz.com.Model.Usuario;

public class UsuarioController {
    private final List<Usuario> usuarios;

    public UsuarioController() {
        usuarios = new ArrayList<>();

    }

    public void Read() {
        try {
            URL url = new URL("http://localhost:3000/usuario");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status != 200) {
                throw new Exception("erro de conexão");
            }
            StringBuilder content;
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String linha;
                content = new StringBuilder();
                while ((linha = br.readLine()) != null) {
                    content.append(linha);
                }
            }

            JSONArray dadosUsuarios = new JSONArray(content.toString());
            System.out.println(dadosUsuarios.toString());
            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuario = dadosUsuarios.getJSONObject(i);
                usuarios.add(new Usuario(
                        usuario.getString("id"),
                        usuario.getString("nome"),
                        usuario.getInt("idade"),
                        usuario.getString("endereco")));
            }

            System.out.println(usuarios.toString());

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void createUsuario(Usuario usuario) {
        try {
            URL url = new URL("http://localhost:3000/usuario");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            JSONObject jsonInput = new JSONObject();
            jsonInput.put("nome", usuario.getNome());
            jsonInput.put("idade", usuario.getIdade());
            jsonInput.put("endereco", usuario.getEndereco());
            os.write(jsonInput.toString().getBytes());
            os.flush();
            int status = con.getResponseCode();
            if (status != 201) {
                throw new Exception("Erro de criação");
            }
            StringBuilder response;
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
            System.out.println(response.toString());

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void excluirUsuario(String id) {
        try {
            URL url = new URL("http://localhost:3000/usuario/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            int status = con.getResponseCode();
            if (status != 200) {
                throw new Exception("Erro de exclusão");
            }
            StringBuilder response;
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
            System.out.println(response.toString());
        } catch (Exception e) {
        }
    }
}
