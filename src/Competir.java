import java.util.Random;
import java.util.Scanner;

public class Competir {
    static int pistaElecta;
    static int cantidadDeRivales;
    static int carroElecto;
    static Scanner scCompetirString = new Scanner(System.in);
    static Scanner scComperitInt = new Scanner(System.in);
    static Random rd = new Random();

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
        System.out.println("Haz elegido la " + nombreDePista(pistaElecta));
        boolean hayCarrosConGasolinaSuficiente = player.verificarGasolinaDeCarrosParaPista(tamañoDePista(pistaElecta));
        if(hayCarrosConGasolinaSuficiente) {
            player.imprimirCarrosParaCarrera(tamañoDePista(pistaElecta));
            carroElecto = scComperitInt.nextInt();  //ingresa el carro que desea

            // la condicion del while verifica que no se ingrese un numero mayor al numero de carros que se posee,
            // un mumero de carro menor a 1 o que el jugador quiera escoger un carro que posee pero que no tiene gasolina
            // suficiente para la compertencia.
            while(carroElecto > player.getCantidadCarros() | carroElecto < 1 | tamañoDePista(pistaElecta) > player.gasolinaCarroElecto(carroElecto)) {
                System.out.println("Has ingresado un numero de carro incorrecto." +
                        "\nPor favor, elige correctamente un carro.");
                player.imprimirCarrosParaCarrera(tamañoDePista(pistaElecta));
                carroElecto = scComperitInt.nextInt();
            }
            System.out.println("¿Contra cuantos corredores deseas competir?");
            System.out.println("Ingresa un numero entre uno y cinco");
            cantidadDeRivales = scComperitInt.nextInt();
            carrera(player, carroElecto, pistaElecta, cantidadDeRivales);

        } else {
            System.out.println("No hay carros con la gasolina suficiente para realizar la carrera.");
            System.out.println("Recomendamos llenar al menos un tanque de gasolina o intentar en otra pista.");
        }
    }

    private static void carrera(Jugador player, int carroElecto, int pistaElecta, int cantidadDeRivales) {
        String[] nombresDeRivales = {"Asael", "Alfredo", "Javier", "Julio", "Eduardo"};
        String[] competidores = new String[cantidadDeRivales + 1];
        competidores[0] = player.getNombre(); //establesco el nombre del jugador en [0] y el de los rivales en los siguientes
        int[] rivalesElectos = new int[cantidadDeRivales];
        for (int i = 0; i < rivalesElectos.length; i++) {
            rivalesElectos[i]= rd.nextInt(nombresDeRivales.length);
            //mientras comparar sea verdadero crear nuevo random
            while(comparar(i-1, rivalesElectos[i], rivalesElectos)){
                rivalesElectos[i]= rd.nextInt(nombresDeRivales.length);
            }
        }
        for (int i = 1; i < cantidadDeRivales+1; i++) {
            competidores[i] = nombresDeRivales[rivalesElectos[i-1]];
        }
        int[] ordenAleatorioDeCompetidores = new int[competidores.length];
        for (int i = 0; i < competidores.length; i++) {
            ordenAleatorioDeCompetidores[i]= rd.nextInt(ordenAleatorioDeCompetidores.length);
            //mientras comparar sea verdadero crear nuevo random
            while(comparar(i-1, ordenAleatorioDeCompetidores[i], ordenAleatorioDeCompetidores)){
                ordenAleatorioDeCompetidores[i]= rd.nextInt(ordenAleatorioDeCompetidores.length);
            }
        }
        String[][] competidoresEnCarrera = new String[competidores.length][5];
        for (int i = 0; i < competidoresEnCarrera.length; i++) {
            competidoresEnCarrera[i][0] = competidores[ordenAleatorioDeCompetidores[i]];
        }
        for (int i = 0; i < competidores.length; i++) {
            if (player.getNombre().equals(competidoresEnCarrera[i][0])) {
                competidoresEnCarrera[i][1] = player.getNombreCarroElecto(carroElecto);
            } else {
                competidoresEnCarrera[i][1] = Garage.nombreDeCarroAleatorio();
            }
        }
        for (int i = 0; i < competidores.length; i++) {
            if (player.getNombre().equals(competidoresEnCarrera[i][0])) {
                competidoresEnCarrera[i][2] = player.getPotenciaDeMotorDelCarroElecto(carroElecto);
            } else {
                competidoresEnCarrera[i][2] = generarPotenciaMotorRival();
            }
        }
        for (int i = 0; i < competidores.length; i++) {
            competidoresEnCarrera[i][4] = "0";
        }
        for (int i = 0; i < competidores.length; i++) {
            if (player.getNombre().equals(competidoresEnCarrera[i][0])) {
                competidoresEnCarrera[i][3] = player.getCoheficienteDeLlantasDelCarroElecto(carroElecto);
            } else {
                competidoresEnCarrera[i][3] = generarCoheficienteLlantasRival();
            }
        }
        boolean continuar = true;
        System.out.println();
        do {
            for (int i = 0; i < competidores.length; i++) {
                int potenciaMotor = Integer.parseInt(competidoresEnCarrera[i][2]);
                int coheficienteLlantas = Integer.parseInt(competidoresEnCarrera[i][3]);
                int casillasAvanzadas = avanceCasillas(potenciaMotor, coheficienteLlantas, pistaElecta);
                int casillasTotales = casillasAvanzadas + Integer.parseInt(competidoresEnCarrera[i][4]);
                competidoresEnCarrera[i][4] = String.valueOf(casillasTotales);
                for (int j = 0; j < casillasAvanzadas; j++) {
                    System.out.print("-");
                }
                System.out.print("> " + competidoresEnCarrera[i][1] + " de " + competidoresEnCarrera[i][0]
                + " ha avanzado "+ casillasAvanzadas + " casillas en este turno, y " + competidoresEnCarrera[i][4] + " en total.");
                System.out.println();
            }
            for (int i = 0; i < competidores.length; i++) {
                int casillas = Integer.parseInt(competidoresEnCarrera[i][4]);
                if(casillas >= tamañoDePista(pistaElecta)) {
                    continuar = false;
                }
            }
            //proceder con la asignacion de oro y gemas, tambien con la resta de gasolina
            //resolver el problema de las millas de mas
            //resolver como mandar los datos a los reportes
            //resolver lo de la revancha
            System.out.println("Ingrese un espacio para continuar");
            String stringDePaso = scCompetirString.nextLine();
        } while(continuar);

        System.out.println("Prueba");
    }

    private static int avanceCasillas(int potenciaMotor, int coheficienteLlantas, int pistaElecta) {
        return (potenciaMotor*(rd.nextInt(10)+1) + coheficienteDePista(pistaElecta) + coheficienteLlantas*(rd.nextInt(5)+1) );
    }

    private static String generarCoheficienteLlantasRival() {
        int random = rd.nextInt(3);
        if (random == 0) {
            return "2";
        } else if (random == 1) {
            return "3";
        } else {
            return "5";
        }
    }

    private static String generarPotenciaMotorRival() {
        int random = rd.nextInt(3);
        if (random == 0) {
            return "4";
        } else if (random == 1) {
            return "5";
        } else {
            return "7";
        }
    }

    public static boolean comparar(int iAnt, int numeroRandomEnI, int[] matrizDelNumeroRandom){
        boolean paso;
        if (iAnt<0){
            paso = false;
        }
        else if (numeroRandomEnI != matrizDelNumeroRandom[iAnt]){
            
            paso = comparar(iAnt-1, numeroRandomEnI, matrizDelNumeroRandom);
        }
        else {
            paso = true;
        }
        return paso;
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