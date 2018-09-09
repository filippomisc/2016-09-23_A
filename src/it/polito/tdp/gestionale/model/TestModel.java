package it.polito.tdp.gestionale.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		model.createGraph();
		
//		model.getFrequenzeStudenti();
		System.out.println(model.getFrequenzeStudenti().toString());
		
		System.out.println();
		System.out.println("STATISTICHE");
		System.out.println(model.getStat());
	}

}
