package it.polito.tdp.gestionale.model;

import java.util.HashMap;
import java.util.Map;

public class CorsoIdMap {

private Map<String, Corso> map;
	
	public CorsoIdMap() {
		map = new HashMap<>();
	}
	
	public Corso get(String id) {
		return map.get(id);
	}
	
	public Corso get(Corso corso) {
		Corso old = map.get(corso.getCodins());
		if (old == null) {
			map.put(corso.getCodins(), corso);
			return corso;
		}
		return old;
	}
	
	public void put(Corso corso, String id) {
		map.put(id, corso);
	}
}
