package br.com.gclickapi.model;

public enum Status {
	
	DESATIVADO(0 , "DESATIVADO"),
	ATIVADO(1 , "ATIVADO"),
	SUSPENSO(2 , "SUSPENSO");
	
	Status(int id, String status) {
		this.id = id;
		this.status = status;
	}
	private int id;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
