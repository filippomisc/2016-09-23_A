package it.polito.tdp.gestionale.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import it.polito.tdp.gestionale.db.DidatticaDAO;

public class Model {

	private DidatticaDAO dao;
	
	private StudenteIdMap studenteIdMap;
	private CorsoIdMap corsoIdMap;
	private IscrizioneIdMap iscrizioneIdMap;
	
	private List<Studente> studenti;
	private List<Corso> corsi;
	private List<Iscrizione> iscrizioni;
	
	private Graph<Nodo, DefaultEdge> graph;
	

	public Model() {
		
		this.dao = new DidatticaDAO();
		
		this.studenteIdMap = new StudenteIdMap();
		this.corsoIdMap = new CorsoIdMap();
		this.iscrizioneIdMap = new IscrizioneIdMap();
		
		this.studenti = dao.getTuttiStudenti(studenteIdMap);
		this.corsi = dao.getTuttiICorsi(corsoIdMap);
		this.iscrizioni = dao.getTutteIscrizioni(iscrizioneIdMap, corsoIdMap, studenteIdMap);
		
		
		}
	
	
	private void createGraph() {
		
	}
	
}
