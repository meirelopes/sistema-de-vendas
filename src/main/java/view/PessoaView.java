package view;

import model.Cliente;
import model.Pessoa;
import model.Vendedor;
import service.ClienteService;
import service.PessoaService;
import service.ValidacaoService;
import service.VendedorService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PessoaView {
    Scanner scanner;
    ValidacaoService validacaoService;
    PessoaService pessoaService;
    ClienteService clienteService;
    VendedorService vendedorService;

    public PessoaView(Scanner scanner, ValidacaoService validacaoService, PessoaService pessoaService
            , ClienteService clienteService, VendedorService vendedorService) {

        this.scanner = scanner;
        this.validacaoService = validacaoService;
        this.pessoaService = pessoaService;
        this.clienteService = clienteService;
        this.vendedorService = vendedorService;

    }

    // Método cadastra pessoa no sistema podendo ser um vendedor ou um cliente

    public void cadastrarPessoa() {

        Pessoa pessoa = registraPessoa();
        String nome = registraNome();
        String cpf = registraCpf();
        String email = registraEmail();

        pessoaService.cadastrar(pessoa, nome, cpf, email);
        desajaCadastrarOutraPessoa();

    }


    // Método pede o nome ao usuário e verifica se ele é vazio ou um valor numérico
    public String registraNome() {

        boolean eVazio;

        do {
            System.out.println("Informe o nome:");

            String nome = scanner.nextLine();

            scanner.nextLine();

            eVazio = validacaoService.nomeENumeroOuVazio(nome);

            if (eVazio) {

                System.out.println("Nome não pode ser vazio ou valor numérico!");

            } else {

                return nome;

            }

        } while (eVazio);

        return null;
    }

    // Método pede o cpf ao usuário e verifica se está já registrado no sistema e se está no formato adequado
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


    // Método pede o e-mail ao usuário e verifica se está já registrado no sistema e se está no formato adequado
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

    // Cria o objeto de acordo com a escolha do usuário
    public Pessoa registraPessoa() {

        int escolha;

        boolean entradaValida = false;

        Pessoa pessoa = null;

        do {

            try {

                System.out.println("Digite 1 para cadastrar cliente ou 2 para vendedor:");

                escolha = scanner.nextInt();

                if (escolha == 1) {

                    entradaValida = true;

                    pessoa = new Cliente();

                } else if (escolha == 2) {

                    entradaValida = true;

                    pessoa = new Vendedor();

                } else {

                    System.out.println("Valor inválido!");
                }

            } catch (InputMismatchException e) {

                System.out.println("Valor inválido. Digite um número inteiro de 1 a 2.");

                scanner.nextLine();
            }
        }

        while (!entradaValida);

        return pessoa;

    }

    // Método para usuário escolher se deseja exibir lista de clientes ou lista de vendedores

    public void listaClientesOuVendedores() {

        int escolha;

        boolean entradaValida = false;

        do {

            try {

                System.out.println("Digite 1 para listar clientes cadastrados ou 2 para vendedores cadastrados:");

                escolha = scanner.nextInt();

                if (escolha == 1) {

                    entradaValida = true;

                    listaClientes();

                } else if (escolha == 2) {

                    entradaValida = true;

                    listarVendedores();

                } else {

                    System.out.println("Valor inválido!");

                }

            } catch (InputMismatchException e) {

                System.out.println("Valor inválido. Digite um número inteiro de 1 a 2.");

                scanner.nextLine();
            }
        }

        while (!entradaValida);

    }


    // Método exibe lista de clientes
    public void listaClientes() {

        List<Cliente> clientes = clienteService.listaClientes();
        for (Cliente cliente : clientes) {

            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getEmail());
            System.out.println("-----------------------------------");

        }

    }

    // Método exibe lista de vendedores
    public void listarVendedores() {

        List<Vendedor> vendedores = vendedorService.listaVendedores();

        for (Vendedor vendedor : vendedores) {

            System.out.println(vendedor.getNome());
            System.out.println(vendedor.getCpf());
            System.out.println(vendedor.getEmail());
            System.out.println("-----------------------------------");

        }

    }


    // Método pergunta se usuário deseja realizar outro cadastro
    public void desajaCadastrarOutraPessoa() {

        int sair;

        boolean entradaValida = false;

        do {

            try {

                System.out.println("Deseja realizar outro cadastro? (Digite 0 para sim ou 1 para não)");

                sair = scanner.nextInt();

                scanner.nextLine();

                if (sair == 1) {

                    return;

                } else if (sair == 0) {

                    entradaValida = true;

                    cadastrarPessoa();

                } else {

                    System.out.println("Valor inválido.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Valor inválido. Digite 0 ou 1.");

                scanner.nextLine();
            }

        } while (!entradaValida);

    }

}