import java.util.*;

public class Condicional {

	public static void main(String[] args) {
		
		Scanner porteroDisco = new Scanner(System.in);
		
		System.out.println("Introduce tu edad:");
		
		int age = porteroDisco.nextInt();
		
		String result;
		
		if(age>=18) {
			result = "Eres mayor de edad,puedes pasar. ¡¡PASALO BIEN!!";
		}
		else {
			result = "Eres menor de edad, ¡¡PIRATE!!";
		}
		
		System.out.println(result);
		
	}

}
