package service;

import model.Pessoa;
import model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class VendedorService {
    List<Pessoa> pessoas;

    ValidacaoService validacaoService;

    public VendedorService(List<Pessoa> pessoas, ValidacaoService validacaoService) {

        this.pessoas = pessoas;
        this.validacaoService = validacaoService;

    }

    //Método lista vendedores cadastrados no sistema
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
