package org.example;

public class Usuario {
    private String nome;
    private String email;
    private Criterios criterios;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void definirCriterios(int comprimento, boolean incluirMaiusculas, boolean incluirMinusculas, boolean incluirNumeros, boolean incluirCaracteresEspeciais) {
        this.criterios = new Criterios(comprimento, incluirMaiusculas, incluirMinusculas, incluirNumeros, incluirCaracteresEspeciais);
    }

    public String gerarSenha() {
        GeradorDeSenhas gerador = new GeradorDeSenhas(criterios);
        return gerador.gerarSenha();
    }
}
