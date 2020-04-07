package poo;
import java.util.*;

public class CrearEmpleado {

	public static void main(String[] args) {
		
		Empleado[] empleados = new Empleado[3];
		
		empleados[0] = new Empleado("Baltasar", 21000, 1998, 2, 7);
		empleados[1] = new Empleado("Amelia", 25000, 2000, 9, 19);
		empleados[2] = new Empleado("Paco", 18000, 2003, 11, 27);
		
		for(Empleado emple:empleados) {
			
			empleados[0].setSeccion("Desarrolo");
			empleados[1].setSeccion("RRHH");
	
			
			String resultado = emple.getDatosEmpleado();
			
			System.out.println(resultado);
		}
		
		String siguiente = Empleado.getIdSig();
		System.out.println(siguiente);
	}
}

class Empleado{
	
	private final String name;
	private double sueldo;
	private final Date altaContrato;
	private String seccion;
	private int id;
	private static int idSig = 1;
	
	//Contructor
	public Empleado(String name, double suel, int ano, int mes, int dia) {
		
	this.name = name;
	this.sueldo = suel;
	this.seccion = "Administracion";
	id=idSig;
	idSig++;
	
	 GregorianCalendar fechaAlta = new GregorianCalendar(ano,mes-1, dia);		
	 this.altaContrato = fechaAlta.getTime();
	}
	
	public void setSeccion(String nombre) {
		
		this.seccion = nombre;
	}
	
	public String getDatosEmpleado() {
		
		return "Datos de Empleado: "+ 
				"\n-Id: "+id+
				"\n-Nombre: "+ this.name +
				"\n-Sueldo: "+ this.sueldo + " Euros"+
				"\n-Alta de contrato: "+ this.altaContrato +
				"\n-Su Seccion: "+this.seccion +
				"\n";		
	}
	
	public static String getIdSig() {
		
		return "El Id siguiente es: " + idSig; 
	}
	
	
}
