import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();

        try {
            usuario.adicionarUsuario(1,"exemploNome", "exemploEmail@example.com", "exemploSenha");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao executar a inserção do usuário.");
        }
    }
}

