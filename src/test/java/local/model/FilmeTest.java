package local.model;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.Valid;

public class FilmeTest {
    //TODO: Nome deve possuir entre 2 e 99 caracteres (inclusive)
    
     @Test
    public void nomeIntervaloMinimoDeCaracteres() {
    //intervalo aceitável é de 2 a 99
    
    }
    
      @Test
    public void nomeIntervaloMaximoDeCaracteres() {
    //intervalo aceitável é de 2 a 99
    
    }

    //TODO: Estoque não pode ser negativo, e o máximo é 99 (inclusive)
    @Test
    public void EstoqueNaoPodeNegativo() {

    }
    
      @Test
    public void EstoqueNaoPodePassarLimites() {

    }
   
    //TODO: O preço de Locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99 (inclusive)
    @Test
    public void PrecoMinimoFilme() {

    }
    
     @Test
    public void PrecoMaximoFilme() {

    }
}
