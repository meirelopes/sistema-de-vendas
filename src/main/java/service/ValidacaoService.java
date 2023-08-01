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

    // Método verifica se o nome digitado é um número ou valor vazio - testado
    public boolean nomeENumeroOuVazio(String nome) {

        for (char c : nome.toCharArray()) {

            if (!Character.isDigit(c)) {

                return false;

            }
        }
        return true;
    }


    // Método verifica se o CPF contém 11 digitos - testado
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


    // Método verifica se a pessoa já é cadastrada no sistema recebendo o cpf - testado
    public boolean eCadastradoCpf(String cpf) {

        for (Pessoa pessoa : pessoas) {

            if (pessoa.getCpf().equals(cpf)) {

                return true;

            }

        }

        return false;

    }

    // Método verifica se a pessoa já é cadastrada no sistema recebendo o e-mail
    public boolean eCadastradoEmail(String email) {

        for (Pessoa pessoa : pessoas) {

            if (pessoa.getEmail().equals(email)) {

                return true;

            }

        }

        return false;

    }

    public boolean validaEmail(String email) {
        // Definindo a expressão regular para validação do e-mail
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Compilando a expressão regular em um padrão (Pattern)
        Pattern pattern = Pattern.compile(regex);

        // Criando um objeto Matcher para verificar o e-mail com o padrão
        Matcher matcher = pattern.matcher(email);

        // Verificando se o e-mail corresponde ao padrão definido
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





