import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEnvios extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigen;
	private final ButtonGroup grupoOrigen = new ButtonGroup();
	private final ButtonGroup grupoDestino = new ButtonGroup();
	private JTextField txtDestino;
	private JComboBox comboTipo;
	private JRadioButton rdbExtranejro;
	private JRadioButton rdbExtranjeroDest;
	private JSpinner spinnerPeso;
	private JRadioButton rdbNacional;
	private JRadioButton rdbNacionalDest;
	
	public static final double costePOR10KG=3.5;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEnvios frame = new VentanaEnvios();
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
	public VentanaEnvios() {
		setTitle("Calculadora envíos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][70.00][grow][]", "[grow][][::100px][::100px,grow][][::100px,grow][][::100px,grow][][::100px][::100px,grow][][]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		contentPane.add(panel, "cell 0 0 5 1,grow");
		
		JLabel lblNewLabel_6 = new JLabel("Calculadora de Envíos");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Ciudad Origen:");
		contentPane.add(lblNewLabel, "cell 1 2,alignx trailing");
		
		txtOrigen = new JTextField();
		contentPane.add(txtOrigen, "cell 2 2 2 1,growx");
		txtOrigen.setColumns(10);
		
		rdbNacional = new JRadioButton("Nacional");
		rdbNacional.setSelected(true);
		grupoOrigen.add(rdbNacional);
		contentPane.add(rdbNacional, "flowx,cell 2 4 2 1");
		
		JLabel lblNewLabel_1 = new JLabel("Ciudad Destino:");
		contentPane.add(lblNewLabel_1, "cell 1 6");
		
		txtDestino = new JTextField();
		contentPane.add(txtDestino, "cell 2 6 2 1,growx,aligny center");
		
		rdbNacionalDest = new JRadioButton("Nacional");
		rdbNacionalDest.setSelected(true);
		grupoDestino.add(rdbNacionalDest);
		contentPane.add(rdbNacionalDest, "flowx,cell 2 8 2 1");
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de envío:");
		contentPane.add(lblNewLabel_2, "flowx,cell 1 9");
		
		JLabel lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3, "cell 1 9,alignx trailing");
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 - Antes de las 10 h", "Paq 14 - Antes de las 14 h", "Paq 24 - Al día siguiente"}));
		contentPane.add(comboTipo, "cell 2 9 2 1,growx");
		
		rdbExtranejro = new JRadioButton("Extranjero");
		grupoOrigen.add(rdbExtranejro);
		contentPane.add(rdbExtranejro, "cell 2 4 2 1");
		
		rdbExtranjeroDest = new JRadioButton("Extranjero");
		grupoDestino.add(rdbExtranjeroDest);
		contentPane.add(rdbExtranjeroDest, "cell 2 8 2 1");
		
		JLabel lblNewLabel_4 = new JLabel("Peso:");
		contentPane.add(lblNewLabel_4, "cell 1 11");
		
		spinnerPeso = new JSpinner();
		spinnerPeso.setModel(new SpinnerNumberModel(1, 1, 40, 1));
		contentPane.add(spinnerPeso, "flowx,cell 2 11 2 1,alignx left");
		
		JLabel lblNewLabel_5 = new JLabel("Kg");
		contentPane.add(lblNewLabel_5, "cell 2 11 2 1");
		
		JButton btnNewButton = new JButton("Calcular Envío");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculaEnvio();
			}
		});
		contentPane.add(btnNewButton, "cell 0 12 5 1,alignx center");
	}

	protected void calculaEnvio() {
		String origen = txtOrigen.getText();
		String destino = txtDestino.getText();
		String tipo = (String) comboTipo.getSelectedItem();
		
		if (origen==null || origen.isBlank() ||
			destino ==null || destino.isBlank()) {
			JOptionPane.showMessageDialog(contentPane, 
					"Debe rellenar los campos de origen y destino", 
					"Error en los datos", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int peso = (Integer) spinnerPeso.getValue();
		
		
		
//		try {
//			int peso =Integer.parseInt(txtPeso.getText());
//		} catch (NumberFormatException e) {
//			JOptionPane.showMessageDialog(contentPane, 
//					"Debe rellenar los campos de origen y destino", 
//					"Error en los datos", 
//					JOptionPane.ERROR_MESSAGE);
//			if (peso <1 || peso >40 ) {
//				JOptionPane.showMessageDialog(contentPane, 
//						"El peso debe estar entre 1 y 40", 
//						"Error en los datos", 
//						JOptionPane.ERROR_MESSAGE);
//			}
//			return;
//		}
		double precio =7;
		if (rdbNacional.isSelected() && rdbNacional.isSelected()) {
			precio=4;
		}
		
		
		//if (comboTipo.getSelectedIndex()==0)
		if (tipo.equals("Paq 10 - Antes de las 10 h")) {
			precio=precio+5;
		} else if (tipo.equals("Paq 14 - Antes de las 14 h")) {
			precio=precio+2;
		}
		
		precio = precio+(peso/10) *VentanaEnvios.costePOR10KG;
		
		JOptionPane.showMessageDialog(contentPane, 
				"Origen: "+origen+"\nDestino: "+destino
				+"\nTipo:"+tipo+"\nPeso: "+peso+"\nImporte: "+precio 		, 
				"Cálculo", 
				JOptionPane.INFORMATION_MESSAGE);
		
		
	}

}
