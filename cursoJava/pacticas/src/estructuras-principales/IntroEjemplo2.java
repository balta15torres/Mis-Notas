import javax.swing.JOptionPane;

public class IntroEjemplo2 {

	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("Dime tu nombre");
		
		String age = JOptionPane.showInputDialog("Dime tu edad");
		
		int newAge = Integer.parseInt(age);
		newAge++;
		
		
		System.out.println("Hola " + name + " el año que viene tendrás " + newAge + " años");

	}

}
