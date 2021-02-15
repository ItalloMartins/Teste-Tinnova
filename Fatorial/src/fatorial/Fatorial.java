package fatorial;

public class Fatorial {
	public static void main(String[] args) {
		
		
		int fatorial = 5;
		int f = fatorial;
		System.out.print(fatorial + "! = ");
		while(fatorial>1) {
			f = f*(fatorial-1);
			fatorial--;
			
		}
		System.out.print(f + " ");
	}

}
