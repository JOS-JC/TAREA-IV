import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jugador {
    private String nombre;
    private Float saldo;

    public int punteo;
    private List<Cartas> cartas;
    private Cartas cartaActual;

    public Jugador(String nombre, float saldo){
        this.nombre = nombre;
        this.saldo = saldo;
        this.punteo = 0;
        this.cartas = new ArrayList<>();
        this.cartaActual = null;
    }
    public String getNombre(){
        return nombre;

    }
    public List<Cartas> getCartas(){
        return cartas;
    }
    public int getPunteo() {
        return punteo;
    }
    public float getSaldo() {
        return saldo;
    }
    public Cartas getCartasActual() {
        return cartaActual;
    }
    public void sumarPunto(){
        this.punteo++;
    }
    public void borrarCartas(){
        cartas.clear();
    }
    public void agregarCarta(Cartas carta){
        cartas.add(carta);

    }

    public Cartas jugarCarta(){
        Random randon = new Random();
        int indiceCarta = randon.nextInt(cartas.size());
        cartaActual = cartas.remove(indiceCarta);
        return cartaActual;
    }


}