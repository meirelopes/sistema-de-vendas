package controller;

import model.Cliente;
import model.Pessoa;
import model.Venda;
import model.Vendedor;
import service.*;
import view.GerenciamentoVendaView;
import view.MenuView;
import view.PessoaView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteMetodos {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        ValidacaoService validacaoService = new ValidacaoService(pessoas);
        ClienteService clienteService = new ClienteService(pessoas, validacaoService);
        VendedorService vendedorService = new VendedorService(pessoas, validacaoService);

        Cliente cliente = new Cliente();

        Vendedor vendedor = new Vendedor();

        List<Venda> vendasCadastradas = new ArrayList<>();

        PessoaService pessoaService = new PessoaService(pessoas);
        PessoaView pessoaView = new PessoaView(scanner, validacaoService, pessoaService, clienteService, vendedorService);
        GerenciamentoVendaService gerenciamentoVendaService = new GerenciamentoVendaService(cliente, vendedor, vendasCadastradas, validacaoService);
        GerenciamentoVendaView gerenciamentoVendaView = new GerenciamentoVendaView(scanner, validacaoService, gerenciamentoVendaService, vendasCadastradas);
        MenuView menuView = new MenuView(scanner, pessoaView, gerenciamentoVendaView);


        Pessoa cliente1 = new Cliente();
        Pessoa vendedor1 = new Vendedor();

        pessoaService.cadastrar(cliente1, "Meire", "00385713908", "jucemeirelopes@gmail.com");
        pessoaService.cadastrar(vendedor1, "Suzi", "00385713907", "suzi@gmail.com");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
            System.out.println(pessoa.getCpf());
            System.out.println(pessoa.getEmail());

        }

        gerenciamentoVendaView.desajaCadastrarOutraVenda();

        //System.out.println(pessoaView.registraPessoa());
        //menuView.iniciarPrograma();


    }

}
