package entidades;

public class Cliente {
	private int id_cliente;
	private String nombre;
	private String calle;
	private int numero;
	private String codigo_postal;
	private String ciudad;
	private String pais;
	private String email;
	
	public Cliente(int id_cliente, String nombre, String calle, int numero, String codigo_postal, String ciudad,
			String pais, String email) {
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.calle = calle;
		this.numero = numero;
		this.codigo_postal = codigo_postal;
		this.ciudad = ciudad;
		this.pais = pais;
		this.email = email;
	}

	public Cliente(String nombre, String calle, int numero, String codigo_postal, String ciudad, String pais,
			String email) {
		this.nombre = nombre;
		this.calle = calle;
		this.numero = numero;
		this.codigo_postal = codigo_postal;
		this.ciudad = ciudad;
		this.pais = pais;
		this.email = email;
	}

	public Cliente() {
	}
	
	// Setters and getters
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("%-3s %-20s %-20s %-10ds %-20s %-20s %-20s %-20s\n", id_cliente, nombre, calle, numero, codigo_postal, ciudad,
				pais, email);
	}
}
