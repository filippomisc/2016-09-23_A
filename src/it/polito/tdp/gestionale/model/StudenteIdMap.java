package it.polito.tdp.gestionale.model;

import java.util.HashMap;
import java.util.Map;

public class StudenteIdMap {
	
private Map<Integer, Studente> map;
	
	public StudenteIdMap() {
		map = new HashMap<>();
	}
	
	public Studente get(int matricola) {
		return map.get(matricola);
	}
	
	public Studente get(Studente studente) {
		Studente old = map.get(studente.getMatricola());
		if (old == null) {
			map.put(studente.getMatricola(), studente);
			return studente;
		}
		return old;
	}
	
	public void put(Studente studente, int matricola) {
		map.put(matricola, studente);
	}

}
