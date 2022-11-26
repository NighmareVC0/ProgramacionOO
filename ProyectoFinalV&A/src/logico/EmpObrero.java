package logico;

import java.util.ArrayList;

public class EmpObrero extends SoliEmpresa
{
	private ArrayList<String> oficios;

	public EmpObrero(String codigo, boolean movilidad, String contrato, boolean licencia, String cuidad, String rnc,
			float porcentajeMacth, String tipoSalario, float sueldo, int cantidad, ArrayList<String> oficios)
	{
		super(codigo, movilidad, contrato, licencia, cuidad, sueldo, rnc, porcentajeMacth, tipoSalario, cantidad);
		oficios = new ArrayList<String>();
	}

	public ArrayList<String> getOficios()
	{
		return oficios;
	}

	public void setOficios(ArrayList<String> oficios)
	{
		this.oficios = oficios;
	}

}
