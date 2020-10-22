package model;

public class Carro {

	
	private String placa;
	private int manobras = 0;
	
	
	
	public Carro() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getManobras() {
		return manobras;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void addManobra() {
		this.manobras += 1;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	
	
	
	
}
