package co.edu.uptc.controller;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MainMenu {
    private ControllerProduct controllerProduct = new ControllerProduct();
    private ControllerCustomer controllerCustomer = new ControllerCustomer();
    Scanner scanner = new Scanner(System.in);
    // Agrega los demás controladores si los tienes
    // private ControllerClient controllerClient = new ControllerClient();
    // private ControllerOrder controllerOrder = new ControllerOrder();
    // private ControllerShipping controllerShipping = new ControllerShipping();

    public MainMenu() {
        mostrarMenu();
    }

    private void mostrarMenu() {
        JOptionPane.showMessageDialog(null, "¡Bienvenido al Sistema!");

        String opcionPrincipal;
        do {
            opcionPrincipal = JOptionPane.showInputDialog(null,
                    "Menú Principal:\n1. Registrar\n2. Imprimir\n3. Buscar\n4. Salir",
                    "Menú Principal", JOptionPane.QUESTION_MESSAGE);

            if (opcionPrincipal == null || opcionPrincipal.equals("4")) {
                JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema!");
                System.exit(0);
                break;
            }

            if (opcionPrincipal.matches("[1-3]")) {
                mostrarSubmenu(opcionPrincipal);
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida.");
            }

        } while (true);
    }

    private void mostrarSubmenu(String accionPrincipal) {
        String opcionSecundaria;
        do {
            opcionSecundaria = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:\n1. Producto\n2. Cliente\n3. Pedido\n4. Envío\n5. Menú Anterior\n6. Salir",
                    "Submenú", JOptionPane.QUESTION_MESSAGE);

            if (opcionSecundaria == null || opcionSecundaria.equals("6")) {
                JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                System.exit(0);
            }

            if (opcionSecundaria.equals("5")) {
                mostrarMenu();
                break;
            }

            if (opcionSecundaria.matches("[1-4]")) {
                ejecutarAccion(accionPrincipal, opcionSecundaria);
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida.");
            }

        } while (true);
    }

    private void ejecutarAccion(String accion, String entidad) {
       

        switch (accion + entidad) {
            case "11": // Registrar Producto
                JOptionPane.showMessageDialog(null, "Registrando Producto");
                controllerProduct.addProduct();
                
                
                break;
            case "12": // Registrar Cliente
                JOptionPane.showMessageDialog(null, "Registrando Cliente");
                controllerCustomer.addCustomer();
                break;
            case "13": // Registrar Pedido
                JOptionPane.showMessageDialog(null, "Registrando Pedido");
                break;
            case "14": // Registrar Envío
                JOptionPane.showMessageDialog(null, "Registrando Envío");
                break;
            case "21": // Imprimir Producto
                JOptionPane.showMessageDialog(null, "Imprimiendo Producto");
                controllerProduct.readProduct();
                break;
            case "22": // Imprimir Cliente
                JOptionPane.showMessageDialog(null, "Imprimiendo Cliente");
                controllerCustomer.readCustomer();
                break;
            case "23": // Imprimir Pedido
                JOptionPane.showMessageDialog(null, "Imprimiendo Pedido");
                break;
            case "24": // Imprimir Envío
                JOptionPane.showMessageDialog(null, "Imprimiendo Envío");
                break;
            case "31": // Buscar Producto
                controllerProduct.findProduct(JOptionPane.showInputDialog(null,
                "Digite ID del producto a buscar",
                "ID", JOptionPane.QUESTION_MESSAGE));
                break;
            case "32": // Buscar Cliente
                JOptionPane.showMessageDialog(null, "Buscando Cliente");
                controllerCustomer.findCustomer(JOptionPane.showInputDialog(null,
                "Digite ID del Cliente a buscar",
                "ID", JOptionPane.QUESTION_MESSAGE));
                break;
            case "33": // Buscar Pedido
                JOptionPane.showMessageDialog(null, "Buscando Pedido");
                break;
            case "34": // Buscar Envío
                JOptionPane.showMessageDialog(null, "Buscando Envío");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Acción no válida.");
        }
    }
}