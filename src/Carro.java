public class Carro {
    private int tanqueGasolina = 100;
    private long gasolinaConsumida = 0;
    private long gasolinaComprada = 0;
    private long oroGastado = 0;
    private String nombreCarro;
    private int motorPredeterminado = 0;
    private int llantaPredeterminada = 0;

    TipoMotor[] motores = new TipoMotor[4];
    TipoLlantas[] llantas = new TipoLlantas[4];

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

    public int getMotorPredeterminado() {
        return motorPredeterminado;
    }

    public void setMotorPredeterminado(int motorPredeterminado) {
        this.motorPredeterminado = motorPredeterminado;
    }

    public int getLlantaPredeterminada() {
        return llantaPredeterminada;
    }

    public void setLlantaPredeterminada(int llantaPredeterminada) {
        this.llantaPredeterminada = llantaPredeterminada;
    }

    public void crearMotores() {
        motores[0] = new TipoMotor(2, "Motor generico", 0, true);
        motores[1] = new TipoMotor(4, "Motor basico.", 5, false);
        motores[2] = new TipoMotor(5, "Motor medio.", 20, false);
        motores[3] = new TipoMotor(7, "Motor alto rendimiento.", 35, false);
    }

    public void crearLlantas() {
        llantas[0] = new TipoLlantas(1, "Llantas Genericas", 0, true);
        llantas[1] = new TipoLlantas(2, "Calidad baja.", 25, false);
        llantas[2] = new TipoLlantas(3, "Calidad media.", 50, false);
        llantas[3] = new TipoLlantas(5, "Calidad alta.", 75, false);

    }

    public void imprimirCarroParaCarrera(int i) {
        int numeroDeCarro = i+1;
        System.out.println(numeroDeCarro + ". " + nombreCarro);
        System.out.println("La capacidad del tanque es "+ tanqueGasolina + ".");
        motores[motorPredeterminado].imprmirMotorPredeterminado();
        llantas[llantaPredeterminada].imprimirLlantaPredeterminada();

    }

    public void imprimirCarroParaGarage () {
        System.out.println(nombreCarro);
        System.out.println("La gasolina actual del tanque es "+ tanqueGasolina + ".");
        motores[motorPredeterminado].imprmirMotorPredeterminado();
        llantas[llantaPredeterminada].imprimirLlantaPredeterminada();
    }

    public int getPotenciaDelMotor() {
        return motores[motorPredeterminado].getPotencia();
    }

    public int getCoheficienteDeLlantas() {
        return llantas[llantaPredeterminada].getCoeficienteLlantas();
    }

    public void imprimirCarrosParaEleccionEnGarege(int numeroDeCarro) {
        System.out.println(numeroDeCarro +". " + getNombreCarro());
    }
}