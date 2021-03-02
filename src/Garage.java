import java.util.Random;
import java.util.Scanner;

public class Garage {
    static String[] listaDeCarrosParaCompra = {"Bugati Chiron", "Ferrari Enzo", "Lamborgini Veneno", "Maserati MC20", "Pagani Huayra", "Tesla Roadster"};
    static boolean[] estadoDeVentaDeListaDeCarrosParaCompra = {false, false, false, false, false, false};
    static Scanner scGarageInt = new Scanner(System.in);
    public static void principal (Jugador player) {
        System.out.println();
        System.out.println("Bienvenido al garage.");
        if (player.getCantidadCarros() == 1) {
            player.setCarroPredeterminado(0);
            garage(player, player.getCarroPredeterminado());
        } else {
            System.out.println("Escoge el carro que deseas modificar");
            player.imprimirCarrosComprados();
            int carroElecto = scGarageInt.nextInt() - 1;
            player.setCarroPredeterminado(carroElecto);
            garage(player, player.getCarroPredeterminado());
        }
    }

    private static void garage(Jugador player, int carroPredeterminado) {
        opcionesDeGarage();
        int elecicon = scGarageInt.nextInt();
        if (elecicon == 1) {
            modificarMotor(player, carroPredeterminado);
        } else if (elecicon == 2) {
            modificarLlantas(player, carroPredeterminado);
        } else if (elecicon == 3) {

        } else if (elecicon == 4) {

        } else if (elecicon == 5) {

        } else if (elecicon == 6) {

        } else if (elecicon == 7) {

        } else if (elecicon == 8) {

        }
    }

    private static void modificarLlantas(Jugador player, int carroPredeterminado) {
        int eleccion;
        do{
            System.out.println();
            System.out.println("¿Que deseas hacer?");
            System.out.println("1. Comprar una llanta.\n2. Cambiar la llanta seleccionada.\n3. Salir.");
            eleccion = scGarageInt.nextInt();
            if (eleccion == 1) {
                int llantaComprada;
                do {
                    System.out.println("Escoge la llanta que deseas comprar para tu carro.");
                    System.out.println("1. Llanta calidad baja. Costo: 25 monedas de oro." +
                            "\n2. Llanta calidad media. Costo: 50 monedas de oro." +
                            "\n3. Llanta calidad alta. Costo: 75 Monedas de oro.\n4. Salir.");
                    llantaComprada = scGarageInt.nextInt() -1;
                    if (llantaComprada >= 0 && llantaComprada <=2) {
                        if (player.carros[carroPredeterminado].llantas[llantaComprada].getEstadoDeCompra()) {
                            System.out.println("ERROR. Ya has comprado esta llanta.");
                        } else {
                            if (player.getOro() < player.carros[carroPredeterminado].llantas[llantaComprada].getPrecioLlantasOro()){
                                System.out.println("ERROR. No tienes el oro necesario para comprar este motor.");
                            } else {
                                player.carros[carroPredeterminado].llantas[llantaComprada].setEstadoDeCompra(true);
                                long nuevaCantidadDeOro = player.getOro() - player.carros[carroPredeterminado].llantas[llantaComprada].getPrecioLlantasOro();
                                player.setOro(nuevaCantidadDeOro);
                                int cambiarLlantas;
                                do {
                                    System.out.println("¿Desea establecer las llantas nuevas como las predeterminados?");
                                    System.out.println("1. Si.\n2. No.");
                                    cambiarLlantas = scGarageInt.nextInt();
                                    if (cambiarLlantas == 1) {
                                        player.carros[carroPredeterminado].setLlantaPredeterminada(llantaComprada);
                                    } else if (cambiarLlantas == 2) {
                                        //no cambia el motor
                                    } else {
                                        System.out.println("Escoge una opcion correcta.");
                                    }
                                } while (cambiarLlantas != 1 && cambiarLlantas != 2);
                            }
                        }
                    } else if (llantaComprada == 3) {
                        //salir
                    } else {
                        System.out.println("Escoge una opcion correcta.");
                    }
                } while (llantaComprada != 3);
            } else if (eleccion == 2) { //cambiar llanta seleccionada
                int llantaElecta;
                do {
                    System.out.println("Escoge la llanta que deseas establecer como predeterminada para tu carro.");
                    System.out.println("1. Llanta calidad baja.\n2. Llanta calidad media." +
                            "\n3. Llanta calidad alta.\n4. Salir.");
                    llantaElecta = scGarageInt.nextInt() -1;
                    if (llantaElecta >= 0 && llantaElecta <= 2) {
                        if (player.carros[carroPredeterminado].llantas[llantaElecta].getEstadoDeCompra()) {
                            player.carros[carroPredeterminado].setLlantaPredeterminada(llantaElecta);
                        } else {
                            System.out.println("ERROR. No has comprado esta llanta.");
                        }
                    } else if (llantaElecta == 3) {
                        //salir
                    } else {
                        System.out.println("Escoge una opcion correcta.");
                    }
                } while (llantaElecta != 3);
            } else if (eleccion== 3){
                //salir
            } else {
                System.out.println("Escoge una opcion correcta.");
            }
        } while (eleccion != 3);
    }

