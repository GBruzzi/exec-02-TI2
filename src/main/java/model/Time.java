package model;

public class Time {
	private int codigo;
	private String nome;
	private int torcida;
	private int titulos;
	
	public Time() {
		this.codigo = -1;
		this.nome = "";
		this.torcida = -1;
		this.titulos = -1;
	}
	
	public Time(int codigo, String nome, int torcida, int titulos) {
		this.codigo = codigo;
		this.nome = nome;
		this.torcida = torcida;
		this.titulos = titulos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTorcida() {
		return torcida;
	}

	public void setTorcida(int torcida) {
		this.torcida = torcida;
	}

	public int getTitulos() {
		return titulos;
	}

	public void setTitulos(int titulos) {
		this.titulos = titulos;
	}

	@Override
	public String toString() {
		return "Time [codigo=" + codigo + ", nome=" + nome + ", torcida=" + torcida + ", titulos=" + titulos + "]";
	}	
}