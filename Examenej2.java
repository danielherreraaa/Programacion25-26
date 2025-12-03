package examenud3;
import java.util.Scanner;

public class Examenej2 {

	static void rellenaEncuesta(String[][] encuesta) {
        Scanner sc = new Scanner(System.in);
        int i = 0;

        while (i < encuesta.length) {
            System.out.print("Introduce código postal (o 'fin' para terminar): ");
            String codigoPostal = sc.nextLine();

            if (codigoPostal.equalsIgnoreCase("fin")) {
                break;
            }

            encuesta[i][0] = codigoPostal;

            System.out.print("Introduce edad: ");
            encuesta[i][1] = sc.nextLine();

            System.out.print("Introduce sexo (M/F): ");
            encuesta[i][2] = sc.nextLine().toUpperCase();

            i++;
        }
    }

	static void muestraResultados(String[][] encuesta) {
		System.out.println("--- Resultados de la encuesta ---");
		
		for(int i=0; i<encuesta.length;i++) {
			if (encuesta[i][0]!=null) {
				System.out.println("Codigo postal "+ encuesta[i][0] + ",Edad " +encuesta[i][1] +",Sexo " + encuesta[i][2]);		
			}
		}
	}

	static int calculaMediaEdad(String[][]encuesta, char sexo, int codigoPostal) {
		
		int suma=0;
		int contador=0;
		
		for(int i=0; i<encuesta.length;i++) {
			
			if(encuesta[i][0]!=null) {
				
				 int codPostal = Integer.parseInt(encuesta[i][0]);
	             int edad = Integer.parseInt(encuesta[i][1]);
	             char sxo = encuesta[i][2].charAt(0);
	             
	            if(codPostal==codigoPostal && sxo==Character.toUpperCase(sexo)) {
	            	suma+=sexo;
	            	contador++;
	             }
			}
		}
				if(contador==0)return 0;
				return suma/contador;
}
	 public static void main(String[] args) {

	        String[][] encuesta = new String[500][3];

	        rellenaEncuesta(encuesta);
	        muestraResultados(encuesta);

	        Scanner sc = new Scanner(System.in);

	        System.out.print("\nIntroduce código postal para calcular media: ");
	        int codPostal = Integer.parseInt(sc.nextLine());
	        
	        System.out.println("Introduce sexo (M/F)");
	        char sexo= sc.nextLine().toUpperCase().charAt(0);
	        
	        int media= calculaMediaEdad(encuesta, sexo, codPostal);
	        
	        System.out.println("La media de edad asociada al Codigo Postal "+ codPostal + " y sexo " + sexo + "es: " + media);
	 }
}
