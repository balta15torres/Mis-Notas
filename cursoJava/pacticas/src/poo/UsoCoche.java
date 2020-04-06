package poo;
import javax.swing.*;

public class UsoCoche {

	public static void main(String[] args) {
		
		//Objeto instanciado
		Coche miCoche = new Coche();
		
		//Establecemos valores de propiedades pasando al los Setter params 
		String color = "";
		color = JOptionPane.showInputDialog("Introduce color del coche");
		miCoche.setColor(color);
		
		
		String asientosCuero = "";
		asientosCuero = JOptionPane.showInputDialog("¿Añadimos asientos de cuero?");
		miCoche.setAsientos(asientosCuero);
		
		String climatizador = "";
		climatizador = JOptionPane.showInputDialog("¿Añadimos climatizador?");
		miCoche.setClimatizador(climatizador);
		
		System.out.println(miCoche.getTotalPropiedades());
		

	}

}
