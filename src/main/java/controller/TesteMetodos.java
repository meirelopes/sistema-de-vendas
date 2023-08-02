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

        // Instanciando objetos

        List<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ValidacaoService validacaoService = new ValidacaoService(pessoas);
        ClienteService clienteService = new ClienteService(pessoas, validacaoService);
        VendedorService vendedorService = new VendedorService(pessoas, validacaoService);
        List<Venda> vendasCadastradas = new ArrayList<>();
        PessoaService pessoaService = new PessoaService(pessoas);
        PessoaView pessoaView = new PessoaView(scanner, validacaoService, pessoaService, clienteService, vendedorService);
        GerenciamentoVendaService gerenciamentoVendaService = new GerenciamentoVendaService(vendasCadastradas, validacaoService);
        GerenciamentoVendaView gerenciamentoVendaView = new GerenciamentoVendaView(scanner, validacaoService, gerenciamentoVendaService, vendasCadastradas);
        MenuView menuView = new MenuView(scanner, pessoaView, gerenciamentoVendaView);


        // Criando um cliente e um vendedor para teste

        Pessoa cliente = new Cliente();
        Pessoa vendedor = new Vendedor();

        pessoaService.cadastrar(cliente, "Paulo", "00385346788", "paulo@gmail.com");
        pessoaService.cadastrar(vendedor, "Suzi", "12345678556", "suzi@gmail.com");

        // Imprimindo lista de pessoas

        for (Pessoa pessoa : pessoas) {

            System.out.println(pessoa.getNome());
            System.out.println(pessoa.getCpf());
            System.out.println(pessoa.getEmail());
            System.out.println("--------------------------");

        }

        // Iniciando o sistema

        menuView.iniciarPrograma();

    }

}
