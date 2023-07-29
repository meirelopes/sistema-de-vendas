package view;

import model.Cliente;

import java.util.Scanner;

public class MenuView {

    Scanner scanner;
    PessoaView pessoaView;


    public void iniciarPrograma() {

        int escolha = 0;

        do {

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastro de cliente/vendedor");
            System.out.println("2 - Cadastrar venda");
            System.out.println("3 - Listar vendedores/cientes");
            System.out.println("4 - Listar vendas por vendedor");
            System.out.println("5 - Listar compras por cliente");
            System.out.println("6 - Listar total de vendas");
            System.out.println("7 - Sair");
            System.out.print("Escolha: ");
            escolha = scanner.nextInt();
            acionaMetodo(escolha);

        } while (escolha < 1 || escolha > 7);

        querContinuar();

    }

    public void acionaMetodo(int escolha) {

        switch (escolha) {

            case 1:

                pessoaView.cadastrarPessoa();
                break;

            case 2:

              //  rebeldeView.atualizaLocalizacao();
                break;

            case 3:

             //   inventarioView.adicionaProduto();
                break;

            case 4:

              //  relatorioView.obterPorcentagemDeRebeldes();
                break;

            case 5:

              //  relatorioView.obterPorcentagemDeTraidores();
                break;

            case 6:

              //  relatorioView.relatarTraidor();
                break;

            case 7:
                System.out.println("Fim!");
                System.exit(0);

        }

    }

    public void querContinuar() {

        int escolha;

        do {

            System.out.println("Deseja realizar outra operação?");
            System.out.println("Digite 1 para sim ou 2 para não");
            escolha = scanner.nextInt();
            if (escolha != 1 && escolha != 2) {

                System.out.println("Opção inválida!");

            } else if (escolha == 1) {

                iniciarPrograma();

            } else if (escolha == 2) {
                System.out.println("Fim!");
                System.exit(0);

            }

        } while (escolha != 1 && escolha != 2);

    }


}
