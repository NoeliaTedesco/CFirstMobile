package context;

import com.poiji.annotation.ExcelCell;

public class Invitaciones {

	@ExcelCell(value = 0)
	public String nroSocio;

	@ExcelCell(value = 1)
	public String nroCelular;

	@ExcelCell(value = 2)
	public String email;

	@ExcelCell(value = 3)
	public String especialidad;

	@ExcelCell(value = 4)
	public String detalleConsulta;

	@ExcelCell(value = 5)
	public String nombre;

	@ExcelCell(value = 6)
	public String apellido;

	@ExcelCell(value = 7)
	public String FechaNacimiento;

	@ExcelCell(value = 8)
	public String idServicio;

	public Invitaciones() {

	}

	public Invitaciones(String nroSocio, String nroCelular, String especialidad, String detalleConsulta, String nombre,
			String apellido, String fechaNacimiento, String idServicio, String email) {
		this.nroSocio = nroSocio;
		this.nroCelular = nroCelular;
		this.especialidad = especialidad;
		this.detalleConsulta = detalleConsulta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.FechaNacimiento = fechaNacimiento;
		this.idServicio = idServicio;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getNroSocio() {
		return nroSocio;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public String getDetalleConsulta() {
		return detalleConsulta;
	}

	public String getNroCelular() {
		return nroCelular;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public String getIdServicio() {
		return idServicio;
	}

//	@XmlElement
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	@XmlElement
//	public void setNroSocio(String nroSocio) {
//		this.nroSocio = nroSocio;
//	}
//
//	@XmlElement
//	public void setEspecialidad(String especialidad) {
//		this.especialidad = especialidad;
//	}
//
//	@XmlElement
//	public void setNroCelular(String nroCelular) {
//		this.nroCelular = nroCelular;
//	}
//
//	@XmlElement
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	@XmlElement
//	public void setApellido(String apellido) {
//		this.apellido = apellido;
//	}
//
//	@XmlElement
//	public void setFechaNacimiento(String fechaNacimiento) {
//		FechaNacimiento = fechaNacimiento;
//	}
//
//	@XmlElement
//	public void setIdServicio(String idServicio) {
//		this.idServicio = idServicio;
//	}
//
//	@XmlElement
//	public void setDetalleConsulta(String detalleConsulta) {
//		this.detalleConsulta = detalleConsulta;
//	}

}
