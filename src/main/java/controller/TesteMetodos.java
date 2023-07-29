package controller;

import model.Cliente;
import model.Pessoa;
import service.PessoaService;
import service.ValidacaoService;

import java.util.ArrayList;
import java.util.List;

public class TesteMetodos {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();

        ValidacaoService validacaoService = new ValidacaoService(pessoas);

        PessoaService pessoaService = new PessoaService(pessoas);

        System.out.println(validacaoService.validaEmail("f@gmail.com"));

        //System.out.println(validacaoService.nomeENumeroOuVazio("ff"));

        Pessoa cliente = new Cliente();

        pessoaService.cadastrar(cliente,"Meire", "00385713908", "jucemeirelopes@gmail.com");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
            System.out.println(pessoa.getCpf());
            System.out.println(pessoa.getEmail());

        }

    }

}
