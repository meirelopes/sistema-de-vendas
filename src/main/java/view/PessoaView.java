package view;

import model.Cliente;
import model.Pessoa;
import model.Vendedor;
import service.PessoaService;
import service.ValidacaoService;

import java.util.Scanner;

public class PessoaView {

    Scanner scanner;
    ValidacaoService validacaoService;

    PessoaService pessoaService;

    // Método cadastra cliente

    public void cadastrarPessoa() {

        String nome = registraNome();
        String cpf = registraCpf();
        String email = registraEmail();
        Pessoa pessoa = registraPessoa();

        pessoaService.cadastrar(pessoa, nome, cpf, email);

    }


    public String registraNome() {

        System.out.println("Informe o nome:");

        String nome = scanner.nextLine();

        if (validacaoService.nomeENumeroOuVazio(nome)) {

            System.out.println("Nome não pode ser vaxio ou valor numérico!");

            System.exit(1);

            return null;

        }
        return nome;
    }

    public String registraCpf() {

        System.out.println("Informe o CPF:");

        String cpf = scanner.nextLine();

        if (validacaoService.eCadastradoCpf(cpf)) {

            System.out.println("Já cadastrado no sistema.");

            System.exit(1);

            return null;

        } else if (validacaoService.validaCPF(cpf) == false) {

            System.out.println("O CPF informado é inválido.");

            System.exit(1);

            return null;

        }
        return cpf;
    }


    public String registraEmail() {

        System.out.println("E-mail cliente:");

        String email = scanner.nextLine();
        if (validacaoService.eCadastradoEmail(email)) {

            System.out.println("E-mail já cadastrado.");

            System.exit(1);

            return null;

        } else if (validacaoService.validaEmail(email) == false) {

            System.out.println("O e-mail informado é inválido.");
            System.exit(1);

            return null;

        }

        return email;

    }

    public Pessoa registraPessoa() {

        System.out.println("Digite 1 para cadastrar cliente ou 2 para vendedor:");

        Pessoa pessoa = null;

        int escolha = scanner.nextInt();

        if(escolha == 1) {

            pessoa = new Cliente();

        } else if (escolha == 2) {

            pessoa = new Vendedor();

        } else {

            System.out.println("Valor inválido!");
        }

        return pessoa;

    }



}