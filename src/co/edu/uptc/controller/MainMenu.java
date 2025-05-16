package co.edu.uptc.controller;

import java.util.Scanner;

public class MainMenu {

   public MainMenu() {
        Scanner scanner = new Scanner(System.in);
        int mainOption = 0;

        System.out.println("¡Bienvenido al sistema de gestión!");

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Registrar");
            System.out.println("2. Imprimir");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            mainOption = scanner.nextInt();

            switch (mainOption) {
                case 1:
                    showSubMenu("Registrar");
                    break;
                case 2:
                    showSubMenu("Imprimir");
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el programa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (mainOption != 3);

        scanner.close();
    }

    private void showSubMenu(String action) {
        Scanner scanner = new Scanner(System.in);
        int subOption = 0;

        System.out.println("\n" + action.toUpperCase() + " OPCIONES:");
        System.out.println("1. Producto");
        System.out.println("2. Cliente");
        System.out.println("3. Pedido");
        System.out.println("4. Envío");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        subOption = scanner.nextInt();

        switch (subOption) {
            case 1:
                System.out.println(action + " Producto seleccionado.");
                break;
            case 2:
                System.out.println(action + " Cliente seleccionado.");
                break;
            case 3:
                System.out.println(action + " Pedido seleccionado.");
                break;
            case 4:
                System.out.println(action + " Envío seleccionado.");
                break;
            case 5:
                System.out.println("Saliendo del programa.");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida en el submenú.");
        }
    }


}
