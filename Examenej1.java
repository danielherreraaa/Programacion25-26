package examenud3;

import java.util.Scanner;

class DNIInvalidoException extends Exception{
	public DNIInvalidoException(String mensaje){
	super(mensaje);
}
}	
	public class Examenej1{

	static String leerDNI() throws DNIInvalidoException{
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce tu DNI(8 numeros y una letra)");
		String DNI= sc.nextLine();
	
		if(!DNI.matches("\\d{8}[a-zA-Z]")) {
			throw new DNIInvalidoException( "Formato de DNI inválido. Debe ser 8 números y una letra.");
			}
	
	return DNI;		
}

	 static String cambiarDigito(String dni, int posicion, char nuevoValor)
	            throws DNIInvalidoException {	
		
		  if (posicion<1|posicion>8) {
			  throw new DNIInvalidoException("La posicion tiene que estar entre el 1 y el 8");
			}  
		  if (!Character.isDigit(nuevoValor)) {
		      throw new DNIInvalidoException("El nuevo valor debe ser un dígito (0-9).");
		  }   
		  char[] caracteres = dni.toUpperCase().toCharArray();
		  caracteres[posicion - 1] = nuevoValor;

		  return new String(caracteres);
		  }  
	
	 public static void main(String[]args) {
		 
		 try {
			 String DNI = leerDNI();
			 System.out.println("DNI valido" + DNI.toUpperCase());
		 
		 	 String numeroModificado= cambiarDigito(DNI, 3,'9');
		 	 System.out.println("DNI modificado " + numeroModificado );
		 
		 }catch(DNIInvalidoException e) {
			 System.out.println("Error: " + e.getMessage());
		 }
	 }
}


	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
