package paquete;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 

public class Server { 

	public static void main(String[] args) throws Exception { 
		CalculatorService calculatorService = new CalculatorServiceImpl(); 

		Registry registry = LocateRegistry.createRegistry(1099); 
		registry.bind("CalculatorService", calculatorService); 

		System.out.println("Server started");
		
		int a = 10;
        int b = 5;

        try {
            System.out.println("Suma de " + a + " y " + b + " = " + calculatorService.add(a, b));
            System.out.println("Resta de " + a + " y " + b + " = " + calculatorService.subtract(a, b));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
	} 
} 

