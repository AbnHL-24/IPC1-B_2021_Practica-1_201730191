import java.util.Scanner;
public class AnteSala {

    public static void instrucciones() {
        System.out.println("Antes de escoger tu primer carro, repasaremos algunas instrucciones.");
        System.out.println("A partir de ahora, para escoger una opcion," +
                " tienes que ingresar el numero correspondiente" +
                " y presionar la tecla Enter.");
        System.out.println("Abran ocaciones en las que se te pedrira ingresar texto," +
                " para esto solo escriberlo y presiona la tecla Enter");
        System.out.println("Ahora, es tiempo de escoger tu carro inicial.\n");
    }

    public static void crearPrimerCarro(Jugador player, String nombre) {
        final String CHEVROLET_CAMARO_SS = "Chevrolet Camaro SS";
        final String DODGE_CHALLENGER_HELLCAT = "Dodge Challenger Hellcat";
        final String FORD_MUSTANG_GT = "Ford Mustang GT";
        Scanner scAnteSalaInt = new Scanner(System.in);

        System.out.println("Hola " + nombre);
        AnteSala.instrucciones();
        System.out.println("En el Garage hay tres carros, puedes escoger uno. Pero escoge sabiamente," +
                "\nlos tres carros tienen el motor y las llantas basicas," +
                "\ndespues podras mejorarlos, incluso podras comprar mas carros, pero," +
                "\nSOLO PUEDES TENER UNO DE ESTOS TRES CARROS.");
        System.out.println("1. " + CHEVROLET_CAMARO_SS);
        System.out.println("2. " + DODGE_CHALLENGER_HELLCAT);
        System.out.println("3. " + FORD_MUSTANG_GT);

        int eleccion = scAnteSalaInt.nextInt();
        if (eleccion == 1) {
            player.crearCarro(CHEVROLET_CAMARO_SS);
        } else if (eleccion == 2) {
            player.crearCarro(DODGE_CHALLENGER_HELLCAT);
        } else {
            player.crearCarro(FORD_MUSTANG_GT);
        }
        Menu.principal(player);
    }
}