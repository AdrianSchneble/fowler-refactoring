package src;
import java.lang.*;
import java.util.*;

/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line. Java console
 * applications can not be previewed in the Compiler IDE, only applets can.
 */
public class Program {
	/**
	 * This is the main entry point for the application
	 */

	public static void main(String args[]) {
		String result;
		System.out.println("Welcome to the Movie Store");
		Movie newMovie = new Movie("movie1", PriceCode.NEW_RELEASE);
		Movie childrensMovie = new Movie("movie2", PriceCode.CHILDRENS);
		Rental rentNewMovie10days = new Rental(newMovie, 10);
		Rental rentChildrensMovie5days = new Rental(childrensMovie, 5);
		Customer customerJoe = new Customer("joe");
		customerJoe.addRental(rentNewMovie10days);
		customerJoe.addRental(rentChildrensMovie5days);
		System.out.println("Let's get the Statement");
		result = customerJoe.statement();
		System.out.println(result);
	}
}
