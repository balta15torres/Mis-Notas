import javax.swing.*;

public class GameGuessTheNumber {

	public static void main(String[] args) {
		
		int number = (int)(Math.random()*10+1);
		String checkNumber = Integer.toString(number);
		
		System.out.println(checkNumber);
		
		String inputNumber = "";
		
		int counter = 5; 
		
		while(inputNumber.equals(checkNumber) == false) {
			
			inputNumber = JOptionPane.showInputDialog("Juega, ¡SUERTE! \nIntroduce un número del 0 a 10 \nTe quedan " + counter + " intentos.");	
		
			if(inputNumber.equals(checkNumber) == false) {
		
				counter--;
				System.out.println("Sigue probando!! \nllevas " + counter + " intentos!");
				
				if(counter == 0) {
					 
					System.out.println("Perdiste!! Hasta luego!!!");
				}
			
			}
		}
		
		System.out.println("Enorabuena!! Tu número es correcto");
		
	}

}
