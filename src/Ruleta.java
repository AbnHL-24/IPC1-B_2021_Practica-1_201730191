import java.util.Random;
import java.util.Scanner;

public class Ruleta {
        static int eleccion;
        static Scanner scRuletaInt = new Scanner(System.in);
        static Random rd = new Random();
    public static void ruleta (Jugador player) {
        System.out.println();
        System.out.println("Bienvenido a la ruleta, este es un minijuego de azar,");
        System.out.println("la ruleta te permitira ganar oro o gemas, tirar la ruleta cuesta 5 gemas");
        do {
            System.out.println("ingresa 1 para tirar la ruleta, ingresa 2 para salir al menu principal.");
            eleccion = scRuletaInt.nextInt();
            if (eleccion == 1) {
                System.out.println("---");
                System.out.println("---");
                System.out.println("---");
                int numero = rd.nextInt(100);
                if (numero >= 0 && numero <= 4) {
                    long gemasActuales = player.getGemas();
                    long gemasTrasRuleta = gemasActuales + 1_000;
                    System.out.println("Has ganado " + 1_000 + " gemas");
                    player.setGemas(gemasTrasRuleta);
                    continue;
                } else if (numero >= 5 && numero <= 9) {
                    long oroActual = player.getOro();
                    long oroTrasRuleta = oroActual + 2_000;
                    System.out.println("Has ganado " + 2_000 + " de oro");
                    player.setOro(oroTrasRuleta);
                    continue;
                } else if (numero >= 10 && numero <= 19) {
                    long gemasActuales = player.getGemas();
                    long gemasTrasRuleta = gemasActuales + 40;
                    System.out.println("Has ganado " + 40 + " gemas");
                    player.setGemas(gemasTrasRuleta);
                    continue;
                } else if (numero >= 20 && numero <= 34) {
                    long oroActual = player.getOro();
                    long oroTrasRuleta = oroActual + 75;
                    System.out.println("Has ganado " + 75 + " de oro");
                    player.setOro(oroTrasRuleta);
                    continue;
                } else if (numero >= 35 && numero <= 64) {
                    long gemasActuales = player.getGemas();
                    long gemasTrasRuleta = gemasActuales + 5;
                    System.out.println("Has ganado " + 5 + " gemas");
                    player.setGemas(gemasTrasRuleta);
                    continue;
                } else if (numero >= 65 && numero <= 99) {
                    long oroActual = player.getOro();
                    long oroTrasRuleta = oroActual + 10;
                    System.out.println("Has ganado " + 10 + " de oro");
                    player.setOro(oroTrasRuleta);
                    continue;
                }
            } else if (eleccion == 2) {
                //retorna al menu principal.
            }
        } while (eleccion != 1 & eleccion != 2);
    }
}
