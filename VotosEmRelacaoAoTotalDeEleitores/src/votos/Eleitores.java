package votos;

public class Eleitores {
	public int totalEleitores = 1000;
	public int votosValidos = 800;
	public int votosBrancos = 150;
	public int votosNulos = 50;

	public int percentualDeVotosValidos() {
		return (votosValidos*100)/totalEleitores;
	}
	
	public int percentualDeVotosBrancos() {
		return (votosBrancos*100)/totalEleitores;
	}
	
	public int percentualDeVotosNulos() {
		return (votosNulos*100)/totalEleitores;
	}
	
}
