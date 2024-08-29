import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private List<Cartas> cartas;
    private int numeroRondas;

    public Juego(int numeroJugadores) {
        this.jugadores = crearJugadores(numeroJugadores);
    }

    public Juego(int numeroJugadores, int numeroRondas) {
        this.jugadores = crearJugadores(numeroJugadores);
        this.numeroRondas = numeroRondas;
    }

    private List<Jugador> crearJugadores(int numeroJugadores) {
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < numeroJugadores; i++) {
            jugadores.add(new Jugador("Jugador" + (i + 1), 50));
        }
        return jugadores;
    }

    public List<Cartas> crearBaraja() {
        List<Cartas> baraja = new ArrayList<>();
        String[] simbolos = {"Corazon", "Diamantes", "Trebol", "Espadas"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String simbolo : simbolos) {
            for (String valor : valores) {
                baraja.add(new Cartas(valor, simbolo));
            }
        }
        return baraja;
    }

    private void barajar() {
        Collections.shuffle(cartas);
    }

    private void repartirCartas() {
        for (Jugador jugador : jugadores) {
            for (int i = 0; i < 5; i++) {
                jugador.agregarCarta(cartas.remove(0));
            }
        }
    }

    private void limpiarCartas() {
        for (Jugador jugador : jugadores) {
            jugador.borrarCartas();
        }
    }

    public void jugar() {
        for (int ronda = 0; ronda < numeroRondas; ronda++) {
            System.out.println("Ronda: " + (ronda + 1));
            this.cartas = crearBaraja();
            barajar();
            repartirCartas();
            mostrarCartas();
            Jugador ganador = jugarCarta();
            System.out.println("El ganador de esta ronda es: " + ganador.getNombre());
            limpiarCartas();
        }
    }

    private void mostrarCartas() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getCartas());
        }
    }

    private Jugador jugarCarta() {
        Jugador ganador = null;
        Cartas cartaGanadora = null;

        for (Jugador jugador : jugadores) {
            Cartas cartaActual = jugador.jugarCarta();
            System.out.println("Jugador " + jugador.getNombre() + " Carta Seleccionada: " + cartaActual);

            if (cartaGanadora == null || cartaActual.getValorNumerico() > cartaGanadora.getValorNumerico()) {
                cartaGanadora = cartaActual;
                ganador = jugador;
            }
        }

        return ganador;
    }
}