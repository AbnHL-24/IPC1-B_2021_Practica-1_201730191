public class Estadistica {
    private String pistas;
    private int longitud;
    String[] podio = new String [longitud];
    

    public Estadistica(String pistas, String[] podio) {
        this.pistas = pistas;
        this.longitud = podio.length;
        this.podio = podio;
    }

    public void imprimirEstadisticas() {
        System.out.println(pistas);
        for (int i = 0; i < podio.length; i++) {
            System.out.println(podio[i]);
        }
    }
}
