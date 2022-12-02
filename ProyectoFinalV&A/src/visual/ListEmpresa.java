package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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

@SuppressWarnings("serial")
public class ListEmpresa extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnEliminar;
	private JButton btnSalir;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Empresa selected = null;
	private JButton btnModificar;
	private JButton btnListarSolicitudes;

	public ListEmpresa()
	{
		setTitle("Lista de Empresas");
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
					String[] columnas = { "RNC", "Nombre", "Telefono", "Direccion" };
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
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								btnListarSolicitudes.setEnabled(true);
								selected = Bolsa.getInstance().buscarEmpresaByRNC(table.getValueAt(rowSelected, 0).toString());
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (Bolsa.getInstance().isLibreSoliEmp(selected.getRnc()))
						{
							int option;
							option = JOptionPane.showConfirmDialog(null,
									"Esta seguro que desea eliminar a: " + selected.getNombre(), "Confirmacion",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.OK_OPTION)
							{
								Bolsa.getInstance().eliminarEmpresa(selected);
								loadEmpresas();
								btnEliminar.setEnabled(false);
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Error: Empresa vinculada", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);

					}
				});
				{
					btnModificar = new JButton("Modificar");
					btnModificar.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							ModEmpresa mod = new ModEmpresa(selected);
							mod.setModal(true);
							mod.setVisible(true);
						}
					});
					{
						btnListarSolicitudes = new JButton("Solicitudes");
						btnListarSolicitudes.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								ListSoliEspecificas list = new ListSoliEspecificas(null, selected);
								list.setModal(true);
								list.setVisible(true);
							}
						});
						btnListarSolicitudes.setEnabled(false);
						buttonPane.add(btnListarSolicitudes);
					}
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
		loadEmpresas();
	}

	public static void loadEmpresas()
	{
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];

		for (Empresa empresa : Bolsa.getInstance().getEmpresas())
		{
			rows[0] = empresa.getRnc();
			rows[1] = empresa.getNombre();
			rows[2] = empresa.getTelefono();
			rows[3] = empresa.getDireccion();
			model.addRow(rows);
		}
	}
}
