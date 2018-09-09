package it.polito.tdp.gestionale.model;

public class Iscrizione {
	
	private int id;
	private Studente studente;
	private Corso corso;
	
	
	public Iscrizione(int id, Studente studente, Corso corso) {
		this.studente = studente;
		this.corso = corso;
		this.id=id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Studente getStudente() {
		return studente;
	}


	public void setStudente(Studente studente) {
		this.studente = studente;
	}


	public Corso getCorso() {
		return corso;
	}


	public void setCorso(Corso corso) {
		this.corso = corso;
	}


	@Override
	public String toString() {
		return "Iscrizione [studente=" + studente + ", corso=" + corso + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Iscrizione other = (Iscrizione) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
