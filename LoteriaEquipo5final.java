package reto;


import java.util.Scanner;
import java.util.Random;


//Excepción propia
class GordoException extends Exception {
	//COMPLETAR Daniel
	public GordoException(String mensaje) {
		 super(mensaje); 
}
}

public class LoteriaEquipo5final {	
	
	//devuelve un array de tamaño numBolas con todos los números del sorteo
	public static int[] creaBomboNumeros(int numBolas) {
		//COMPLETAR Daniel y julio
		int[] bombo = new int[numBolas];	
		for (int i = 0; i < numBolas; i++) {
			bombo[i] =i;
		}
		return bombo;
	}
	
	
	
	//devuelve un array de tamaño numPremios con todos los premios del sorteo
	public static String[] creaBomboPremios(int numPremios) {
		String[] bomboPremios = new String[numPremios];
		
		bomboPremios[0]="PRIMER PREMIO";  // gordo de navidad
		bomboPremios[1]="SEGUNDO PREMIO";	// un segundo premio
		
		//COMPLETAR Daniel y julio
		
		// un tercer premio
		bomboPremios[2]="TERCER PREMIO";  // un tercer premio
		
		// dos cuartos premios 
		bomboPremios[3]="CUARTO PREMIO";  // un cuarto premio
		bomboPremios[4]="CUARTO PREMIO";	// un cuarto premio
		// 8 quintos premios Daniel
		for (int i=5; i<13; i++) {
			bomboPremios[i]="QUINTO PREMIO";		
		}
			
		// el resto hasta completar 1.807 premios son "pedrea" Daniel
		for (int i=13; i<numPremios; i++) {
			bomboPremios[i]="pedrea";
		}
		System.out.println("Bombo de premios creado...");
		return bomboPremios;
	}
	
	
	
	
	//devuelve un numero al azar del bombo de números, que será objeto de un premio. Daniel
	//Si un número ya ha salido, no debe volver a salir
	public static int dameNumero(int[] bombo) {
		
		int numAgraciado = (int) (Math.random()*bombo.length);

		// si el número ya había salido, generamos otro al azar
		//COMPLETAR
		while (bombo[numAgraciado]==-1){
			numAgraciado = (int) (Math.random()*bombo.length);
		}
		int numero = bombo[numAgraciado]; 
		// marcamos el número que ha salido con -1 para que no vuelva a salir
		bombo[numAgraciado]=-1;
		//COMPLETAR
		return numero;
	}
	
	
	
	
	
	//devuelve un premio al azar del bombo de premios    Daniel
	//Si un premio ya ha salido, no debe volver a salir
	public static String damePremio(String[] bombo) {
		
		String premio = null;
		
		int indicePremiado = (int) (Math.random()*bombo.length);

		// si el premio ya había salido, generamos otro al azar
		//COMPLETAR
		while (bombo[indicePremiado] == null) {
			indicePremiado = (int) (Math.random()*bombo.length);
		}
		
		// marcamos el premio que ha salido 
		//COMPLETAR
		bombo[indicePremiado]=null;		
		return premio;
	}

	
	
	
	
	
	//Comprueba si un décimo ha sido agraciado y en tal caso indica por consola el premio Daniel
	//Ejemplo: "Agraciado con: pedrea"
	public static String heSidoAgraciado(String[] numerosSorteo, String[] premiosSorteo, String miDecimo){
		String premio="Número no premiado"; //valor por defecto	
		//COMPLETAR
		for (int i=0; i<numerosSorteo.length; i++) {
			if (numerosSorteo[i].equals(miDecimo)) {
				premio = premiosSorteo[i];
			}
		}
		return premio;
	}
	
	
	
	
	//Implementa un bucle para comprobar, haciendo uso del método heSidoAgraciado, si nuestro décimo tiene o no premio      Daniel
	// Debe comprobar que se introducen exactamente 5 dígitos entre el 0 y el 9, por ejemplo 04544
	// Al introducir fin, finaliza la comprobación de décimos
	public static void compruebaDecimos(String[] numerosSorteo, String[] premiosSorteo) throws GordoException{
		Scanner sc=new Scanner(System.in);	
		String miDecimo;
		String miPremio="";
		boolean terminarDeComprobar=false;
		boolean numeroValido=false;
		
		System.out.println("\nCOMPROBACION DE DECIMOS:");
		
		//Compruebo si me ha tocado la lotería
		//COMPLETAR
		while (!terminarDeComprobar) {
			System.out.print("Introduce tu décimo 5 cifras o fin para terminar");
			miDecimo = sc.nextLine();
			
			if (miDecimo.equalsIgnoreCase("fin")){
				terminarDeComprobar = true;
			}
			else if (!miDecimo.matches("\\d[5]")){
				 throw new GordoException("El décimo debe tener 5 dígitos, si no no es valido");
			}
			else{
				miPremio = heSidoAgraciado(numerosSorteo, premiosSorteo, miDecimo);
				System.out.println("Te ha tocado: " + miPremio);
	}	
	}
	}			

	
	
	
	public static void main(String[] args) {
		
		final int MAX_NUMEROS=100000; // números del sorteo
		final int MAX_PREMIOS=1807;   // premios del sorteo
		
		int numeroAgraciado; //número que sale del bombo
		String premio=""; //premio que sale del bombo
		
				
		int[] bomboBolas = new int[MAX_NUMEROS];
		String[] bomboPremios = new String[MAX_PREMIOS];

		String[] listaNumerosSorteo = new String[MAX_PREMIOS]; // lista oficial de números que han salido en el sorteo
		String[] listaPremiosSorteo = new String[MAX_PREMIOS]; // lista oficial de premios que han salido en el sorteo
		
		try {
		
			//Creamos los bombos con sus bolas
			bomboBolas=creaBomboNumeros(MAX_NUMEROS);		
			bomboPremios=creaBomboPremios(MAX_PREMIOS);
			
			//Mostramos el listado completo de números premiados
			System.out.println("\nLISTADO OFICIAL DE PREMIOS:\n");
		
			int j=0;
			for (int i=0;i<MAX_PREMIOS;i++) {
				//Sacamos un número del bombo y lo rellenamos con ceros a la izquierda
				numeroAgraciado=dameNumero(bomboBolas);
				String numeroFormateado=String.format("%05d",numeroAgraciado);
			
				//Sacamos un premio del bombo
				premio=damePremio(bomboPremios);
				
				//Añado el número a la lista oficial del sorteo en la posición j
				listaNumerosSorteo[j]=numeroFormateado;
				
				//Añado el premio a la lista oficial del sorteo en la posición j Daniel 
				listaNumerosSorteo[j]=premio;				
				j++;
				
				System.out.println("Numero:"+numeroFormateado+" agraciado con: "+premio);		
			}
		
			compruebaDecimos(listaNumerosSorteo, listaPremiosSorteo);
		}
		//COMPLETAR (capturar excepción propia) Daniel
		catch(GordoException e) {
			System.out.println("Error : "+e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
			} 
		finally {
			System.out.println("\nSorteo finalizado");			
		}
	}
}





