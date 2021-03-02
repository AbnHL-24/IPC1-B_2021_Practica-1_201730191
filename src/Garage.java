import java.util.Random;
import java.util.Scanner;

public class Garage {
    private static final String[] listaDeCarrosParaCompra = {"Bugati Chiron", "Ferrari Enzo", "Lamborgini Veneno", "Maserati MC20", "Pagani Huayra", "Tesla Roadster"};
    private static boolean[] disponibilidadParaVentaDeCarros = {true, true, true, true, true, true};
    private static Scanner scInt = new Scanner(System.in);
    private static Scanner scString = new Scanner(System.in);

    public static void principal (Jugador player) {
        System.out.println();
        System.out.println("Bienvenido al garage.");
        if (player.getCantidadCarros() == 1) {
            player.setCarroPredeterminado(0);
            garage(player, player.getCarroPredeterminado());
        } else {
            escogerCarroPredeterminado(player);
        }
    }

    private static void garage(Jugador player, int carroPredeterminado) {
        int elecicon;
        do {
            opcionesDeGarage();
            elecicon= scInt.nextInt();
            if (elecicon == 1) {
                modificarMotor(player, carroPredeterminado);
            } else if (elecicon == 2) {
                modificarLlantas(player, carroPredeterminado);
            } else if (elecicon == 3) {
                System.out.println("Esta caracteristica estara disponible en la siguiente actualizacion.");
            } else if (elecicon == 4) {
                llenarElTanqueDeGasolina(player, carroPredeterminado);
            } else if (elecicon == 5) {
                verPropiedadesDelCarroActual(player, carroPredeterminado);
            } else if (elecicon == 6) {
                escogerCarroPredeterminado(player);
            } else if (elecicon == 7) {
                comprarCarro(player);
            } else if (elecicon == 8) {
                //salir al menu principal.
            } else {
                System.out.println("Escoge una opcion correcta");
            }
        } while ( elecicon != 8);
    }

    private static void verPropiedadesDelCarroActual(Jugador player, int carroPredeterminado) {
        player.carros[carroPredeterminado].imprimirCarroParaGarage();
        System.out.println("Ingresa un espacio para continuar");
        String stringDePaso = scString.nextLine();
    }

    public static void llenarElTanqueDeGasolina(Jugador player, int carroPredeterminado) {
        int gasolinaALlenar = 100 - player.carros[carroPredeterminado].getTanqueGasolina();
        long gasolinaEnOroLong = (long) (gasolinaALlenar*2.5);
        if (gasolinaALlenar == 0) {
            System.out.println("El tanque de gasolina esta lleno.");
        } else {
            if (player.getOro() < gasolinaEnOroLong) {
                System.out.println("No tienes suficiente oro.");
            } else {
                long nuevaCantidadDeOro = player.getOro() - gasolinaEnOroLong;
                player.setOro(nuevaCantidadDeOro);
                long nuevoOroGastado = player.carros[carroPredeterminado].getOroGastado() + gasolinaEnOroLong;
                player.carros[carroPredeterminado].setOroGastado(nuevoOroGastado);
                long nuevaCantidadDeGasolinaComprada = player.carros[carroPredeterminado].getGasolinaComprada() + gasolinaALlenar;
                player.carros[carroPredeterminado].setGasolinaComprada(nuevaCantidadDeGasolinaComprada);
                player.carros[carroPredeterminado].setTanqueGasolina(100);
                System.out.println("El tanque ha sido llenado.");
            }
        }
    }

    private static void comprarCarro(Jugador player) {
        System.out.println("Puedes escoger entre los siguientes carros.");
        System.out.println("Pero recuerda que tienes un limite de 5 carros en total." +
                "\nTendras que dejar dos fuera de tu coleccion.");
        int carroEscogido;
        do {
            System.out.println("Escoge el numero del carro que deseas comprar.");
            imprimirCarrosDisponiblesParaComprar();
            System.out.println("7. Salir.");
            carroEscogido = scInt.nextInt()-1;
            if (carroEscogido >= 0 && carroEscogido <= 5) {
                if (disponibilidadParaVentaDeCarros[carroEscogido]) {
                    //Queda pendiente el precio, no lo ha  puesto en el documento
                    //Recordar aumentar el oro gastado
                    disponibilidadParaVentaDeCarros[carroEscogido] = false;
                    player.crearCarro(listaDeCarrosParaCompra[carroEscogido]);
                } else {
                    System.out.println("Escoge una opcion correcta");
                }
            } else if (carroEscogido == 6) {
                //salir
            } else {
                System.out.println("Escoge una opcion correcta");
            }
        } while(carroEscogido != 6);
    }

    private static void imprimirCarrosDisponiblesParaComprar() {
        for (int i = 0; i < listaDeCarrosParaCompra.length; i++) {
            if (disponibilidadParaVentaDeCarros[i]) {
                int ordenDeCarro = i+1;
                System.out.println(ordenDeCarro + ". " + listaDeCarrosParaCompra[i]);
            }
        }
    }

    private static void escogerCarroPredeterminado(Jugador player) {
        if (player.getCantidadCarros() == 1) {
            System.out.println("Solo tienes un carro, primero debes comprar otro.");
            System.out.println("Ingresa un espacio para continuar");
            String stringDePaso = scString.nextLine();
        } else {
            System.out.println("Escoge el carro que deseas modificar");
            player.imprimirCarrosComprados();
            int carroElecto = scInt.nextInt() - 1;
            player.setCarroPredeterminado(carroElecto);
            garage(player, player.getCarroPredeterminado());
        }
    }

