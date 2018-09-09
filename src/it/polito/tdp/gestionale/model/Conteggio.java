package it.polito.tdp.gestionale.model;

import javax.naming.spi.DirStateFactory.Result;

public class Conteggio {
	
	private int numCorsi;
	private int numIscrittiANCorsi;
	

	public Conteggio(int numCorsi, int numIscrittiANCorsi) {
		this.numCorsi = numCorsi;
		this.numIscrittiANCorsi = numIscrittiANCorsi;
	}
	public int getNumCorsi() {
		return numCorsi;
	}
	public void setNumCorsi(int numCorsi) {
		this.numCorsi = numCorsi;
	}
	public int getNumIscrittiANCorsi() {
		return numIscrittiANCorsi;
	}
	public void setNumIscrittiANCorsi(int numIscrittiANCorsi) {
		this.numIscrittiANCorsi = numIscrittiANCorsi;
	}
	@Override
	public String toString() {
		String res= "";
		if(numIscrittiANCorsi!=1 && numCorsi==1) 
			res = numIscrittiANCorsi + " studenti iscritti a " + numCorsi + " corso";
		if(numIscrittiANCorsi==1 && numCorsi==1)
			res = numIscrittiANCorsi + " studente iscritto a " + numCorsi + " corso";
		if(numIscrittiANCorsi!=1 && numCorsi!=1)
			res = numIscrittiANCorsi + " studenti iscritti a " + numCorsi + " corsi";
		if(numIscrittiANCorsi==1 && numCorsi!=1)
			res = numIscrittiANCorsi + " studente iscritto a " + numCorsi + " corsi";
		return res;	
		
	}
	
	
	

}
