package theuz.com;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Eletronico extends Produto implements Transportavel {
    
    private double volume;

    public Eletronico(String nome, double preco, int quantidade, double volume) {
        super(nome, preco, quantidade);
        this.volume = volume;
    }

    @Override
    public double calcularPeso() {
        double peso = volume * 1.5;
        return peso;
    }

    @Override
    public double calcularFrete() {
        double frete = calcularPeso() * 0.02;
        return frete;
    }
}
