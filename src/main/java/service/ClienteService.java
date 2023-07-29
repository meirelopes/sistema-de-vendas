package service;

import model.Cliente;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    List<Pessoa> pessoas;

    ValidacaoService validacaoService;

    public ClienteService(List<Pessoa> pessoas, ValidacaoService validacaoService) {

        this.pessoas = pessoas;
        this.validacaoService = validacaoService;

    }


    //Método lista clientes cadastrados
    public List<Cliente> listaClientes() {

        List<Cliente> clientes = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Cliente) {
                clientes.add((Cliente) pessoa);
            }
        }

        return clientes;
    }

}
