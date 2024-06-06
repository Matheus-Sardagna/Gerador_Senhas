import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Tela_acesso frame = new Tela_acesso();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Usuario usuario = new Usuario();
//        String nome = "sadal";
//        String email = "matheussardagna02@gmail.com";
//
//        usuario.definirCriterios(12, true, true, true, true);
//        String senha = usuario.gerarSenha();
//        System.out.println("Senha gerada: " + senha);
//        usuario.setNome(nome);
//        usuario.setEmail(email);
//        usuario.setSenha(senha);
//        usuario.adicionarUsuario();
    }
}



