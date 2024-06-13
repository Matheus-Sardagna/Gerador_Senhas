package layoutGrafico1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Email extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email frame = new Email();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Email() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setBackground(Color.DARK_GRAY);
		txtEmail.setToolTipText("");
		txtEmail.setText("Email");
		txtEmail.setBounds(-57, 21, 571, 35);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(133, 114, 226, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite seu email :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 105, 135, 41);
		contentPane.add(lblNewLabel);
		
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				botaoEntrar.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        // Criar uma instância da classe Layout
				        Layout layoutFrame = new Layout();
				        // Tornar a instância visível
				        layoutFrame.setVisible(true);
				        // Fechar o frame atual (Email)
				        dispose();
				    }
				});
			}
		});
		botaoEntrar.setBounds(144, 172, 124, 35);
		contentPane.add(botaoEntrar);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(-24, 230, 524, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
	}

}