    private static void modificarLlantas(Jugador player, int carroPredeterminado) {
        int eleccion;
        do{
            System.out.println();
            System.out.println("¿Que deseas hacer?");
            System.out.println("1. Comprar una llanta.\n2. Cambiar la llanta seleccionada.\n3. Salir.");
            eleccion = scInt.nextInt();
            if (eleccion == 1) {
                int llantaComprada;
                do {
                    System.out.println("Escoge la llanta que deseas comprar para tu carro.");
                    System.out.println("1. Llanta calidad baja. Costo: 25 monedas de oro." +
                            "\n2. Llanta calidad media. Costo: 50 monedas de oro." +
                            "\n3. Llanta calidad alta. Costo: 75 Monedas de oro.\n4. Salir.");
                    llantaComprada = scInt.nextInt();
                    if (llantaComprada >= 1 && llantaComprada <=3) {
                        if (player.carros[carroPredeterminado].llantas[llantaComprada].getEstadoDeCompra()) {
                            System.out.println("ERROR. Ya has comprado esta llanta.");
                        } else {
                            long precioLlantaEnOro = player.carros[carroPredeterminado].llantas[llantaComprada].getPrecioLlantasOro();
                            if (player.getOro() < precioLlantaEnOro){
                                System.out.println("ERROR. No tienes el oro necesario para comprar este motor.");
                            } else {
                                player.carros[carroPredeterminado].llantas[llantaComprada].setEstadoDeCompra(true);
                                long nuevaCantidadDeOro = player.getOro() - precioLlantaEnOro;
                                player.setOro(nuevaCantidadDeOro);
                                long nuevoOroGastado = player.carros[carroPredeterminado].getOroGastado() + precioLlantaEnOro;
                                player.carros[carroPredeterminado].setOroGastado(nuevoOroGastado);
                                int cambiarLlantas;
                                do {
                                    System.out.println("¿Desea establecer las llantas nuevas como las predeterminados?");
                                    System.out.println("1. Si.\n2. No.");
                                    cambiarLlantas = scInt.nextInt();
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
                    } else if (llantaComprada == 4) {
                        //salir
                    } else {
                        System.out.println("Escoge una opcion correcta.");
                    }
                } while (llantaComprada != 4);
            } else if (eleccion == 2) { //cambiar llanta seleccionada
                int llantaElecta;
                do {
                    System.out.println("Escoge la llanta que deseas establecer como predeterminada para tu carro.");
                    System.out.println("1. Llanta generica");
                    System.out.println("2. Llanta calidad baja.\n3. Llanta calidad media." +
                            "\n4. Llanta calidad alta.\n5. Salir.");
                    llantaElecta = scInt.nextInt() -1;
                    if (llantaElecta >= 0 && llantaElecta <= 3) {
                        if (player.carros[carroPredeterminado].llantas[llantaElecta].getEstadoDeCompra()) {
                            player.carros[carroPredeterminado].setLlantaPredeterminada(llantaElecta);
                        } else {
                            System.out.println("ERROR. No has comprado esta llanta.");
                        }
                    } else if (llantaElecta == 4) {
                        //salir
                    } else {
                        System.out.println("Escoge una opcion correcta.");
                    }
                } while (llantaElecta != 4);
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
            eleccion = scInt.nextInt();
            if (eleccion == 1) {
                int motorComprado;
                do {
                    System.out.println("Escoge el motor que deseas comprar para tu carro.");
                    System.out.println("1. Motor basico. Costo: 5 gemas.\n2. Motor medio. Costo: 20 gemas." +
                            "\n3. Motor alto rendimiento. Costo: 35 gemas.\n4. Salir.");
                    motorComprado = scInt.nextInt();
                    if (motorComprado >= 1 && motorComprado <=3) {
                        if (player.carros[carroPredeterminado].motores[motorComprado].getEstadoCompra()) {
                            System.out.println("ERROR. Ya has comprado este motor.");
                        } else {
                            long precioMotorEnGemas = player.carros[carroPredeterminado].motores[motorComprado].getPrecioMotorGemas();
                            if (player.getGemas() < precioMotorEnGemas){
                                System.out.println("ERROR. No tienes las gemas necesarias para comprar este motor.");
                            } else {
                                player.carros[carroPredeterminado].motores[motorComprado].setEstadoCompra(true);
                                long nuevaCantidadDeGemas = player.getGemas() - precioMotorEnGemas;
                                player.setGemas(nuevaCantidadDeGemas);
                                int cambiarMotor;
                                do {
                                     System.out.println("¿Desea establecer el nuevo motor como el predeterminado?");
                                     System.out.println("1. Si.\n2. No.");
                                     cambiarMotor = scInt.nextInt();
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
                    } else if (motorComprado == 4) {
                        //salir
                    } else {
                        System.out.println("Escoge una opcion correcta.");
                    }
                } while (motorComprado != 4);

            } else if (eleccion == 2) { //cambiar el motor seleccionado
                int motorElecto;
                do {
                    System.out.println("Escoge el motor que deseas establecer como predeterminado para tu carro.");
                    System.out.println("1. Motor generico.");
                    System.out.println("2. Motor basico.\n2. Motor medio." +
                            "\n4. Motor alto rendimiento.\n5. Salir.");
                    motorElecto = scInt.nextInt() -1;
                    if (motorElecto >= 0 && motorElecto <= 3) {
                        if (player.carros[carroPredeterminado].motores[motorElecto].getEstadoCompra()) {
                            player.carros[carroPredeterminado].setMotorPredeterminado(motorElecto);
                        } else {
                            System.out.println("ERROR. No has comprado este motor.");
                        }
                    } else if (motorElecto == 4) {
                        //salir
                    } else {
                        System.out.println("Escoge una opcion correcta.");
                    }
                } while (motorElecto != 4);
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