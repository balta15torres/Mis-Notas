
public class CalculationsMethods {
	
	public static void main(String[] args) {
		
		//calcular raiz cuadrada
		double raiz = Math.sqrt(9.8);
		
		//redondear un numero
		float num = 1.54F;
		int result = Math.round(num);
		
		double num1 = 1.54;
		double result1 = Math.round(num1);
		
		//refundicion
		double num2 = 1.54;
		int result2 = (int)Math.round(num2);
		
		
		//subir 
		
		double bas = 5;
		double exp = 3;
		
		double result3 = Math.pow(bas,exp);
		int result4 = (int)Math.pow(bas,exp);
		
		System.out.println("El resultado " +  bas + " elevado a " + exp + " es " + result4);
		
	}
}
