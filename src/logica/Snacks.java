package logica;

import dominio.Snack;
import java.util.ArrayList;
import java.util.List;

public class Snacks {

    private static final List<Snack> snacks;

    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papitas", 20.00));
        snacks.add(new Snack("Gaseosa", 70.00));
        snacks.add(new Snack("Sandwich", 100.00));
    }

    public static void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public static void mostrarSnack() {
        String inventarioSnacks = "";
        System.out.println("----- Snacks en el inventario -------");
        snacks.forEach(snack -> {
            System.out.println(snack);
        });
        
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getSnacks() {
        return snacks;
    }
}
