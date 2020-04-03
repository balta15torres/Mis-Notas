import java.util.Scanner;
import javax.swing.*;

public class Calculadora {

	public static void main(String[] args) {
		
			Scanner calculadora = new Scanner(System.in);
		
			System.out.println("Escribe el número correspondiente de la operacion que quieres realizar: \n"
				+ "1.Sumar \n2.Restar \n3.Multiplicar \n4.Dividir");
		
			int operacion = calculadora.nextInt();
			
			switch(operacion) {
			case 1 :
				String sumar1 = JOptionPane.showInputDialog("Dime el primer Número");
				String sumar2 = JOptionPane.showInputDialog("Dime el segundo Número");
				int s1 = Integer.parseInt(sumar1);
				int s2 = Integer.parseInt(sumar2);
				int resultS = s1 + s2;
				System.out.println("El resultado es => " + resultS);
				break;
			case 2 : 
				String restar1 = JOptionPane.showInputDialog("Dime el primer Número");
				String restar2 = JOptionPane.showInputDialog("Dime el segundo Número");
				int r1 = Integer.parseInt(restar1);
				int r2 = Integer.parseInt(restar2);
				int resultR = r1 - r2;
				System.out.println("El resultado es => " + resultR);
				break;
			case 3 : 
				String multiplicar1 = JOptionPane.showInputDialog("Dime el primer Número");
				String multiplicar2 = JOptionPane.showInputDialog("Dime el segundo Número");
				int m1 = Integer.parseInt(multiplicar1);
				int m2 = Integer.parseInt(multiplicar2);
				int resultM = m1 * m2;
				System.out.println("El resultado es => " + resultM);
				break;
			case 4 : 
				String dividir1 = JOptionPane.showInputDialog("Dime el primer Número");
				String dividir2 = JOptionPane.showInputDialog("Dime el segundo Número");
				int d1 = Integer.parseInt(dividir1);
				int d2 = Integer.parseInt(dividir2);
				double resultD = d1 / d2;
				System.out.println("El resultado es => " + resultD);
				break;
				
			}

	}

}
