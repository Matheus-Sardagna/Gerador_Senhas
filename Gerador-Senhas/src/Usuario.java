import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario {
    private ConnectionFactory connectionFactory;
    private String nome;
    private String email;
    private String senha;
    private Criterios criterios;


    public Usuario() {
        this.connectionFactory = new ConnectionFactory();
    }
    public void definirCriterios(int comprimento, boolean incluirMaiusculas, boolean incluirMinusculas, boolean incluirNumeros, boolean incluirCaracteresEspeciais) {
        this.criterios = new Criterios(comprimento, incluirMaiusculas, incluirMinusculas, incluirNumeros, incluirCaracteresEspeciais);
    }

    public String gerarSenha() {
        GeradorDeSenhas gerador = new GeradorDeSenhas(criterios);
        return gerador.gerarSenha();
    }

    public void adicionarUsuario() {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection c = connectionFactory.obtemConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, senha);


            ps.executeUpdate();
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
