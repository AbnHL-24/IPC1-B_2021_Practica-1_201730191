import java.util.Scanner;
public class EstadisticasReportes {
    static Scanner scInt = new Scanner(System.in);

    public static void inicio (Jugador player) {
        int subMenuEscogido;
        do {
            System.out.println("Escoge uno de los dos.");
            System.out.println("1. Estadisticas de partida." +
                    "\n2. Reporte de gasolna por carro.\n3. Salir.");
            subMenuEscogido = scInt.nextInt();
            if (subMenuEscogido == 1) {
                System.out.println(player.getNombre());
            } else if (subMenuEscogido == 2) {
                reporte(player);
            } else if (subMenuEscogido == 3) {
                //salir
            } else {
                System.out.println("Escoge una opcion correcta.");
            }
        } while (subMenuEscogido != 3);
    }
    private static void reporte (Jugador player) {
        for (int i = 0; i < player.getCantidadCarros(); i++) {
            player.carros[i].imprimirCarrosParaReporte();
        }
    }
}
