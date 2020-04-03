import javax.swing.*;

public class AccecsApp {

	public static void main(String[] args) {
		
		String chechUser = "";
		chechUser = JOptionPane.showInputDialog("REGISTRO: \nIntroduce nombre del usuario");
		
		String checkPass = "";
		checkPass = JOptionPane.showInputDialog("REGISTRO: \nIntroduce la contraseña");
		
		String user = "";
		
		while(user.equals(chechUser) == false) {
			
			user = JOptionPane.showInputDialog("LOGIN: \nIntroduce nombre del usuario");
			
			if(user.equals(chechUser) == false) {
				System.out.println("LOGIN: \nIntroduce nombre del usuario incorrecto");
			}
			
		}
		
		System.out.println("LOGIN: \nNombre del usuario correcto, ahora vamos con la contraseña");
		
		String password = "";
		
		while(password.equals(checkPass) == false) {
			
			password = JOptionPane.showInputDialog("LOGIN: \nIntroduce la contraseña");
			
			if(password.equals(checkPass) == false) {
				System.out.println("LOGIN: \nContraseña incorrecta");
			}
			
		}
		System.out.println("LOGIN: \nContraseña correcta, Adelante!!!");

	}

}
