package it.polito.tdp.gestionale.model;

public class Frequenza {
	
	private Studente studente;
	private int corsiFrequentati;
	
	
	public Frequenza(Studente studente, int corsiFrequentati) {
		this.studente = studente;
		this.corsiFrequentati = corsiFrequentati;
	}
	
	public Studente getStudente() {
		return studente;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public int getCorsiFrequentati() {
		return corsiFrequentati;
	}
	public void setCorsiFrequentati(int corsiFrequentati) {
		this.corsiFrequentati = corsiFrequentati;
	}

	@Override
	public String toString() {
		return studente + " corsiFrequentati: " + corsiFrequentati +"\n";
	}

//	@Override
//	public String toString() {
//		return studente.getNome() + " " + studente.getCognome() + " Frequenza: " + corsiFrequentati;
//	}
	
	

}
