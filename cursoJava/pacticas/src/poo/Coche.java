package poo;

public class Coche {
	//Caracteristicas comunes
	private int ruedas,largo,ancho,pesoPlataform,motor;
	
	//Caracteristicas no comunes
	private String color;
	private String climatizador,asientosCuero;
	private int pesoTotal;
	
	//Método Constructor
	public Coche() {
		
		//Caracteristicas comunes
		ruedas = 4 ;
        largo = 2000;
        ancho = 300;
        pesoPlataform = 500;
        motor = 1600;
	}
	
	//Método Getter
	public String getTotalPropiedades() {
		
		return "Todas las propiedades son: \n1.Ruedas: " + ruedas + " unds"+
				"\n2.Largo: "+ largo + " cm" +
				"\n3.Ancho: "+ ancho + " cm"+
				"\n4.Peso plataforma: "+ pesoPlataform + " Kg"+
				"\n5.Potencia Motor: "+ motor + " CC"+
				"\n6.Color: "+ this.color +
				"\n7.¿Tiene asientos de cuero?: "+ this.asientosCuero +
				"\n8.¿Tiene climatizador?: "+ this.climatizador ;
		
	}
	
	//Método Setter 
	public void setColor(String color) {
		this.color = color;
	}
	
	//Método Setter 
		public void setAsientos(String asientosCuero) {
				this.asientosCuero = asientosCuero;
		}
		
	//Método Setter 
		public void setClimatizador(String climatizador) {
				this.climatizador = climatizador;
		}
	

}
