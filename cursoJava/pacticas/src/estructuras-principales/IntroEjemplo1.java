import java.util.*;

import javax.swing.JOptionPane;

public class IntroEjemplo1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre aquí:");
		String name = input.nextLine();
		
		System.out.println("Introduce también tus apellidos:");
		String surname = input.nextLine();
		
		System.out.println("Introduce también tu edad:");
		int age = input.nextInt();
		
		

		//System.out.println("Datos del usuario: " + name + " " + surname + ", " + age + " años." + " ¡¡Gracias por todo TQM bonita!!");
	}

}
