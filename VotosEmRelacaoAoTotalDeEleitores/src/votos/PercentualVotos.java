package votos;

public class PercentualVotos {

	public static void main(String[] args) {
		Eleitores e;
		e = new Eleitores();
		int percentualVotosValidos = e.percentualDeVotosValidos();
		System.out.println(percentualVotosValidos+"% de votos válidos em relação aos eleitores.");
		
		int percentualVotosBrancos = e.percentualDeVotosBrancos();
		System.out.println(percentualVotosBrancos+"% de votos brancos em relação aos eleitores.");
		
		int percentualVotosNulos = e.percentualDeVotosNulos();
		System.out.println(percentualVotosNulos+"% de votos brancos em relação aos eleitores.");
	}
}