    private static void modificarMotor(Jugador player, int carroPredeterminado) {
        int eleccion;
        do{
            System.out.println();
            System.out.println("¿Que deseas hacer?");
            System.out.println("1. Comprar un motor.\n2. Cambiar el motor predeterminado.\n3. Salir.");
            eleccion = scGarageInt.nextInt();
            if (eleccion == 1) {
                int motorComprado;
                do {
                    System.out.println("Escoge el motor que deseas comprar para tu carro.");
                    System.out.println("1. Motor basico. Costo: 5 gemas.\n2. Motor medio. Costo: 20 gemas." +
                            "\n3. Motor alto rendimiento. Costo: 35 gemas.\n4. Salir.");
                    motorComprado = scGarageInt.nextInt() -1;
                    if (motorComprado >= 0 && motorComprado <=2) {
                        if (player.carros[carroPredeterminado].motores[motorComprado].getEstadoCompra()) {
                            System.out.println("ERROR. Ya has comprado este motor.");
                        } else {
                            if (player.getGemas() < player.carros[carroPredeterminado].motores[motorComprado].getPrecioMotorGemas()){
                                System.out.println("ERROR. No tienes las gemas necesarias para comprar este motor.");
                            } else {
                                player.carros[carroPredeterminado].motores[motorComprado].setEstadoCompra(true);
                                long nuevaCantidadDeGemas = player.getGemas() - player.carros[carroPredeterminado].motores[motorComprado].getPrecioMotorGemas();
                                player.setGemas(nuevaCantidadDeGemas);
                                int cambiarMotor;
                                do {
                                     System.out.println("¿Desea establecer el nuevo motor como el predeterminado?");
                                     System.out.println("1. Si.\n2. No.");
                                     cambiarMotor = scGarageInt.nextInt();
                                     if (cambiarMotor == 1) {
                                        player.carros[carroPredeterminado].setMotorPredeterminado(motorComprado);
                                    } else if (cambiarMotor == 2) {
                                        //no cambia el motor
                                    } else {
                                        System.out.println("Escoge una opcion correcta.");
                                    }
                                } while (cambiarMotor != 1 && cambiarMotor != 2);
                                break;
                            }
                        }
                    } else if (motorComprado == 3) {
                        //salir
                    } else {
                        System.out.println("Escoge una opcion correcta.");
                    }
                } while (motorComprado != 3);

            } else if (eleccion == 2) { //cambiar el motor seleccionado
                int motorElecto;
                do {
                    System.out.println("Escoge el motor que deseas establecer como predeterminado para tu carro.");
                    System.out.println("1. Motor basico.\n2. Motor medio." +
                            "\n3. Motor alto rendimiento.\n4. Salir.");
                    motorElecto = scGarageInt.nextInt() -1;
                    if (motorElecto >= 0 && motorElecto <= 2) {
                        if (player.carros[carroPredeterminado].motores[motorElecto].getEstadoCompra()) {
                            player.carros[carroPredeterminado].setMotorPredeterminado(motorElecto);
                        } else {
                            System.out.println("ERROR. No has comprado este motor.");
                        }
                    } else if (motorElecto == 3) {
                        //salir
                    } else {
                        System.out.println("Escoge una opcion correcta.");
                    }
                } while (motorElecto != 3);
            } else if (eleccion== 3){
                //salir
            } else {
                System.out.println("Escoge una opcion correcta.");
            }
        } while (eleccion != 3);
    }

    private static void opcionesDeGarage() {
        System.out.println("1. Modificar motor.");
        System.out.println("2. modificar llantas.");
        System.out.println("3. Modificar Color.");
        System.out.println("4. Llenar tanque de gasolina.");
        System.out.println("5. Ver propiedades del carro actual.");
        System.out.println("6. Cambiar carro.");
        System.out.println("7. Comprar otro carro.");
        System.out.println("8. volver al menu principal.");
    }

    public static String nombreDeCarroAleatorio() {
        Random rd = new Random();
        return listaDeCarrosParaCompra[rd.nextInt(listaDeCarrosParaCompra.length)];
    }
}

