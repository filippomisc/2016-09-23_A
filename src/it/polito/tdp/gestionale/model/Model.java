package it.polito.tdp.gestionale.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

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

	private List<Studente> studentiIscrittiAlCorso;
	
	private List<Frequenza> StudentiEFreq;
	

	public Model() {
		
		this.dao = new DidatticaDAO();
		
		this.studenteIdMap = new StudenteIdMap();
		this.corsoIdMap = new CorsoIdMap();
		this.iscrizioneIdMap = new IscrizioneIdMap();
		
		this.studenti = dao.getTuttiStudenti(studenteIdMap);
		this.corsi = dao.getTuttiICorsi(corsoIdMap);
		this.iscrizioni = dao.getTutteIscrizioni(iscrizioneIdMap, corsoIdMap, studenteIdMap);
		
		this.graph = new SimpleGraph<>(DefaultEdge.class);
		
		this.studentiIscrittiAlCorso = new ArrayList<>();
		
		this.StudentiEFreq = new ArrayList<>();
		
		
		}
	
	
	public void createGraph() {
		
		//creo i vertici
		Graphs.addAllVertices(this.graph, studenti);
		Graphs.addAllVertices(this.graph, corsi);
		
		System.out.println(this.graph.vertexSet().size());
		
		
		//creo gli archi
		for(Nodo n : this.graph.vertexSet()) {
			if(n instanceof Corso) {
				
				studentiIscrittiAlCorso = dao.getStudentiIscrittiAlCorso(studenteIdMap, ((Corso) n).getCodins());
				
				for(Studente s : this.studentiIscrittiAlCorso) {
				
				this.graph.addEdge(n, s);
				
				}
			}
		}
		
		System.out.println(this.graph.edgeSet().size());
	}
	
	
	public List<Frequenza> getFrequenzeStudenti() {
		
//		List<Frequenza> StudentiEFreq = new ArrayList<>();
		for(Nodo n : this.graph.vertexSet()) {
			if(n instanceof Studente) {
				int numFrequenza = 0;
				//calcoliamo la frequenza di uno studente
				numFrequenza = dao.getFrequenza(((Studente) n).getMatricola());
				
				if(numFrequenza!=0) {
					
				//creiamo l'oggetto frequenza
				Frequenza f = new Frequenza((Studente) n, numFrequenza);
				
				//aggiungiamolo ad una lista/mappa
				this.StudentiEFreq.add(f);
			
//				System.out.println( ((Studente) n).getMatricola() + " num : " + numFrequenza);
				}
				

			}
			
		}
		
		return this.StudentiEFreq;
	}
	
	public String getStat() {
		String res ="";
		
		res = dao.counteggi().toString();
		
		return res;
	}
	
}
