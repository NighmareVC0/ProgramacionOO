package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SolEmpresa extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRNC;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCodigo;
	private JTextField txtIdioma;
	private JComboBox cbxArea;
	private JComboBox cbxCarrera;
	private JComboBox cbxCiudad;
	private JComboBox cbxTipoSalario;
	private JSpinner spnSalario;
	private JComboBox cbxContrato;
	private JRadioButton rdbtnLicenciaSi;
	private JRadioButton rdbtnLicenciaNo;
	private JRadioButton rdbtnMudarseSi;
	private JRadioButton rdbtnMudarseNo;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	private ArrayList<String> idiomasAux;
	private JButton btnValidar;
	private JButton btnSolicitar;
	private JButton btnCancelar;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_14;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SolEmpresa()
	{
		idiomasAux = new ArrayList<>();
		setResizable(false);
		setTitle("Registrar Solicitud de Empresa");
		setBounds(100, 100, 613, 830);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JPanel PanelDatos = new JPanel();
			PanelDatos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos:",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PanelDatos.setBounds(10, 11, 561, 203);
			panel.add(PanelDatos);
			PanelDatos.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("RNC:");
				lblNewLabel.setBounds(10, 29, 46, 14);
				PanelDatos.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 72, 65, 14);
				PanelDatos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Telefono:");
				lblNewLabel_2.setBounds(10, 115, 65, 14);
				PanelDatos.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Direccion:");
				lblNewLabel_3.setBounds(10, 158, 65, 14);
				PanelDatos.add(lblNewLabel_3);
			}

			txtRNC = new JTextField();
			txtRNC.addKeyListener(new KeyAdapter()
			{
				@Override
				public void keyTyped(KeyEvent e)
				{
					char c = e.getKeyChar();
					if ((!Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE))
						e.consume();
				}
			});
			txtRNC.setBounds(76, 24, 163, 20);
			PanelDatos.add(txtRNC);
			txtRNC.setColumns(10);
			{
				txtNombre = new JTextField();
				txtNombre.addKeyListener(new KeyAdapter()
				{
					@Override
					public void keyTyped(KeyEvent e)
					{
						char c = e.getKeyChar();
						if ((!Character.isAlphabetic(c) && !(Character.isDigit(c))) && (c != KeyEvent.VK_BACK_SPACE)
								&& (c != KeyEvent.VK_SPACE))
							e.consume();
					}
				});
				txtNombre.setBounds(76, 68, 210, 20);
				PanelDatos.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.addKeyListener(new KeyAdapter()
				{
					@Override
					public void keyTyped(KeyEvent e)
					{
						char c = e.getKeyChar();
						if ((!Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE))
							e.consume();
					}
				});
				txtTelefono.setBounds(76, 112, 163, 20);
				PanelDatos.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBounds(76, 156, 300, 20);
				PanelDatos.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(439, 20, 89, 23);
				PanelDatos.add(btnBuscar);
			}
			{
				JPanel PanelDatosSolicitud = new JPanel();
				PanelDatosSolicitud.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Datos de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				PanelDatosSolicitud.setBounds(10, 225, 561, 252);
				panel.add(PanelDatosSolicitud);
				PanelDatosSolicitud.setLayout(null);
				{
					JLabel lblNewLabel_4 = new JLabel("Contrato:");
					lblNewLabel_4.setBounds(10, 39, 59, 14);
					PanelDatosSolicitud.add(lblNewLabel_4);
				}
				{
					JLabel lblNewLabel_5 = new JLabel("Salario:");
					lblNewLabel_5.setBounds(10, 92, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_5);
				}

				spnSalario = new JSpinner();
				spnSalario.setModel(new SpinnerNumberModel(new Float(1000), new Float(0), null, new Float(500)));
				spnSalario.setBounds(66, 86, 93, 20);
				PanelDatosSolicitud.add(spnSalario);
				{
					JLabel lblNewLabel_6 = new JLabel("Tipo de Salario:");
					lblNewLabel_6.setBounds(286, 92, 127, 14);
					PanelDatosSolicitud.add(lblNewLabel_6);
				}
				{
					JLabel lblNewLabel_7 = new JLabel("Ciudad:");
					lblNewLabel_7.setBounds(10, 145, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_7);
				}
				{
					JLabel lblNewLabel_8 = new JLabel("Puede Mudarse:");
					lblNewLabel_8.setBounds(286, 198, 93, 14);
					PanelDatosSolicitud.add(lblNewLabel_8);
				}
				{
					rdbtnMudarseSi = new JRadioButton("Si");
					rdbtnMudarseSi.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							rdbtnMudarseNo.setSelected(false);
						}
					});
					rdbtnMudarseSi.setBounds(379, 192, 59, 23);
					PanelDatosSolicitud.add(rdbtnMudarseSi);
				}
				{
					rdbtnMudarseNo = new JRadioButton("No");
					rdbtnMudarseNo.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							rdbtnMudarseSi.setSelected(false);
						}
					});
					rdbtnMudarseNo.setBounds(440, 192, 52, 23);
					PanelDatosSolicitud.add(rdbtnMudarseNo);
				}
				{
					JLabel lblNewLabel_9 = new JLabel("Licencia:");
					lblNewLabel_9.setBounds(10, 198, 59, 14);
					PanelDatosSolicitud.add(lblNewLabel_9);
				}
				{
					JRadioButton radioButton = new JRadioButton("SÃ­");
					radioButton.setBounds(6, 347, 52, 23);
					PanelDatosSolicitud.add(radioButton);
				}
				{
					JRadioButton radioButton = new JRadioButton("No");
					radioButton.setBounds(60, 347, 52, 23);
					PanelDatosSolicitud.add(radioButton);
				}
				{
					cbxCiudad = new JComboBox();
					cbxCiudad.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Santiago", "Santo Domingo",
							"Espallat", "La Vega", "San Francisco", "Licey", "Samana", "Higuey" }));
					cbxCiudad.setBounds(66, 139, 147, 20);
					PanelDatosSolicitud.add(cbxCiudad);
				}
				{
					cbxContrato = new JComboBox();
					cbxContrato.setModel(new DefaultComboBoxModel(
							new String[] { "<Selecionar>", "Jornada Completa", "Media Jornada", "Jornada Mixta" }));
					cbxContrato.setBounds(66, 33, 147, 20);
					PanelDatosSolicitud.add(cbxContrato);
				}
				{
					cbxTipoSalario = new JComboBox();
					cbxTipoSalario.setModel(new DefaultComboBoxModel(
							new String[] { "<Selecionar>", "Quincenal", "Mensual", "Semanal", "Diario" }));
					cbxTipoSalario.setBounds(379, 86, 123, 20);
					PanelDatosSolicitud.add(cbxTipoSalario);
				}
				{
					JLabel lblNewLabel_10 = new JLabel("Codigo:");
					lblNewLabel_10.setBounds(286, 39, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_10);
				}
				{
					txtCodigo = new JTextField();
					txtCodigo.setEditable(false);
					txtCodigo.setBounds(379, 33, 123, 20);
					PanelDatosSolicitud.add(txtCodigo);
					txtCodigo.setColumns(10);
				}
				{
					rdbtnLicenciaSi = new JRadioButton("Si");
					rdbtnLicenciaSi.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							rdbtnLicenciaNo.setSelected(false);
						}
					});
					rdbtnLicenciaSi.setBounds(66, 194, 59, 23);
					PanelDatosSolicitud.add(rdbtnLicenciaSi);
				}
				{
					rdbtnLicenciaNo = new JRadioButton("No");
					rdbtnLicenciaNo.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							rdbtnLicenciaSi.setSelected(false);
						}
					});
					rdbtnLicenciaNo.setBounds(127, 194, 52, 23);
					PanelDatosSolicitud.add(rdbtnLicenciaNo);
				}
				{
					JLabel lblNewLabel_12 = new JLabel("Idiomas:");
					lblNewLabel_12.setBounds(286, 145, 59, 14);
					PanelDatosSolicitud.add(lblNewLabel_12);
				}
				{
					txtIdioma = new JTextField();
					txtIdioma.setBounds(342, 139, 86, 20);
					PanelDatosSolicitud.add(txtIdioma);
					txtIdioma.setColumns(10);
				}

				JButton btnAgregarIdioma = new JButton("Agregar");
				btnAgregarIdioma.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						idiomasAux.add(txtIdioma.getText());
						txtIdioma.setText("");
					}
				});
				btnAgregarIdioma.setBounds(449, 138, 86, 23);
				PanelDatosSolicitud.add(btnAgregarIdioma);
			}
			{
				JPanel PanelTipoSolicitud = new JPanel();
				PanelTipoSolicitud.setBorder(
						new TitledBorder(null, "Tipo de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				PanelTipoSolicitud.setBounds(10, 483, 561, 72);
				panel.add(PanelTipoSolicitud);
				PanelTipoSolicitud.setLayout(null);

				rdbtnUniversitario = new JRadioButton("Universatario");
				rdbtnUniversitario.setSelected(true);
				rdbtnUniversitario.setBounds(71, 27, 108, 23);
				PanelTipoSolicitud.add(rdbtnUniversitario);

				rdbtnTecnico = new JRadioButton("Tecnico");
				rdbtnTecnico.setBounds(250, 27, 81, 23);
				PanelTipoSolicitud.add(rdbtnTecnico);

				rdbtnObrero = new JRadioButton("Obrero");
				rdbtnObrero.setBounds(402, 27, 69, 23);
				PanelTipoSolicitud.add(rdbtnObrero);
			}

			JPanel PanelAptidutes = new JPanel();
			PanelAptidutes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Aptitudes:",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PanelAptidutes.setBounds(10, 566, 561, 186);
			panel.add(PanelAptidutes);
			PanelAptidutes.setLayout(null);

			lblNewLabel_11 = new JLabel("Carrera:");
			lblNewLabel_11.setBounds(11, 118, 58, 14);
			PanelAptidutes.add(lblNewLabel_11);
			{
				lblNewLabel_13 = new JLabel("Area:");
				lblNewLabel_13.setBounds(10, 52, 46, 14);
				PanelAptidutes.add(lblNewLabel_13);
			}

			cbxArea = new JComboBox();
			cbxArea.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					if (!cbxArea.getSelectedItem().toString().equalsIgnoreCase("<Selecionar>"))
					{
						cbxCarrera.setEditable(true);
						cbxCarrera.setEnabled(true);

						if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias e Ingenieria"))
							cbxCarrera.setModel(new DefaultComboBoxModel(
									new String[] { "<Selecionar>", "Ing. Ciencias de la Computacion" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias de la Salud"))
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Medicina" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias Administrativas"))
							cbxCarrera.setModel(
									new DefaultComboBoxModel(new String[] { "<Selecionar>", "Direccion Empresarial" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias Humanidades y Artes"))
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Derecho" }));
						else
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>" }));
					}
				}
			});
			cbxArea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Ciencias de la Salud",
					"Ciencias e Ingenier\u00C3\u00ADa", "Ciencias Administrativas", "Ciencias Humanidades y Artes" }));
			cbxArea.setBounds(67, 48, 208, 20);
			PanelAptidutes.add(cbxArea);
			{
				cbxCarrera = new JComboBox();
				cbxCarrera.setEnabled(false);
				cbxCarrera.setBounds(67, 116, 208, 20);
				PanelAptidutes.add(cbxCarrera);
			}

			lblNewLabel_14 = new JLabel("Años:");
			lblNewLabel_14.setBounds(328, 52, 46, 14);
			PanelAptidutes.add(lblNewLabel_14);

			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
			spinner.setBounds(384, 49, 110, 20);
			PanelAptidutes.add(spinner);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnValidar = new JButton("Validar");
			buttonPane.add(btnValidar);
			{
				btnSolicitar = new JButton("Solicitar");
				btnSolicitar.setActionCommand("OK");
				buttonPane.add(btnSolicitar);
				getRootPane().setDefaultButton(btnSolicitar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
