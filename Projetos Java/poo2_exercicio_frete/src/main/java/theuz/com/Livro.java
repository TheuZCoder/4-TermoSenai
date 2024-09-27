package theuz.com;

public class Livro extends Produto implements Transportavel {

    private String autor;
    private String editora;
    private String edicaoLimitada;

    public Livro(String nome, double preco, int quantidade, String autor, String editora, String edicaoLimitada) {
        super(nome, preco, quantidade);
        this.autor = autor;
        this.editora = editora;
        this.edicaoLimitada = edicaoLimitada;
    }

    @Override
    public double calcularPeso() {
        double peso = 0.5;
        return peso;
    }

    @Override
    public double calcularFrete() {
        double frete = calcularPeso() * 0.03;
        return frete;
    }
}
