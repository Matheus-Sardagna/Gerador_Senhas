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

    public void adicionarUsuario(int id,String nome, String email, String senha) {
        String sql = "INSERT INTO usuarios (id, nome, email, senha) VALUES (?, ?, ?, ?)";
        try (Connection c = connectionFactory.obtemConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            // Preenche os dados faltantes
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, email);
            ps.setString(4, senha);

            // Executa o comando
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
