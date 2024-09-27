package theuz.com;

public class Roupa extends Produto implements Transportavel {
    
    private double peso;
    private double altura;
    private double largura;
    private double comprimento;

    public Roupa(String nome, double preco, int quantidade, double peso, double altura, double largura, double comprimento) {
        super(nome, preco, quantidade);
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    @Override
    public double calcularPeso() {
        double pesoTotal = peso * altura * largura * comprimento;
        return pesoTotal;
    }

    @Override
    public double calcularFrete() {
        double frete = calcularPeso() * 0.01;
        return frete;
    }
    
}
