import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Policia> policias = new ArrayList<>();
    private static List<Arma> armas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1 -> agregarPolicia();
                case 2 -> agregarArma();
                case 3 -> mostrarArmas();
                case 0 -> System.out.println("\nSaliendo del sistema.");
                default -> System.out.println("\nOpción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Sistema de Administración de Armas ---\n");
        System.out.println("1. Agregar Policía");
        System.out.println("2. Agregar Arma");
        System.out.println("3. Mostrar Armas");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private static void agregarPolicia() {
        System.out.print("\nIngrese nombre del policía: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del policía: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese legajo del policía: ");
        int legajo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Policia policia = new Policia(nombre, apellido, legajo);
        policias.add(policia);
        System.out.println("\nPolicía agregado: " + policia);
    }

    private static void agregarArma() {
        if (policias.isEmpty()) {
            System.out.println("\nPrimero debe agregar al menos un policía!!!");
            return;
        }

        System.out.println("\n--- Seleccione el tipo de arma ---\n");
        System.out.println("1. Arma Corta");
        System.out.println("2. Arma Larga");
        System.out.print("\nSeleccione una opción: ");
        int tipoArma = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("\nSeleccione el policía asociado (por índice):\n");
        for (int i = 0; i < policias.size(); i++) {
            System.out.println(i + ". " + policias.get(i));
        }
        int indicePolicia = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        Policia policia = policias.get(indicePolicia);

        System.out.print("\nIngrese la cantidad de municiones: ");
        int cantidadMuniciones = scanner.nextInt();
        System.out.print("Ingrese el alcance en metros: ");
        double alcance = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el calibre: ");
        String calibre = scanner.nextLine();
        System.out.print("Ingrese el estado (NUEVA, EN MANTENIMIENTO, EN USO): ");
        String estado = scanner.nextLine();

        if (tipoArma == 1) { // Arma Corta
            System.out.print("¿Es automática? (true/false): ");
            boolean esAutomatica = scanner.nextBoolean();
            ArmaCorta armaCorta = new ArmaCorta(policia, cantidadMuniciones, alcance, marca, calibre, estado, esAutomatica);
            armas.add(armaCorta);
            System.out.println("\nArma corta agregada: \n" + armaCorta);
        } else if (tipoArma == 2) { // Arma Larga
            System.out.print("¿Tiene sello RENAR? (true/false): ");
            boolean tieneSelloRENAR = scanner.nextBoolean();
            scanner.nextLine(); // Limpiar el buffer
            System.out.print("Ingrese descripción del uso: ");
            String descripcionUso = scanner.nextLine();
            System.out.print("Ingrese nivel del arma (1-5): ");
            int nivel = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            ArmaLarga armaLarga = new ArmaLarga(policia, cantidadMuniciones, alcance, marca, calibre, estado, tieneSelloRENAR, descripcionUso, nivel);
            armas.add(armaLarga);
            System.out.println("\nArma larga agregada: \n" + armaLarga);
        } else {
            System.out.println("Tipo de arma no válido.");
        }
    }

    private static void mostrarArmas() {
        System.out.println("\n--- Lista de Armas ---");
        if (armas.isEmpty()) {
            System.out.println("\nNo hay armas registradas.");
        } else {
            for (Arma arma : armas) {
                System.out.println(arma);
            }
        }
    }|
}