package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Criterios criterios;


    public void definirCriterios(int comprimento, boolean incluirMaiusculas, boolean incluirMinusculas, boolean incluirNumeros, boolean incluirCaracteresEspeciais) {
        this.criterios = new Criterios(comprimento, incluirMaiusculas, incluirMinusculas, incluirNumeros, incluirCaracteresEspeciais);
    }

    public String gerarSenha() {
        GeradorDeSenhas gerador = new GeradorDeSenhas(criterios);
        return gerador.gerarSenha();
    }

    public void adicionarUsuario() {
        // 1: Definir o comando SQL
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        // 2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao();
             // 3: Pré compila o comando
             PreparedStatement ps = c.prepareStatement(sql)) {

            // 4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, senha);

            // 5: Executa o comando
            ps.executeUpdate();  // Use executeUpdate para comandos de inserção
            System.out.println("Usuário adicionado ao banco de dados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar usuário ao banco de dados.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCriterios(Criterios criterios) {
        this.criterios = criterios;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
