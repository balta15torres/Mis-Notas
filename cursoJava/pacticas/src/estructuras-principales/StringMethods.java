
public class StringMethods {

	public static void main(String[] args) {
		
		//varibles Objeto tipo String
		String name = "Baltasar";
		String surname = "Torres";
		
		//ultima letra de name 
		 int indexUltLetter = name.length();
		 char ultLetter = name.charAt(indexUltLetter-1);
		 
		 //2primeras letras de surname
		 String primera2letras = surname.substring(0,2);

		 //Todas las letras de surname menos primera y ultima
		 int length = surname.length();
		 
		 char primera = surname.charAt(1);
		 int index1 = surname.indexOf(primera);
		 
		 char ultimaLetter = surname.charAt(length-1);
		 int index2 = surname.indexOf(ultimaLetter);
		 
		 String resultado = surname.substring(index1,index2);
		 
		 //comparar 2 cadenas
		 String aComparar = "orre";
		 boolean validate = resultado.equalsIgnoreCase(aComparar);

		 System.out.println(validate); 
		 
	}

}
