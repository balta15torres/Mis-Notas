import javax.swing.*;

public class bucles {

	public static void main(String[] args) {
		
		int countArroba = 0;
		
		boolean checkPoint = false;
		
		String mail = JOptionPane.showInputDialog("Introduce mail");
		
		for(int i=0;i<mail.length();i++) {
			
			char letter = mail.charAt(i);
			
			if(letter == '@') {
				
				countArroba++;
				
			}
			if(letter == '.') {
				checkPoint = true;
			}
				
			
		}
			
			if(countArroba == 1 && checkPoint == true) {
				System.out.println("Tu correo es correcto");
			}
			else {
				
				System.out.println("Tu correo es incorrecto");
			}
			
		
	}

}
