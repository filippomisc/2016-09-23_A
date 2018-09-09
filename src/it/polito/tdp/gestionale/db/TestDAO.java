package it.polito.tdp.gestionale.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.DynamicAny.DynAnyOperations;

import it.polito.tdp.gestionale.model.Corso;
import it.polito.tdp.gestionale.model.CorsoIdMap;
import it.polito.tdp.gestionale.model.IscrizioneIdMap;
import it.polito.tdp.gestionale.model.Studente;
import it.polito.tdp.gestionale.model.StudenteIdMap;

public class TestDAO {

	public static void main(String[] args) {

		DidatticaDAO dao = new DidatticaDAO();
		
	
		StudenteIdMap studenteIdMap = new StudenteIdMap();
		CorsoIdMap corsoIdMap = new CorsoIdMap();
		IscrizioneIdMap iscrizioneIdMap = new IscrizioneIdMap();
		
		
		System.out.println(dao.getTuttiStudenti(studenteIdMap).size());
		System.out.println(dao.getTuttiICorsi(corsoIdMap).size());
		System.out.println(dao.getTutteIscrizioni(iscrizioneIdMap, corsoIdMap, studenteIdMap).size());
		System.out.println(dao.getStudentiIscrittiAlCorso(studenteIdMap, "03BNTPG").size());
		System.out.println();
		System.out.println(dao.getFrequenza(203404));
		
		System.out.println();
		System.out.println(dao.counteggi());
	}

}
