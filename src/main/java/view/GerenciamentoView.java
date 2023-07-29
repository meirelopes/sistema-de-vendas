package view;

import model.Cliente;
import model.Venda;
import model.Vendedor;
import service.GerenciamentoVendaService;
import service.PessoaService;
import service.ValidacaoService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciamentoView {

    Scanner scanner;
    PessoaView pessoaView;
    ValidacaoService validacaoService;
    PessoaService pessoaService;
    GerenciamentoVendaService gerenciamentoVendaService;



    public void cadastrarVenda() {

        String cpfCliente = registraCpf();

        String cpfVendedor = registraCpf();

        Double valorTotal = registraValorTotal();

        gerenciamentoVendaService.cadastrarVenda(cpfCliente, cpfVendedor, valorTotal);

        desajaCadastrarOutraVenda();

    }


    public String registraCpf() {

        System.out.println("Informe o cpf:");

        String cpf = scanner.nextLine();

        if (validacaoService.validaCPF(cpf) == false) {

            System.out.println("O CPF informado é inválido.");


        } else if (validacaoService.eCadastradoCpf(cpf) == false) {

            System.out.println("Não cadastrado no sistema!");

        }

        return cpf;

    }

    public void desajaCadastrarOutraVenda() {

        int sair;

        do {
            System.out.println("Deseja cadastrar outro venda? (Digite 0 para sim ou 1 para não)");

            sair = scanner.nextInt();

            scanner.nextLine();

        } while (sair != 0 && sair != 1);

        if (sair == 1) {

            return;

        } else if (sair == 0) {

            cadastrarVenda();
        }
    }

    public Double registraValorTotal() {

        Double valorTotal = null;

        do {

            try {
                System.out.println("Informe o valor da venda:");

                String entrada = scanner.nextLine();

                valorTotal = Double.parseDouble(entrada);

                if (Double.isNaN(valorTotal)) {

                    throw new InputMismatchException("Valor inválido!");

                }

            } catch (InputMismatchException | NumberFormatException e) {

                System.out.println(e.getMessage());

                valorTotal = null;

            }

        } while (valorTotal == null);

        return valorTotal;

    }
}
