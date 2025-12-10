package ud3;
import java.util.Random;
import java.util.Scanner;
 

public class Quienesquien {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand= new Random();
		
		
		String[] jugadores= {"Messi", "Ronaldo", "Neymar", "Zapater"};
		
		String[][]caracteristicas= {
				{"barcelona", "argentino", "inter miami"},
				{"madrid", "portugues", "arabia"},
				{"psg", "brasileño", "santos"},
				{"zaragoza", "español", "canterano"}
					
				};
				
		int secreto=(int)(Math.random()*jugadores.length);
		
		String adivinar= jugadores[secreto];
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		}
	}

