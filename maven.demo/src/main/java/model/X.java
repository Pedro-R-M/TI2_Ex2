package model;

public class X {
	private int id;
	private String nome;
	
	public X(){
		id = -1;
		nome = "";
	}
	
	public X(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "X [id=" + id + ", nome=" + nome + "]";
	}
}
