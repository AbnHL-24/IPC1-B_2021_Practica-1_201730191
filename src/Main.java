import java.util.Scanner;

public class Main {
    static Scanner scMainInt = new Scanner(System.in);
    static Scanner scMainString = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Si acepta los terminos y condiciones del juego ingrese un numero uno.");
        int eleccion = scMainInt.nextInt();
        if (eleccion == 1) {
            if (args.length == 3) {
                Jugador player = new Jugador(args[0], args[1], Integer.parseInt(args[2]));
                AnteSala.crearPrimerCarro(player, args[0]);
            } else {
                System.out.println("Ingresa tu nombre.");
                String nombre = scMainString.nextLine();
                System.out.println("Ingresa tu nickname.");
                String nickname = scMainString.nextLine();
                System.out.println("Ingresa tu edad");
                int edad = scMainInt.nextInt();

                System.out.println("Hola " + nombre);
                AnteSala.instrucciones();
                Jugador player = new Jugador(nombre, nickname, edad);
                AnteSala.crearPrimerCarro(player, nombre);
            }

        } else {
            System.out.println("Esperamos verte pronto.");
            System.exit(0);
        }
    }
}
