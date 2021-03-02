public class TipoMotor {
    int potencia;
    String rendimiento;
    int precioMotorGemas;
    boolean estadoCompra;

    public TipoMotor(int potencia, String rendimiento, int precioMotorGemas, boolean estadoCompra) {
        this.potencia = potencia;
        this.rendimiento = rendimiento;
        this.precioMotorGemas = precioMotorGemas;
        this.estadoCompra = estadoCompra;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(String rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int getPrecioMotorGemas() {
        return precioMotorGemas;
    }

    public void setPrecioMotorGemas(int precioMotorGemas) {
        this.precioMotorGemas = precioMotorGemas;
    }

    public boolean getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(boolean estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public void imprmirMotorPredeterminado() {
        System.out.println("La calidad del motor es: " + rendimiento);
        System.out.println("La potencia del motor es: " + potencia + ".");
    }
}