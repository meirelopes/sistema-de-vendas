package service;

import model.Cliente;
import model.Venda;
import model.Vendedor;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoVendaService {

    Cliente cliente;

    Vendedor vendedor;

    List<Venda> vendasCadastradas;

    ValidacaoService validacaoService;


    public GerenciamentoVendaService(Cliente cliente, Vendedor vendedor, List<Venda> vendasCadastradas,
                                     ValidacaoService validacaoService) {

        this.cliente = cliente;
        this.vendedor = vendedor;
        this.vendasCadastradas = vendasCadastradas;
        this.validacaoService = validacaoService;

    }


    // Método cadastra vendas
    public void cadastrarVenda(String cpfCliente, String cpfVendedor, Double valorVenda) {

        Venda venda = new Venda();

        venda.setCliente(cliente);

        venda.setVendedor(vendedor);

        venda.setValorTotal(valorVenda);

        venda.setDataRegistro(LocalDate.now());

        vendasCadastradas.add(venda);

    }

}