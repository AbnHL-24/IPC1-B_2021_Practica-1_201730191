import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Competir {
    private static int pistaElecta;
    private static int cantidadDeRivales;
    private static int carroElecto;
    private static Scanner scCompetirString = new Scanner(System.in);
    private static Scanner scComperitInt = new Scanner(System.in);
    private static Random rd = new Random();

    public static void elecciones(Jugador player) {
        do {
            System.out.println("Escoge la pista en la que deseas competir.");
            imprimirPistas();
            System.out.println("4. Salir.");
            pistaElecta = scComperitInt.nextInt();
            if (pistaElecta == 1 | pistaElecta == 2 | pistaElecta ==3 ) {
                System.out.println("Haz elegido la " + nombreDePista(pistaElecta));
                boolean hayCarrosConGasolinaSuficiente = player.verificarGasolinaDeCarrosParaPista(tamañoDePista(pistaElecta));
                if(hayCarrosConGasolinaSuficiente) {
                    do {
                        player.imprimirCarrosParaCarrera(tamañoDePista(pistaElecta));
                        System.out.println("7. Salir.");
                        carroElecto = scComperitInt.nextInt();  //ingresa el carro que desea
                        if (carroElecto >= 1 && carroElecto <=6) {
                            do {
                                System.out.println("¿Contra cuantos corredores deseas competir?");
                                System.out.println("Ingresa un numero entre uno y cinco");
                                System.out.println("Ingresa 6 para salir.");
                                cantidadDeRivales = scComperitInt.nextInt();
                                if(cantidadDeRivales >0 && cantidadDeRivales <6) {
                                preparacionParaCarrera(player, carroElecto, pistaElecta, cantidadDeRivales);
                                } else if (cantidadDeRivales == 6) {
                                    //salir
                                } else {
                                    System.out.println("Escoge una opcion correcta");
                                }
                            }while (cantidadDeRivales != 6);

                        } else if(carroElecto == 7){
                            //salir
                        } else {
                            System.out.println("Escoge una opcion correcta.");
                        }
                    } while (carroElecto !=7);
                } else {
                    System.out.println("No hay carros con la gasolina suficiente para realizar la carrera.");
                    System.out.println("Recomendamos llenar al menos un tanque de gasolina o intentar en otra pista.");
                    break;
                }
            } else if (pistaElecta == 4) {
                //salir
            } else {
                System.out.println("Escoge una opcion correcta");
            }
        } while (pistaElecta != 4);
    }

    //Aca se creara la el arreglo bidimencional que sera usado para realizar las vueltas de la carrera
    private static void preparacionParaCarrera(Jugador player, int carroElecto, int pistaElecta, int cantidadDeRivales) {
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
        for (int i = 0; i < competidores.length; i++) {
            competidoresEnCarrera[i][0] = competidores[ordenAleatorioDeCompetidores[i]];
            if (player.getNombre().equals(competidoresEnCarrera[i][0])) {
                competidoresEnCarrera[i][1] = player.getNombreCarroElecto(carroElecto);
                competidoresEnCarrera[i][2] = player.getPotenciaDeMotorDelCarroElecto(carroElecto);
                competidoresEnCarrera[i][3] = player.getCoheficienteDeLlantasDelCarroElecto(carroElecto);
            } else {
                competidoresEnCarrera[i][1] = Garage.nombreDeCarroAleatorio();
                competidoresEnCarrera[i][2] = generarPotenciaMotorRival(); // donde guardar el resultado de la funcion.
                competidoresEnCarrera[i][3] = generarCoheficienteLlantasRival();
            }
            competidoresEnCarrera[i][4] = "0";
        }
        vueltas(player, competidoresEnCarrera, carroElecto, pistaElecta);
        System.out.println("Prueba");//mandar reportes
    }

    //vueltas() realiza la carrera en si, es decir, determina al ganador.
    private static void vueltas(Jugador player, String[][] competidoresEnCarrera, int carroElecto, int pistaElecta) {
        boolean continuar = true;
        System.out.println();
        do {
            for (int i = 0; i < competidoresEnCarrera.length; i++) {
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
            for (int i = 0; i < competidoresEnCarrera.length; i++) {
                int casillas = Integer.parseInt(competidoresEnCarrera[i][4]);
                if(casillas >= tamañoDePista(pistaElecta)) {
                    continuar = false;
                }
            }
            System.out.println("Ingrese un espacio para continuar");
            String stringDePaso = scCompetirString.nextLine();
        } while(continuar);
        postCarrera(player, competidoresEnCarrera, carroElecto-1, pistaElecta);
    }

    private static void postCarrera(Jugador player, String[][] competidoresEnCarrera, int carroElecto, int pistaElecta) {
        int[] casillasAvanzadasCompetidoresOrdenadas = new int[competidoresEnCarrera.length];
        for (int i = 0; i < competidoresEnCarrera.length; i++) {
            casillasAvanzadasCompetidoresOrdenadas[i] = Integer.parseInt(competidoresEnCarrera[i][4]);
        }
        Arrays.sort(casillasAvanzadasCompetidoresOrdenadas);
        String[][] competidoresOrdenados = new String[competidoresEnCarrera.length][2];
        for (int i = 0; i < casillasAvanzadasCompetidoresOrdenadas.length; i++) {
                String letraI = String.valueOf(casillasAvanzadasCompetidoresOrdenadas[i]);
            for (int j = 0; j < casillasAvanzadasCompetidoresOrdenadas.length; j++) {
                if (letraI.equals(competidoresEnCarrera[j][4])) {
                    competidoresOrdenados[i][0] = competidoresEnCarrera[j][0];
                    competidoresOrdenados[i][1] = competidoresEnCarrera[j][4];
                }
            }
        }
        System.out.println("El ganador es: " + competidoresOrdenados[competidoresOrdenados.length-1][0]);
        for (int i = 0; i < competidoresOrdenados.length; i++) {//remplaza exedente de casillas con la longitud de casillas.
            int casillasI = Integer.parseInt(competidoresOrdenados[i][1]);
            if (casillasI > tamañoDePista(pistaElecta)) {
                String tamañoPista = String.valueOf(tamañoDePista(pistaElecta));
                competidoresOrdenados[i][1] = tamañoPista;
            }
        }
        int potenciaDelRival = 0; //obtenemos potencia del rival para usar en las formulas de oro y gemas
        for (int i = 0; i < competidoresEnCarrera.length; i++) {
            if(player.getNombre().equals(competidoresEnCarrera[i][0])) {
            } else {
                potenciaDelRival += Integer.parseInt(competidoresEnCarrera[i][2]);
            }
        }
        potenciaDelRival = potenciaDelRival/competidoresEnCarrera.length;
        for (int i = 0; i < competidoresOrdenados.length; i++) {//establece nuevos valores dentro de jugador.
            if(player.getNombre().equals(competidoresOrdenados[i][0])) {
                int casillasRecorridas = Integer.parseInt(competidoresOrdenados[i][1]);
                int gasolinaRestante = player.carros[carroElecto].getTanqueGasolina() - casillasRecorridas;
                player.carros[carroElecto].setTanqueGasolina(gasolinaRestante);
                long nuevaGasolinaConsumida = player.carros[carroElecto].getGasolinaConsumida() + casillasRecorridas;
                player.carros[carroElecto].setGasolinaConsumida(nuevaGasolinaConsumida);
                long oroObtenido = (long) potenciaDelRival * (rd.nextInt(10)+1) + coheficienteDePista(pistaElecta);
                long nuevaCantidadDeOro = player.getOro() + oroObtenido;
                player.setOro(nuevaCantidadDeOro);
                long gemasObtenidas = potenciaDelRival + (rd.nextInt(10)+1) + coheficienteDePista(pistaElecta);
                long nuevaCantidadDeGemas = player.getGemas() + gemasObtenidas;
                player.setGemas(nuevaCantidadDeGemas);
            }
        }
        String[] podio = new String [competidoresOrdenados.length];
        for (int i = podio.length-1; i == 0 ; i--) {
            int numeroPodio=1;
            podio[i] = numeroPodio + ". " + competidoresOrdenados[i][0] + ", " + competidoresOrdenados[i][1] + " casillas avanzadas.";
            numeroPodio++;
        }
        EstadisticasReportes.crearEstadistica(nombreDePista(pistaElecta), podio);
        //resolver como mandar los datos a los reportes, mejorar ese null.
        int revancha;
        do {
            System.out.println("¿Deseas una revancha?\n1. Si\n2. No");
            revancha = scComperitInt.nextInt();
            if (revancha == 1) {
                Garage.llenarElTanqueDeGasolina(player, carroElecto);
                if (player.carros[carroElecto].getTanqueGasolina() >= tamañoDePista(pistaElecta)) {
                    elecciones(player);
                }
                else {
                    Menu.principal(player);
                }
            } else if (revancha == 2) {
                Menu.principal(player);
            } else {
                System.out.println("Escoge una opcion correcta.");
            }
        } while ( revancha !=2);
    }

    private static int avanceCasillas(int potenciaMotor, int coheficienteLlantas, int pistaElecta) {
        return (potenciaMotor*(rd.nextInt(10)+1) + coheficienteDePista(pistaElecta) + coheficienteLlantas*(rd.nextInt(5)+1) );
    }

    private static String generarCoheficienteLlantasRival() {
        int random = rd.nextInt(4);
        if (random == 0) {
            return "2";
        } else if (random == 1) {
            return "3";
        } else if (random == 2) {
            return "5";
        } else {
            return "1";
        }
    }

    private static String generarPotenciaMotorRival() {
        int random = rd.nextInt(4);
        if (random == 0) {
            return "4";
        } else if (random == 1) {
            return "5";
        } else if (random == 2) {
            return "7";
        } else {
            return "2";
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