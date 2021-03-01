import java.util.Random;

public class Garage {
    static String[] listaDeCarrosParaCompra = {"Bugati Chiron", "Ferrari Enzo", "Lamborgini Veneno", "Maserati MC20", "Pagani Huayra", "Tesla Roadster"};

    public static String nombreDeCarroAleatorio() {
        Random rd = new Random();
        return listaDeCarrosParaCompra[rd.nextInt(listaDeCarrosParaCompra.length)];
    }
}

