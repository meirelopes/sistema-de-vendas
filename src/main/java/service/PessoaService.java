package service;

import model.Pessoa;

import java.util.List;

public class PessoaService {

    List<Pessoa> pessoas;

    public PessoaService(List<Pessoa> pessoas) {

        this.pessoas = pessoas;

    }

    // Método cadastra uma pessoa no sistema que pode ser um cliente ou um vendedor

    public void cadastrar(Pessoa pessoa, String nome, String cpf, String email) {

        pessoa.setNome(nome);

        pessoa.setCpf(cpf);

        pessoa.setEmail(email);

        pessoas.add(pessoa);

        System.out.println("Cadastro realizado com sucesso!");

    }

}
