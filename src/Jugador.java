public class Jugador {
    String nombre;
    String nickname;
    int edad;
    long gemas = 30;
    long oro = 50;
    int cantidadCarros = 0;
    int carroPredeterminado;

    Carro[] carros = new Carro [5];


    public Jugador(String nombre, String nickname, int edad){
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public int getEdad() {
        return edad;
    }

    public void setGemas(long gemas) {
        this.gemas = gemas;
    }

    public long getOro() {
        return oro;
    }

    public void setOro(long oro) {
        this.oro = oro;
    }

    public int getCantidadCarros() {
        return cantidadCarros;
    }

    public void setCantidadCarros(int cantidadCarros) {
        this.cantidadCarros = cantidadCarros;
    }

    public int getCarroPredeterminado() {
        return carroPredeterminado;
    }

    public void setCarroPredeterminado(int carroPredeterminado) {
        this.carroPredeterminado = carroPredeterminado;
    }

    public Carro[] getCarros() {
        return carros;
    }

    public void setCarros(Carro[] carros) {
        this.carros = carros;
    }

    public void crearCarro( String nombreCarro) {
        carros[cantidadCarros] = new Carro(nombreCarro);
        carros[cantidadCarros].crearMotores();
        carros[cantidadCarros].crearLlantas();
        cantidadCarros++;
    }

    public void imprimirCarrosParaCarrera() {
        System.out.println();
        System.out.println("Escoge el carro que deseas utilizar:");
        for (int i = 0; i < cantidadCarros; i++) {
            carros[i].imprimirCarroParaCarrera();
        }

    }


    public boolean verificarGasolinaDeCarrosParaPista(int tamañoDePista) {
        int cantidadDeCarrosDisponibles = 0;
        for (int i = 0; i < cantidadCarros; i++) {
            if (tamañoDePista <= carros[i].getTanqueGasolina()) {
                cantidadDeCarrosDisponibles++;
            }
        }
        if(cantidadDeCarrosDisponibles > 0) {
            return true;
        } else {
            return false;
        }
    }
}