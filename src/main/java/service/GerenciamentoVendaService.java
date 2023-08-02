package service;

import model.Cliente;
import model.Venda;
import model.Vendedor;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoVendaService {
    List<Venda> vendasCadastradas;
    ValidacaoService validacaoService;
    public GerenciamentoVendaService(List<Venda> vendasCadastradas, ValidacaoService validacaoService) {

        this.vendasCadastradas = vendasCadastradas;
        this.validacaoService = validacaoService;

    }

    // Método cadastra venda no sistema
    public void cadastrarVenda(String cpfCliente, String cpfVendedor, Double valorVenda) {

        Venda venda = new Venda();

        Cliente cliente = (Cliente) validacaoService.obterPorCpf(cpfCliente);

        Vendedor vendedor = (Vendedor) validacaoService.obterPorCpf(cpfVendedor);

        venda.setCliente(cliente);

        venda.setVendedor(vendedor);

        venda.setValorTotal(valorVenda);

        venda.setDataRegistro(LocalDate.now());

        vendasCadastradas.add(venda);

    }

}