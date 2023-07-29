package service_teste;

import org.junit.Assert;
import org.junit.Test;
import service.ValidacaoService;

public class ValidacaoServiceTest {

    private  ValidacaoService validacaoService = new ValidacaoService();


    //Metodo que verifica se o nome é um número ou vazio
    @Test
    public void verificaSeNomeENumeroOuVazio (){

        String nome = "123456";

        boolean nomeEVazioOuNumero = validacaoService.nomeENumeroOuVazio(nome);

        Assert.assertTrue(nomeEVazioOuNumero);

    }


    // Método verifica se o CPF contém 11 digitos
    @Test
    public void verificaSeCpfTem11DigitosESeNaoSaoTodosIguais() {

        String cpf = "12345678901";

        boolean cpfTem11DigitosESeNaoSaoTodosIguais = validacaoService.validarCPF(cpf);

        Assert.assertTrue(cpfTem11DigitosESeNaoSaoTodosIguais);

    }

}

