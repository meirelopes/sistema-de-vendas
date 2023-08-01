package view;

import model.Cliente;
import model.Venda;
import model.Vendedor;
import service.GerenciamentoVendaService;
import service.ValidacaoService;

import java.util.List;
import java.util.Scanner;

public class GerenciamentoVendaView {

    Scanner scanner;
    ValidacaoService validacaoService;
    GerenciamentoVendaService gerenciamentoVendaService;
    List<Venda> vendasCadastradas;

    public GerenciamentoVendaView(Scanner scanner, ValidacaoService validacaoService,
                                  GerenciamentoVendaService gerenciamentoVendaService, List<Venda> vendasCadastradas) {

        this.scanner = scanner;
        this.validacaoService = validacaoService;
        this.gerenciamentoVendaService = gerenciamentoVendaService;
        this.vendasCadastradas = vendasCadastradas;

    }

    public void cadastrarVenda() {
        boolean cpfEValido = false;
        String cpfCliente;
        String cpfVendedor;
        System.out.println("Informe o CPF do cliente:");
        scanner.nextLine();
        do {
            cpfCliente = registraCpf();
            if (validacaoService.obterPorCpf(cpfCliente) instanceof Cliente) {
                cpfEValido = true;

            } else {
                cpfEValido = false;
                System.out.println("Cpf informado não é de um cliente!");

            }
        } while (!cpfEValido);

        do {
            System.out.println("Informe o CPF do vendedor:");
            cpfVendedor = registraCpf();
            if (validacaoService.obterPorCpf(cpfVendedor) instanceof Vendedor) {

                cpfEValido = true;

            } else {
                cpfEValido = false;

                System.out.println("Cpf informado não é de um vendedor!");

            }


        } while (!cpfEValido);


        Double valorTotal = registraValorTotal();

        gerenciamentoVendaService.cadastrarVenda(cpfCliente, cpfVendedor, valorTotal);

        desejaCadastrarOutraVenda();

    }

    // Testado
    public String registraCpf() {

        boolean evalido = false;

        String cpf;


        do {

            System.out.println("CPF:");

            cpf = scanner.nextLine();


            if (validacaoService.validaCPF(cpf) == false) {

                System.out.println("O CPF informado é inválido.");


            } else if (validacaoService.eCadastradoCpf(cpf) == false) {

                System.out.println("Não cadastrado no sistema!");

            } else {

                evalido = true;
            }


        } while (!evalido);


        return cpf;

    }

    // Testado
        public void desejaCadastrarOutraVenda() {
            boolean valorValido = false;
            int sair;

            do {
                try {
                    System.out.println("Deseja cadastrar outra venda? (Digite 0 para sim ou 1 para não)");

                    String input = scanner.nextLine().trim();

                    if (!input.isEmpty()) {
                        sair = Integer.parseInt(input);

                        if (sair == 1) {
                            return;
                        } else if (sair == 0) {
                            valorValido = true;
                            cadastrarVenda();
                        } else {
                            System.out.println("Valor inválido! Digite 0 ou 1.");
                        }
                    } else {
                        System.out.println("Valor não pode ser vazio! Digite 0 ou 1.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido! Digite um número inteiro.");
                }
            } while (!valorValido);
        }


    public Double registraValorTotal() {
        Double valorTotal = null;

        do {
            try {
                System.out.println("Informe o valor da venda:");

                String entrada = scanner.nextLine();

                entrada = entrada.replace(',', '.'); // Substituir vírgula por ponto (se houver)

                valorTotal = Double.parseDouble(entrada);

            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número válido.");
            }
        } while (valorTotal == null);

        return valorTotal;
    }


    // Método lista todas as vendas cadastradas no sistema

    public void listarVenda() {

        System.out.println("------ VENDAS CADASTRADAS ------");
        for (Venda venda : vendasCadastradas) {
            System.out.println("Id: " + venda.getId());
            System.out.println("Cliente: " + venda.getCliente().getNome());
            System.out.println("Cpf:" + venda.getCliente().getCpf());
            System.out.println("Vendedor: " + venda.getVendedor().getNome());
            System.out.println("Valor total da venda: " + venda.getValorTotal());
            System.out.println("Data: " + venda.getDataRegistro());
            System.out.println("-------------------------------------");

        }

    }


    // Método lista compras de um cliente, levando em conta o cpf;
    public void listarComprasPorCliente() {

        boolean temVendas = false;
        System.out.println("Informe o CPF:");
        String cpfCliente = scanner.nextLine();
        System.out.println("---------- COMPRAS ----------");
        for (Venda venda : vendasCadastradas) {
            if (venda.getCliente().getCpf().equals(cpfCliente)) {
                System.out.println("Data da compra: " + venda.getDataRegistro());
                System.out.println("Valor da compra: " + venda.getValorTotal());
                System.out.println("---------------------------------------");
                temVendas = true;

            }

        }
        if (temVendas == false) {

            System.out.println("Cliente não possui compra!");

        }

    }


    // Método lista vendas de um vendedor, levando em conta o cpf
    public void listarVendasPorVendedor() {

        boolean temVendas = false;
        System.out.println("Informe o CPF:");
        String cpfVendedor = scanner.nextLine();
        System.out.println("---------- VENDAS ----------");
        for (Venda venda : vendasCadastradas) {
            if (venda.getVendedor().getCpf().equals(cpfVendedor)) {
                System.out.println("Data da venda: " + venda.getDataRegistro());
                System.out.println("Valor da venda: " + venda.getValorTotal());
                System.out.println("---------------------------------------");
                temVendas = true;

            }

        }
        if (temVendas == false) {

            System.out.println("Vendedor não possui compra!");

        }
    }


}
