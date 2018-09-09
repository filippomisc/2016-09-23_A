package it.polito.tdp.gestionale.model;

import java.util.HashMap;
import java.util.Map;


public class IscrizioneIdMap {
	
private Map<Integer, Iscrizione> map;
	
	public IscrizioneIdMap() {
		map = new HashMap<>();
	}
	
	public Iscrizione get(int codIns) {
		return map.get(codIns);
	}
	
	public Iscrizione get(Iscrizione iscrizione) {
		Iscrizione old = map.get(iscrizione.getId());
		if (old == null) {
			map.put(iscrizione.getId(), iscrizione);
			return iscrizione;
		}
		return old;
	}
	
	public void put(Iscrizione iscrizione, int codIns) {
		map.put(codIns, iscrizione);
	}

}
