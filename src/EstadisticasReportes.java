import java.util.Scanner;
public class EstadisticasReportes {
    static Scanner scInt = new Scanner(System.in);
    static Estadistica[] estadisticas = new Estadistica[100];
    static int numeroDeReportes = 0;

    public static void inicio (Jugador player) {
        int subMenuEscogido;
        do {
            System.out.println("Escoge uno de los dos.");
            System.out.println("1. Estadisticas de partida." +
                    "\n2. Reporte de gasolna por carro.\n3. Salir.");
            subMenuEscogido = scInt.nextInt();
            if (subMenuEscogido == 1) {
                mostrarEstadisticas(numeroDeReportes, estadisticas);
            } else if (subMenuEscogido == 2) {
                mostrarReporte(player);
            } else if (subMenuEscogido == 3) {
                //salir
            } else {
                System.out.println("Escoge una opcion correcta.");
            }
        } while (subMenuEscogido != 3);
    }

    private static void mostrarEstadisticas(int numeroDeReporte, Estadistica[] estadisticas) {
        for (int i = 0; i < numeroDeReporte; i++) {
            estadisticas[i].imprimirEstadisticas();
        }
    }

    private static void mostrarReporte(Jugador player) {
        for (int i = 0; i < player.getCantidadCarros(); i++) {
            player.carros[i].imprimirCarrosParaReporte();
        }
    }

    public static void crearEstadistica(String nombreDePista, String[] podio) {
        estadisticas[numeroDeReportes] = new Estadistica(nombreDePista, podio);
        numeroDeReportes++;
    }
}
