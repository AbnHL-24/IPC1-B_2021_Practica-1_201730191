import java.util.Scanner;

public class Pistas {
    static Scanner scInt = new Scanner(System.in);
    public static void imprimirPistas() {
        int eleccion;
        do {
        System.out.println("1. Ver la gasolina que requieren las pistas.");
        System.out.println("2. Ver pistas.");
        System.out.println("3. Salir.");
        eleccion = scInt.nextInt();
        if (eleccion == 1) {
            System.out.println("La pista de tierra requiere 80 unidades de gasolina.");
            System.out.println("La pista de arena requiere 90 unidades de gasolina.");
            System.out.println("La pista de concreto requiere 100 unidades de gasolina.");
        } else if (eleccion == 2) {
            System.out.println("\033[31m-----------------------------");
            System.out.println("\033[33m-----------------------------");
            System.out.println("\033[37m-----------------------------");
        }else if (eleccion == 3) {
            //salir
        }else {
            System.out.println("Escoge la opcion correcta.");
        }
        } while (eleccion != 3);
    }
}