package local.model;

import local.exception.FilmeException;

public class Filme {

    private String nome;
    private Integer estoque;
    private Double precoLocacao;

    public Filme() {
    }

    public Filme(String nome, Integer estoque, Double precoLocacao) {
        this.nome = nome;
        this.estoque = estoque;
        this.precoLocacao = precoLocacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() < 2 && nome.length() > 99) {
            throw new FilmeException("O nome do filme deve possuir entre 2 e 99 caracteres");
        }
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        if (estoque < 0 && estoque > 99) {
            throw new FilmeException("Estoque não pode ser negativo, e o máximo é 99");
        }
    }

    public Double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(Double precoLocacao) {
        
        if (precoLocacao < 1.00 && precoLocacao > 9.99) {
            throw new FilmeException("O preço de locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99");
        }
    }
}
