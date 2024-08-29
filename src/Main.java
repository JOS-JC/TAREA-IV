import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ingresar el numero de jugadores
        System.out.println("Ingrese el numero de jugadores");
        int n = sc.nextInt();


        //Ingresar el numero de partidas
        System.out.println("Ingrese el numero de partidas o rondas");
        int p = sc.nextInt();

        Juego juego=new Juego(n, p);
        juego.jugar();

        //metodo to strig aprender a usar
    }
}