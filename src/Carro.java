public class Carro {
    int tanqueGasolina = 100;
    long gasolinaConsumida = 0;
    long gasolinaComprada = 0;
    long oroGastado = 0;
    String nombreCarro;
    int motorPredeterminado = 0;
    int llantaPredeterminada = 0;

    TipoMotor[] motores = new TipoMotor[3];
    TipoLlantas[] llantas = new TipoLlantas[3];

    public Carro(String nombreCarro) {
        this.nombreCarro = nombreCarro;
    }

    public int getTanqueGasolina() {

        return tanqueGasolina;
    }

    public void setTanqueGasolina(int tanqueGasolina) {
        this.tanqueGasolina = tanqueGasolina;
    }

    public long getGasolinaConsumida() {
        return gasolinaConsumida;
    }

    public void setGasolinaConsumida(long gasolinaConsumida) {
        this.gasolinaConsumida = gasolinaConsumida;
    }

    public long getGasolinaComprada() {
        return gasolinaComprada;
    }

    public void setGasolinaComprada(long gasolinaComprada) {
        this.gasolinaComprada = gasolinaComprada;
    }

    public long getOroGastado() {
        return oroGastado;
    }

    public void setOroGastado(long oroGastado) {
        this.oroGastado = oroGastado;
    }

    public String getNombreCarro() {
        return nombreCarro;
    }

    public void setNombreCarro(String nombreCarro) {
        this.nombreCarro = nombreCarro;
    }

    public TipoMotor[] getMotores() {
        return motores;
    }

    public void setMotores(TipoMotor[] motores) {
        this.motores = motores;
    }

    public TipoLlantas[] getLlantas() {
        return llantas;
    }

    public void setLlantas(TipoLlantas[] llantas) {
        this.llantas = llantas;
    }

    public void crearMotores() {
        motores[0] = new TipoMotor(4, "Motor basico.", 5, true);
        motores[1] = new TipoMotor(5, "Motor medio.", 20, false);
        motores[2] = new TipoMotor(7, "Motor alto rendimiento.", 35, false);
    }

    public void crearLlantas() {
        llantas[0] = new TipoLlantas(2, "Calidad baja.", 25, true);
        llantas[1] = new TipoLlantas(3, "Calidad media.", 50, false);
        llantas[2] = new TipoLlantas(5, "Calidad alta.", 75, false);

    }

    public void imprimirCarroParaCarrera() {
        System.out.println("1. " + nombreCarro);
        System.out.println("La capacidad del tanque es "+ tanqueGasolina + ".");
        motores[motorPredeterminado].imprmirMotorPredeterminado();
        llantas[llantaPredeterminada].imprimirLlantaPredeterminada();

    }
}