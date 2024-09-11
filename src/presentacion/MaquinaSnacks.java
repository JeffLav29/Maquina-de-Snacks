package presentacion;

import dominio.Snack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Snacks;

public class MaquinaSnacks {

    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        //Proyecto Maquina de Snacks
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        //Creamos la lista de productos de tipo snacks
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de Snacks ***");
        Snacks.mostrarSnack(); //mostramos el inventario de snacks
        do {
            try {

                int opcion = mostrarMenu(sc);
                salir = ejecutarOpciones(opcion, sc, productos);

            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
                sc.nextLine();
            } finally {
                System.out.println(); //imprime un salto de linea con cada iteracion
            }
        } while (!salir);
    }

    private static int mostrarMenu(Scanner sc) {
        int opcion=0;
        System.out.print("""
                           Menu:
                           1. Comprar Snack
                           2. Mostrar Ticket
                           3. Agregar Nuevo Snack
                           4. Salir
                           Digite una opcion:\s""");
        opcion = sc.nextInt();
        
        return opcion;
    }

    private static boolean ejecutarOpciones(int opcion, Scanner sc,List<Snack> productos) {
        boolean salir = false;
        switch (opcion) {
            case 1 -> comprarSnack(sc, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarNuevoSnack(sc);
            case 4 ->{
                System.out.println("Adios...");
                salir = true;
            }
            default -> System.out.println("Opcion invalida");
        }
        return salir;
    }

    private static void comprarSnack(Scanner sc, List<Snack> productos) {
        System.out.print("Que snack desea comprar?(id): ");
        int idSnacks = sc.nextInt();
        boolean snackEncontrado = false;
        for (Snack snack: Snacks.getSnacks()) {
            if (idSnacks == snack.getIdSnack()) {
                productos.add(snack);
                snackEncontrado = true;
                break;
            }
            
        }
        if (!snackEncontrado) {
            System.out.println("Id de snack no encontrado: "+idSnacks);
        }
    }
    
    private static void mostrarTicket(List<Snack> productos){
        String ticket = "*** Ticket de Venta ***";
        double total = 0.0;
        for(Snack producto: productos){
            ticket+="\n\t- "+ producto.getNombre()+" - $"+producto.getPrecio();
            total+=producto.getPrecio();
        }
        ticket += "\n\tTotal -> $"+total;
        System.out.println(ticket);
    }
    
    private static void agregarNuevoSnack(Scanner sc){
        sc.nextLine();
        System.out.print("Nombre del snack: ");
        String nombre = sc.nextLine();
        System.out.print("Precio del snack: ");
        double precio = sc.nextDouble();
        Snacks.agregarSnack(new Snack(nombre,precio));
        System.out.println("Tu snack se ha agreado correctamente");
        Snacks.mostrarSnack();
    }
}
