package service;

import model.Pessoa;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoService {

    List<Pessoa> pessoas;

    public ValidacaoService(List<Pessoa> pessoas) {

        this.pessoas = pessoas;

    }

    // Método verifica se o nome digitado é um número ou valor vazio
    public boolean nomeENumeroOuVazio(String nome) {

        for (char c : nome.toCharArray()) {

            if (!Character.isDigit(c)) {

                return false;

            }
        }
        return true;
    }


    // Método verifica se o CPF contém 11 digitos
    public boolean validaCPF(String cpf) {

        cpf = cpf.replaceAll("\\D+", "");

        if (cpf.length() != 11) {

            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        return true;

    }


    // Método verifica se a pessoa já é cadastrada no sistema recebendo o cpf
    public boolean eCadastradoCpf(String cpf) {

        for (Pessoa pessoa : pessoas) {

            if (pessoa.getCpf().equals(cpf)) {

                return true;

            }

        }

        return false;

    }

    // Método verifica se a pessoa já é cadastrada no sistema recebendo
    public boolean eCadastradoEmail(String email) {

        for (Pessoa pessoa : pessoas) {

            if (pessoa.getEmail().equals(email)) {

                return true;

            }

        }

        return false;

    }

    // Mátodo verifica se e-mail está no formato: xxx@xxx.xxx
    public boolean validaEmail(String email) {

        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    // Método retorna um cliente da lista, levando em conta o cpf
    public Pessoa obterPorCpf(String cpf) {

        for (Pessoa pessoa : pessoas) {

            if (pessoa.getCpf().equals(cpf)) {

                return pessoa;
            }
        }

        return null;

    }

}





