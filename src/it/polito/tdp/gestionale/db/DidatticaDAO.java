package it.polito.tdp.gestionale.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.gestionale.model.Corso;
import it.polito.tdp.gestionale.model.CorsoIdMap;
import it.polito.tdp.gestionale.model.Iscrizione;
import it.polito.tdp.gestionale.model.IscrizioneIdMap;
import it.polito.tdp.gestionale.model.Studente;
import it.polito.tdp.gestionale.model.StudenteIdMap;

public class DidatticaDAO {

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
//	public void getStudentiIscrittiAlCorso(Corso corso, Map<Integer, Studente> mapStudenti) {
//		final String sql = "SELECT studente.matricola FROM iscrizione, studente WHERE iscrizione.matricola=studente.matricola AND codins=?";
//
//		List<Studente> studentiIscrittiAlCorso = new ArrayList<Studente>();
//
//		try {
//			Connection conn = ConnectDB.getConnection();
//			PreparedStatement st = conn.prepareStatement(sql);
//			st.setString(1, corso.getCodins());
//
//			ResultSet rs = st.executeQuery();
//
//			while (rs.next()) {
//				int matricola = rs.getInt("matricola");
//				Studente studente = mapStudenti.get(matricola);
//				if (studente != null) {
//					studentiIscrittiAlCorso.add(studente);
//				} else {
//					System.out.println("ERRORE! Lo studente non è presente!");
//				}
//			}
//
//			corso.setStudenti(studentiIscrittiAlCorso);
//
//		} catch (SQLException e) {
//			// e.printStackTrace();
//			throw new RuntimeException("Errore Db");
//		}
//	}
	
	public List<Studente> getStudentiIscrittiAlCorso(StudenteIdMap studenteIdMap, String codIns) {
		final String sql = "select distinct matricola \n" + 
				"from iscrizione\n" + 
				"where iscrizione.codins=?";

		List<Studente> studentiIscrittiAlCorso = new ArrayList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codIns);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				Studente studente = studenteIdMap.get(rs.getInt("matricola"));
				
				studentiIscrittiAlCorso.add(studente);
			}
			
			return studentiIscrittiAlCorso;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	
	

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi(CorsoIdMap corsoIdMap) {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Corso corso = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				
				
				corsi.add(corsoIdMap.get(corso));
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Ottengo tutti gli studenti salvati nel Db
	 */
	public List<Studente> getTuttiStudenti(StudenteIdMap studenteIdMap) {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Studente s = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
				
				studenti.add(studenteIdMap.get(s));
			}

			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	/*
	 * Ottengo tutte le iscrizioni salvate nel Db
	 */
	public List<Iscrizione> getTutteIscrizioni(IscrizioneIdMap iscrizioneIdMap, CorsoIdMap corsoIdMap, StudenteIdMap studenteIdMap) {

		final String sql = "SELECT * FROM iscrizione";

		List<Iscrizione> iscrizioni= new LinkedList<Iscrizione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Studente studente = studenteIdMap.get(rs.getInt("matricola"));
				
				Corso corso = corsoIdMap.get(rs.getString("codins"));
				
				Iscrizione iscrizione = new Iscrizione(studente, corso);
				
				iscrizioni.add(iscrizione);
			}

			return iscrizioni;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
