package local.model;

import static antlr.Utils.error;
import static antlr.Utils.error;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.Valid;
import local.exception.FilmeException;
import local.exception.FilmeSemEstoqueException;
import local.exception.LocadoraException;
import local.service.LocacaoService;
import local.util.DataUtils;
import static local.util.DataUtils.obterDataComDiferencaDias;
import static org.aspectj.bridge.MessageUtil.error;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import org.junit.Assume;

public class FilmeTest {

    //TODO: Nome deve possuir entre 2 e 99 caracteres (inclusive)
    @Test
    public void nomeMinimoCaracteresCorreto() {
        //intervalo aceitável é de 2 a 99
        //Cenário
        Filme f = new Filme();
        //Validação
        try {
            f.setNome("Zz");
            Assert.fail("Cadastro com 2 caracteres");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("O nome do filme deve possuir entre 2 e 99 caracteres"));
        }
    }

    //TODO: Nome deve possuir entre 2 e 99 caracteres (inclusive)
    @Test
    public void nomeMaximoCaracteresCorreto() {
        //intervalo aceitável é de 2 a 99
        //Cenário
        Filme f = new Filme();
        //Validação
        try {
            String nome = RandomString.make(99);
            f.setNome(nome);
            Assert.fail("Cadastro com 2 caracteres");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("O nome do filme deve possuir entre 2 e 99 caracteres"));
        }
    }

    //TODO: Nome deve possuir entre 2 e 99 caracteres (inclusive)
    @Test
    public void nomeNaoPodeSerMenosQueDois() {
        //intervalo aceitável é de 2 a 99
        //Cenário
        Filme f = new Filme();
        //Validação
        try {
            f.setNome("Z");
            Assert.fail("Cadastro com 1 caracteres");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("O nome do filme deve possuir entre 2 e 99 caracteres"));
        }
    }

    @Test
    public void nomeNaoDeveCemOuMaisCaracteres() {
        //intervalo aceitável é de 2 a 99
        Filme f = new Filme();
        //Validação
        try {
            String nome = RandomString.make(100);
            f.setNome(nome);
            Assert.fail("Cadastro com 100 caracteres");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("O nome do filme deve possuir entre 2 e 99 caracteres"));
        }
    }

    @Test
    public void EstoqueMinimoCorretoDoFilme() {
        //TODO: Estoque não pode ser negativo, e o máximo é 99 (inclusive)
        Filme f = new Filme();
        //Validação
        try {
            Integer estoque = 0;
            f.setEstoque(estoque);
            Assert.fail("Estoque do filme é Menos Zero");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("Estoque não pode ser negativo, e o máximo é 99"));
        }
    }

    @Test
    public void EstoqueNaoPodeNegativo() {
        //TODO: Estoque não pode ser negativo, e o máximo é 99 (inclusive)
        Filme f = new Filme();
        //Validação
        try {
            Integer estoque = -1;
            f.setEstoque(estoque);
            Assert.fail("Estoque do filme é Menos Um");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("Estoque não pode ser negativo, e o máximo é 99"));
        }
    }

    @Test
    public void EstoqueNaoPodeSerCemOuMais() {
        //TODO: Estoque não pode ser negativo, e o máximo é 99 (inclusive)
        Filme f = new Filme();
        //Validação
        try {
            Integer estoque = 100;
            f.setEstoque(estoque);
            Assert.fail("Estoque do filme é 100");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("Estoque não pode ser negativo, e o máximo é 99"));
        }
    }

    @Test
    public void EstoqueMaximoCorretoDoFilme() {
        //TODO: Estoque não pode ser negativo, e o máximo é 99 (inclusive)
        Filme f = new Filme();
        //Validação
        try {
            Integer estoque = 99;
            f.setEstoque(estoque);
            Assert.fail("Estoque do filme é 99");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("Estoque não pode ser negativo, e o máximo é 99"));
        }
    }

    //TODO: O preço de Locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99 (inclusive)
    @Test
    public void PrecoMinimoFilmeNaoPodeSerMenosQueUm() {
        //intervalo aceitável é de 2 a 99
        Filme f = new Filme();
        //Validação
        try {
            Double precoLocacao = 0.99;
            f.setPrecoLocacao(precoLocacao);
            Assert.fail("Preço de locação do filme é 0.99 centavos");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("O preço de locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99"));
        }
    }

    @Test
    public void PrecoMaximoFilmeNaoPodeSerDez() {
        //intervalo aceitável é de 2 a 99
        Filme f = new Filme();
        //Validação
        try {
            Double precoLocacao = 10.00;
            f.setPrecoLocacao(precoLocacao);
            Assert.fail("Preço de locação do filme é 10 reais");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("O preço de locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99"));
        }
    }

    @Test
    public void PrecoMaximoCorretoDoFilme() {
        //intervalo aceitável é de 2 a 99
        Filme f = new Filme();
        //Validação
        try {
            Double precoLocacao = 9.99;
            f.setPrecoLocacao(precoLocacao);
            Assert.fail("Preço de locação do filme é 9.99 reais");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("O preço de locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99"));
        }
    }

    @Test
    public void PrecoMinimoCorretoDoFilme() {
        //intervalo aceitável é de 2 a 99
        Filme f = new Filme();
        //Validação
        try {
            Double precoLocacao = 1.00;
            f.setPrecoLocacao(precoLocacao);
            Assert.fail("Preço de locação do filme é 1 real");
        } catch (FilmeException ex) {
            Assert.assertThat(ex.getMessage(), is("O preço de locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99"));
        }
    }

    /**
    @Test
    public void deveEntregarNaSegundaQuandoAlugarSabado()
            throws FilmeSemEstoqueException, LocadoraException {
        //Cenário
        Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
        Cliente cliente = new Cliente("Angelo");

        //Ação
        Locacao locacao = locacaoService.alugarFilme(cliente, Arrays.asList(
                new Filme("Embalos de sábado a noite", 2, 4.0)));

        //Validação
        boolean isSegunda = DataUtils.verificarDiaSemana(locacao.getDataRetorno(),
                Calendar.MONDAY);
        assertEquals(true, isSegunda);
    }

    @Test
    public void testeDataDeRetorno() throws Exception {
        //cenario
        Assume.assumeTrue(!DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
        LocacaoService locacaoService = new LocacaoService();
        Cliente cliente = new Cliente("Usuario 1");
        Filme filme = new Filme("Filme 1", 1, 5.0);
        List<Filme> filmes = new ArrayList();
        filmes.add(filme);
        //acao
        Locacao locacao = locacaoService.alugarFilme(cliente, filmes);

        //verificacao
        error.checkThat(isMesmaData(locacao.getDataRetorno(),
                obterDataComDiferencaDias(1)), is(true));
    }
**/
}
