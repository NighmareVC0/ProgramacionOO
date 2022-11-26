package logico;

public class SoliPersona extends Solicitud
{
	private String cedula;

	public SoliPersona(String codigo, boolean movilidad, String contrato, boolean licencia, String cuidad, float sueldo,
			String cedula)
	{
		super(codigo, movilidad, contrato, licencia, cuidad, sueldo);
		this.cedula = cedula;

	}

	public String getCedula()
	{
		return cedula;
	}

	public void setCedula(String cedula)
	{
		this.cedula = cedula;
	}

	@Override
	public boolean checkEstado()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
