import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tela_acesso extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtSenhaGerada;
    private JButton btnNumCaracteres;
    private JCheckBox chckbxMaiuscula;
    private JCheckBox chckbxMinuscula;
    private JCheckBox chckbxNumero;
    private JCheckBox chckbxEspecial;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tela_acesso frame = new Tela_acesso();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Tela_acesso() {
        setTitle("Tela de acesso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Gerar senha");
        lblNewLabel.setBounds(180, 11, 106, 33);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Quantidade de caracteres");
        lblNewLabel_1.setBounds(207, 86, 200, 14);
        contentPane.add(lblNewLabel_1);

        btnNumCaracteres = new JButton("Gerar");
        btnNumCaracteres.setBackground(Color.WHITE);
        btnNumCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNumCaracteres.setBounds(115, 81, 73, 23);
        contentPane.add(btnNumCaracteres);
        btnNumCaracteres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedValue = JOptionPane.showInputDialog(null, "Selecione a quantidade de caracteres (1-9):");
                if (selectedValue != null && selectedValue.matches("[1-9]")) {
                    btnNumCaracteres.setText(selectedValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido entre 1 e 9.");
                }
            }
        });

        JLabel lblNewLabel_1_1 = new JLabel("Incluir letra maiúscula");
        lblNewLabel_1_1.setBounds(180, 111, 227, 23);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Incluir letra minúscula");
        lblNewLabel_1_1_1.setBounds(180, 138, 227, 19);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Incluir número");
        lblNewLabel_1_2.setBounds(180, 162, 209, 23);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Incluir caractere especial");
        lblNewLabel_1_3.setBounds(180, 190, 209, 14);
        contentPane.add(lblNewLabel_1_3);

        JButton btnGerarSenha = new JButton("Gerar senha");
        btnGerarSenha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numCaracteres = Integer.parseInt(btnNumCaracteres.getText());

                boolean incluirMaiuscula = chckbxMaiuscula.isSelected();
                boolean incluirMinuscula = chckbxMinuscula.isSelected();
                boolean incluirNumero = chckbxNumero.isSelected();
                boolean incluirEspecial = chckbxEspecial.isSelected();

                if (!incluirMaiuscula && !incluirMinuscula && !incluirNumero && !incluirEspecial) {
                    JOptionPane.showMessageDialog(null, "Selecione pelo menos uma opção.");
                    return;
                }

                String senha = gerarSenha(numCaracteres, incluirMaiuscula, incluirMinuscula, incluirNumero, incluirEspecial);
                txtSenhaGerada.setText(senha);
            }
        });
        btnGerarSenha.setBackground(Color.WHITE);
        btnGerarSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnGerarSenha.setBounds(151, 215, 133, 23);
        contentPane.add(btnGerarSenha);

        chckbxMaiuscula = new JCheckBox("");
        chckbxMaiuscula.setBackground(new Color(255, 255, 255));
        chckbxMaiuscula.setBounds(151, 111, 23, 23);
        contentPane.add(chckbxMaiuscula);

        chckbxMinuscula = new JCheckBox("");
        chckbxMinuscula.setBounds(151, 138, 23, 19);
        contentPane.add(chckbxMinuscula);

        chckbxNumero = new JCheckBox("");
        chckbxNumero.setBounds(151, 162, 23, 23);
        contentPane.add(chckbxNumero);

        chckbxEspecial = new JCheckBox("");
        chckbxEspecial.setBounds(151, 185, 23, 23);
        contentPane.add(chckbxEspecial);

        JLabel lblSenhaGerada = new JLabel("Senha gerada :");
        lblSenhaGerada.setBackground(new Color(169, 169, 169));
        lblSenhaGerada.setBounds(141, 45, 200, 23);
        contentPane.add(lblSenhaGerada);

        txtSenhaGerada = new JTextField();
        txtSenhaGerada.setEditable(false);
        txtSenhaGerada.setBounds(221, 46, 149, 20);
        contentPane.add(txtSenhaGerada);
        txtSenhaGerada.setColumns(10);
    }

    private String gerarSenha(int numCaracteres, boolean incluirMaiuscula, boolean incluirMinuscula, boolean incluirNumero, boolean incluirEspecial) {
        String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String especiais = "!@#$%&*";

        StringBuilder caracteres = new StringBuilder();

        if (incluirMaiuscula) caracteres.append(maiusculas);
        if (incluirMinuscula) caracteres.append(minusculas);
        if (incluirNumero) caracteres.append(numeros);
        if (incluirEspecial) caracteres.append(especiais);

        Random random = new Random();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < numCaracteres; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }
}
