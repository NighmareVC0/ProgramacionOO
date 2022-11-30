package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bolsa;
import logico.Empresa;
import logico.Obrero;
import logico.Persona;
import logico.SoliEmpresa;
import logico.SoliPersona;
import logico.Solicitud;
import logico.Tecnico;
import logico.Universitario;

@SuppressWarnings("serial")
public class ListCandidatos extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnSalir;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Solicitud selected = null;
	Persona persona = null;
	Empresa empresa = null;
	private JButton btnSelecionar;
	private SoliEmpresa solicitudEmpresa = null;
	private JButton btnMostrar;

	public ListCandidatos(SoliEmpresa aux)

	{
		solicitudEmpresa = aux;
		setTitle("Lista de Cadidatos");
		setBounds(100, 100, 683, 505);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = { "Codigo", "Cedula", "Nombre", "Tipo", "Area", "Porcentaje" };
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if (rowSelected >= 0)
							{
								btnSelecionar.setEnabled(true);
								btnMostrar.setEnabled(true);
								selected = Bolsa.getInstance()
										.buscarSolicitudByCodigo(table.getValueAt(rowSelected, 0).toString());
							}
						}
					});
					table.setModel(model);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSelecionar = new JButton("Selecionar");
				btnSelecionar.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent e)
					{
						MostrarMatch match = new MostrarMatch((SoliPersona) selected, solicitudEmpresa);
						match.setModal(true);
						match.setVisible(true);
					}
				});
				{
					btnMostrar = new JButton("Mostrar");
					btnMostrar.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							MostrarSolicitud mostrar = new MostrarSolicitud(selected);
							mostrar.setModal(true);
							mostrar.setVisible(true);
						}
					});
					btnMostrar.setEnabled(false);
					buttonPane.add(btnMostrar);
				}
				btnSelecionar.setEnabled(false);
				buttonPane.add(btnSelecionar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}

		}
		loadSolicitudes();

	}

	private void loadSolicitudes()
	{
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Solicitud solicitud : Bolsa.getInstance().getSolicitudes())
		{
			if (solicitud instanceof SoliPersona)
			{
				persona = Bolsa.getInstance().buscarPersonaByCedula(((SoliPersona) solicitud).getCedula());
				float procentaje = Bolsa.getInstance().match(solicitudEmpresa, (SoliPersona) solicitud);

				if (persona != null)
				{
					rows[0] = solicitud.getCodigo();
					rows[1] = ((SoliPersona) solicitud).getCedula();
					rows[2] = persona.getNombre();
					if (solicitud instanceof SoliPersona)
						rows[3] = persona instanceof Universitario ? "Universatario"
								: persona instanceof Tecnico ? "Tecnico" : persona instanceof Obrero ? "Obrero" : "";

					rows[4] = persona instanceof Universitario ? ((Universitario) persona).getCarrera()
							: persona instanceof Tecnico ? ((Tecnico) persona).getArea()
									: persona instanceof Obrero ? "Obrero" : "";

					rows[5] = String.valueOf(procentaje);

					persona = null;

					if (procentaje >= solicitudEmpresa.getPorcentajeMacth() && (solicitud.isActiva()))
						model.addRow(rows);
				}
			}
		}
	}
}