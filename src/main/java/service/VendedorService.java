package service;

import model.Pessoa;
import model.Vendedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendedorService {
    Scanner scanner = new Scanner(System.in);

    List<Pessoa> pessoas;

    ValidacaoService validacaoService;

    public VendedorService(List<Pessoa> pessoas, ValidacaoService validacaoService) {

        this.pessoas = pessoas;
        this.validacaoService = validacaoService;

    }

    //Método lista vendedores cadastrados
    public List<Vendedor> listaVendedores() {

        List<Vendedor> vendedores = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Vendedor) {
                vendedores.add((Vendedor) pessoa);
            }
        }

        return vendedores;
    }

}
