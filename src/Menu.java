import java.util.Scanner;

public class Menu {
    static Scanner scMenuInt = new Scanner(System.in);
    //static Scanner scMenuString = new Scanner(System.in);
    static int eleccion;

    public static void principal(Jugador player){
        do {
            System.out.println();
            System.out.println("Escoja una opcion");
            imprimirMenuPrincipal();
            eleccion = scMenuInt.nextInt();
            switch (eleccion){
                case 1:
                    System.out.println("Has elegido competir.");
                    Competir.elecciones(player);
                    break;
                case 2:
                    System.out.println("Has elegido la ruleta.");
                    Ruleta.ruleta(player);
                    break;
                case 3:
                    System.out.println("Has elegido entrar al garage.");
                    Garage.principal(player);
                    break;
                case 4:
                    System.out.println("Has elegido revisar las pistas.");
                    System.out.println(player.getNombre());
                    break;
                case 5:
                    System.out.println("Has elegido revisar las estadisticas y reportes.");
                    System.out.println(player.getNombre());
                    break;
                case 6:
                    System.out.println("Has pronto.");
                    break;
                default:
                    System.out.println("No es una opcion correcta");
            }
        } while (eleccion != 6);
    }

    public static void imprimirMenuPrincipal(){
        System.out.println("1. Competir.");
        System.out.println("2. Ruleta.");
        System.out.println("3. Garage.");
        System.out.println("4. Pista.");
        System.out.println("5. Estadisticas y reportes.");
        System.out.println("6. Salir");
    }
}