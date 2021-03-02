public class TipoLlantas {
    int coeficienteLlantas;
    String calidadLlantas;
    int precioLlantasOro;
    boolean estadoDeCompra;

    public TipoLlantas(int coeficienteLlantas, String calidadLlantas, int precioLlantasOro, boolean estadoDeCompra){
        this.coeficienteLlantas = coeficienteLlantas;
        this.calidadLlantas = calidadLlantas;
        this.precioLlantasOro = precioLlantasOro;
        this.estadoDeCompra = estadoDeCompra;
    }

    public int getCoeficienteLlantas() {
        return coeficienteLlantas;
    }

    public void setCoeficienteLlantas(int coeficienteLlantas) {
        this.coeficienteLlantas = coeficienteLlantas;
    }

    public String getCalidadLlantas() {
        return calidadLlantas;
    }

    public void setCalidadLlantas(String calidadLlantas) {
        this.calidadLlantas = calidadLlantas;
    }

    public int getPrecioLlantasOro() {
        return precioLlantasOro;
    }

    public void setPrecioLlantasOro(int precioLlantasOro) {
        this.precioLlantasOro = precioLlantasOro;
    }

    public boolean getEstadoDeCompra() {
        return estadoDeCompra;
    }

    public void setEstadoDeCompra(boolean estadoDeCompra) {
        this.estadoDeCompra = estadoDeCompra;
    }

    public void imprimirLlantaPredeterminada() {
        System.out.println("La calidad de las llantas son : " + calidadLlantas);
        System.out.println("El coeficiente de las llantas es: " + coeficienteLlantas + ".");
    }
}