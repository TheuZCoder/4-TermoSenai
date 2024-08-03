public class Feedback {
    private String cliente;
    private String comentario;
    private int avaliacao; // de 1 a 5

    public Feedback(String cliente, String comentario, int avaliacao) {
        this.cliente = cliente;
        this.comentario = comentario;
        this.avaliacao = avaliacao;
    }

    public String getCliente() {
        return cliente;
    }

    public String getComentario() {
        return comentario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + "\nComentário: " + comentario + "\nAvaliação: " + avaliacao + "\n";
    }
}
