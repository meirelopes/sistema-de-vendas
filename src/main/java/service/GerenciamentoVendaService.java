package service;

import model.Cliente;
import model.Venda;
import model.Vendedor;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoVendaService {
    ClienteService clienteService;

    VendedorService vendedorService;

    Cliente cliente;

    Vendedor vendedor;

    List<Venda> vendasCadastradas;

    ValidacaoService validacaoService;


    public GerenciamentoVendaService(ClienteService clienteService, VendedorService vendedorService,
                                     List<Venda> vendasCadastradas, ValidacaoService validacaoService) {

        this.clienteService = clienteService;
        this.vendedorService = vendedorService;
        this.vendasCadastradas = vendasCadastradas;
        this.validacaoService = validacaoService;

    }

    Scanner scanner = new Scanner(System.in);

    // Método cadastra vendas
    public void cadastrarVenda(String cpfCliente, String cpfVendedor, Double valorVenda) {

        Venda venda = new Venda();

        cliente = (Cliente) validacaoService.obterPorCpf(cpfCliente);
        venda.setCliente(cliente);

        vendedor = (Vendedor) validacaoService.obterPorCpf(cpfVendedor);
        venda.setVendedor(vendedor);

        venda.setValorTotal(valorVenda);
        venda.setDataRegistro(LocalDate.now());
        vendasCadastradas.add(venda);

        Double valorTotal = null;

    }


    // Método lista vendas

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