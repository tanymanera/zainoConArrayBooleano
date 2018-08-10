package it.polito.tdp.zaino_boolean;

public class Pezzo {
	private int peso;
	private int costo;
	private String nome;
	public Pezzo(int peso, int costo, String nome) {
		super();
		this.peso = peso;
		this.costo = costo;
		this.nome = nome;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pezzo)) {
			return false;
		}
		Pezzo other = (Pezzo) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s [peso=%d, costo=%d]",nome, peso, costo);
	}
	
	

}
