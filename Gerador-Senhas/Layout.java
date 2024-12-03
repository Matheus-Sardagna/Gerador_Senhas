package layoutGrafico1;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Layout extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsuario;
    private JTextField txtSenha;
    private JTextField txtConfirmarSenha;
    private JTextField txtTitulo;
    private JButton btnGerarSenha;
    private JButton btnAtualizar;
    private JButton btnExcluirConta;
    private JButton btnAvancar;
    private JButton btnVoltar;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JTextField textField;

    private boolean useUppercase = false;
    private boolean useLowercase = false;
    private boolean useNumbers = false;
    private boolean useSpecialChars = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Layout frame = new Layout();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Layout() {
        setTitle("Tela de Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(521, 332); // Definindo tamanho fixo da janela
        setResizable(false); // Desabilitando redimensionamento
        setLocationRelativeTo(null); // Centralizando a janela na tela

        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null); // Usando layout absoluto
        setContentPane(contentPane);

        // Título
        txtTitulo = new JTextField();
        txtTitulo.setText("Conta");
        txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtTitulo.setEditable(false);
        txtTitulo.setBackground(Color.DARK_GRAY);
        txtTitulo.setForeground(Color.WHITE);
        txtTitulo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        txtTitulo.setBounds(-34, 11, 534, 45);
        contentPane.add(txtTitulo);

        // Usuário
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsuario.setBounds(10, 85, 80, 25);
        contentPane.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtUsuario.setBounds(100, 85, 200, 25);
        contentPane.add(txtUsuario);

        // Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSenha.setBounds(10, 121, 80, 25);
        contentPane.add(lblSenha);

        txtSenha = new JTextField();
        txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtSenha.setBounds(100, 121, 200, 25);
        contentPane.add(txtSenha);

        // Confirmar Senha
        JLabel setEchoChar = new JLabel("Confirmar Senha:");
        setEchoChar.setFont(new Font("Tahoma", Font.BOLD, 14));
        setEchoChar.setBounds(10, 150, 140, 45);
        contentPane.add(setEchoChar);

        txtConfirmarSenha = new JPasswordField();
        txtConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtConfirmarSenha.setBounds(139, 158, 161, 25);
        ((JPasswordField) txtConfirmarSenha).setEchoChar('*'); // Configurando caractere de eco
        contentPane.add(txtConfirmarSenha);

        // Gerar Senha
        btnGerarSenha = new JButton("Gerar Senha");
        btnGerarSenha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!useUppercase && !useLowercase && !useNumbers && !useSpecialChars) {
                    JOptionPane.showMessageDialog(null, "Selecione pelo menos uma opção.");
                } else {
                    String senhaGerada = gerarSenha();
                    txtSenha.setText(senhaGerada);
                }
            }
        });
        btnGerarSenha.setBackground(UIManager.getColor("ScrollBar.background"));
        btnGerarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGerarSenha.setBounds(321, 78, 120, 25);
        contentPane.add(btnGerarSenha);

        // Opções
        checkBox1 = new JCheckBox("Letras maiúsculas");
        checkBox1.setBackground(Color.LIGHT_GRAY);
        checkBox1.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox1.setBounds(310, 110, 151, 25);
        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                useUppercase = checkBox1.isSelected();
            }
        });
        contentPane.add(checkBox1);

        checkBox2 = new JCheckBox("Letras Minúsculas");
        checkBox2.setBackground(Color.LIGHT_GRAY);
        checkBox2.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox2.setBounds(310, 140, 151, 25);
        checkBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                useLowercase = checkBox2.isSelected();
            }
        });
        contentPane.add(checkBox2);

        checkBox3 = new JCheckBox("Números");
        checkBox3.setBackground(Color.LIGHT_GRAY);
        checkBox3.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox3.setBounds(310, 170, 131, 25);
        checkBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                useNumbers = checkBox3.isSelected();
            }
        });
        contentPane.add(checkBox3);

        checkBox4 = new JCheckBox("Caracteres");
        checkBox4.setBackground(Color.LIGHT_GRAY);
        checkBox4.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox4.setBounds(310, 200, 131, 25);
        checkBox4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                useSpecialChars = checkBox4.isSelected();
            }
        });
        contentPane.add(checkBox4);

        // Botões
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBackground(UIManager.getColor("ScrollBar.background"));
        btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAtualizar.setBounds(10, 207,        100, 25);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso!");
            }
        });
        contentPane.add(btnAtualizar);

        btnExcluirConta = new JButton("Excluir Conta");
        btnExcluirConta.setBackground(UIManager.getColor("ScrollBar.background"));
        btnExcluirConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnExcluirConta.setBounds(120, 207, 140, 25);
        btnExcluirConta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a conta?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");
                }
            }
        });
        contentPane.add(btnExcluirConta);

        // Botão Avançar
        btnAvancar = new JButton("Avançar");
        btnAvancar.setBackground(UIManager.getColor("ScrollBar.background"));
        btnAvancar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAvancar.setBounds(361, 239, 100, 25);
        btnAvancar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(btnAvancar);

        // Botão Voltar
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(UIManager.getColor("ScrollBar.background"));
        btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVoltar.setBounds(251, 239, 100, 25);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Criar uma instância da classe Email
                Email emailFrame = new Email();
                // Tornar a instância visível
                emailFrame.setVisible(true);
                // Fechar o frame atual (Layout)
                dispose();
            }
        });
        contentPane.add(btnVoltar);

        textField = new JTextField();
        textField.setBackground(Color.DARK_GRAY);
        textField.setBounds(-66, 243, 307, 20);
        contentPane.add(textField);
        textField.setColumns(10);
    }

    private String gerarSenha() {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";
        String specialChars = "!@#$%&*()_+-=[]|,./?><";

        SecureRandom random = new SecureRandom();
        List<Character> charList = new ArrayList<>();

        if (useUppercase) {
            for (char c : uppercaseChars.toCharArray()) {
                charList.add(c);
            }
        }
        if (useLowercase) {
            for (char c : lowercaseChars.toCharArray()) {
                charList.add(c);
            }
        }
        if (useNumbers) {
            for (char c : numberChars.toCharArray()) {
                charList.add(c);
            }
        }
        if (useSpecialChars) {
            for (char c : specialChars.toCharArray()) {
                charList.add(c);
            }
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) { // Tamanho da senha = 8
            int randomIndex = random.nextInt(charList.size());
            password.append(charList.get(randomIndex));
        }

        return password.toString();
    }
}

