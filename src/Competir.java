import java.util.Scanner;

public class Competir {
    static int pistaElecta;
    static int cantidadDeCompetidores;
    static Scanner scComperitInt = new Scanner(System.in);

    public static void elecciones(Jugador player) {
        System.out.println("Escoge la pista en la que deseas competir.");
        imprimirPistas();
        pistaElecta = scComperitInt.nextInt();
        while(pistaElecta > 3 | pistaElecta < 1) {
            System.out.println("Has ingresado un numero de pista incorrecto." +
                    "\nPor favor, elige correctamente una pista.");
            imprimirPistas();
            pistaElecta = scComperitInt.nextInt();
        }
        boolean hayCarrosConGasolinaSuficiente = player.verificarGasolinaDeCarrosParaPista(tamañoDePista(pistaElecta));
        if(hayCarrosConGasolinaSuficiente) {
            player.imprimirCarrosParaCarrera();
            int carroElecto = scComperitInt.nextInt();
            while(carroElecto > player.getCantidadCarros() | pistaElecta < 1) {
                System.out.println("Has ingresado un numero de carro incorrecto." +
                        "\nPor favor, elige correctamente un carro.");
                player.imprimirCarrosParaCarrera();
                carroElecto = scComperitInt.nextInt();
            }
            System.out.println("¿Contra cuantos corredores deseas competir?");
            System.out.println("Ingresa un numero entre uno y cinco");
            cantidadDeCompetidores = scComperitInt.nextInt();
            carrera();

        } else {
            System.out.println("No hay carros con la gasolina suficiente para realizar la carrera.");
            System.out.println("Recomendamos llenar al menos un tanque de gasolina o intentar en otra pista.");
        }
    }

    private static void carrera() {
        //Espacio para realizar la carrera
        //Resolver dudas sobre los reportes pues es posible tener que crear objetos de rivales y estadisticas
        //Mientras tanto proseguir con los demas menus.
    }

    private static void imprimirPistas() {
        System.out.println("1. Pista de tierra. Su longitud es de 80 casillas.");
        System.out.println("2. Pista de arena. Su longitud es de 90 casillas.");
        System.out.println("3. Pista de concreto. Su longitud es de 100 casillas.");

    }

    public static int tamañoDePista(int pistaElecta) {
        if(pistaElecta == 1) {
            return 80;
        } else if(pistaElecta == 2) {
            return 90;
        } else {
            return 100;
        }
    }

    public static String nombreDePista(int pistaElecta) {
        if(pistaElecta == 1) {
            return "Pista de tierra.";
        } else if(pistaElecta == 2) {
            return "Pista de arena";
        } else {
            return "Pista de concreto";
        }
    }

    private static int coheficienteDePista(int pistaElecta) {
        if(pistaElecta == 1) {
            return 4;
        } else if(pistaElecta == 2) {
            return 2;
        } else {
            return 6;
        }
    }
}