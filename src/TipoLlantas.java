public class TipoLlantas {
    int coeficienteLlantas;
    String calidadLlantas;
    int precioLlantasOro;
    boolean estadoCompra;

    public TipoLlantas(int coeficienteLlantas, String calidadLlantas, int precioLlantasOro, boolean estadoCompra){
        this.coeficienteLlantas = coeficienteLlantas;
        this.calidadLlantas = calidadLlantas;
        this.precioLlantasOro = precioLlantasOro;
        this.estadoCompra = estadoCompra;
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

    public boolean isEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(boolean estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public void imprimirLlantaPredeterminada() {
        System.out.println("La calidad de las llantas son : " + calidadLlantas);
        System.out.println("El coeficiente de las llantas es: " + coeficienteLlantas + ".");
    }
}