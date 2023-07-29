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

    public PessoaView(ValidacaoService validacaoService, PessoaService pessoaService, Scanner scanner) {

        this.validacaoService = validacaoService;
        this.pessoaService = pessoaService;
        this.scanner = scanner;

    }

    // Método cadastra cliente

    public void cadastrarPessoa() {

        Pessoa pessoa = registraPessoa();
        String nome = registraNome();
        String cpf = registraCpf();
        String email = registraEmail();

        pessoaService.cadastrar(pessoa, nome, cpf, email);

    }


    // Método pede o nome ao usuário e verifica se ele é vazio ou um valor numérico - testado
    public String registraNome() {
        boolean eVazio;

        do {
            System.out.println("Informe o nome:");
            scanner.nextLine();
            String nome = scanner.nextLine();

            eVazio = validacaoService.nomeENumeroOuVazio(nome);

            if (eVazio) {
                System.out.println("Nome não pode ser vazio ou valor numérico!");
            } else {
                return nome;
            }
        } while (eVazio);

        return null;
    }

    // Método pede o cpf ao usuário e verifica se está já registrado no sistema e se está no formato adequado - testado
    public String registraCpf() {

        boolean eCadastradoCpf;

        boolean eValidoCpf;

        do {
            System.out.println("Informe o CPF:");

            String cpf = scanner.nextLine();

            eCadastradoCpf = validacaoService.eCadastradoCpf(cpf);
            eValidoCpf = validacaoService.validaCPF(cpf);

            if (eCadastradoCpf) {

                System.out.println("Já cadastrado no sistema.");

            } else if (eValidoCpf == false) {

                System.out.println("Formato inválido!");

            } else {

                return cpf;
            }

        } while (eCadastradoCpf || eValidoCpf == false);

        return null;
    }


    // Método pede o e-mail ao usuário e verifica se está já registrado no sistema e se está no formato adequado - testado
    public String registraEmail() {

        boolean eCadastradoEmail;

        boolean eValidoEmail;

        do {
            System.out.println("Informe o e-mail:");

            String email = scanner.nextLine();

            eCadastradoEmail = validacaoService.eCadastradoEmail(email);
            eValidoEmail = validacaoService.validaEmail(email);

            if (eCadastradoEmail) {

                System.out.println("Já cadastrado no sistema.");

            } else if (eValidoEmail == false) {

                System.out.println("Formato inválido!");

            } else {

                return email;
            }

        } while (eCadastradoEmail || eValidoEmail == false);

        return null;
    }

    // Método que pergunta ao usuário se ele deseja fazer um novo registro de vendedor ou de cliente.
    // Cria o objeto de acordo com a escolha - testado
    public Pessoa registraPessoa() {

        System.out.println("Digite 1 para cadastrar cliente ou 2 para vendedor:");

        Pessoa pessoa = null;

        int escolha = scanner.nextInt();

        if (escolha == 1) {

            pessoa = new Cliente();

        } else if (escolha == 2) {

            pessoa = new Vendedor();

        } else {

            System.out.println("Valor inválido!");
        }

        return pessoa;

    }


}