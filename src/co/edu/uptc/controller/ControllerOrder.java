package co.edu.uptc.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


import co.edu.uptc.model.Order;

public class ControllerOrder {

    private String filePath = "Sesion25\\src\\co\\edu\\uptc\\repository\\orders.txt";
    private String[] orderName = {"Id", "Fecha De Creación", "Estado","ID del cliente"};
    private String[] characteristics = new String[4];
    private Order order = new Order();
    private List<Order> orders = new ArrayList<>();

    public void addOrder() {
        Scanner scanner = new Scanner(System.in);
        String orderWrite = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (int i = 0; i < characteristics.length; i++) {
                System.out.print("Digite " + orderName[i] + " de la Orden: ");
                characteristics[i] = scanner.nextLine() ;
                orderWrite += characteristics[i] + ",";
            }

            order = new Order(characteristics[0], characteristics[1], characteristics[2], characteristics[3]);
            orders.add(order);

            writer.write(orderWrite);
            writer.newLine();

            System.out.println("Orden agregada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void readOrder() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nOrdenes registradas:\n");

            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                for (int i = 0; i < orderName.length && st.hasMoreTokens(); i++) {
                    System.out.println(orderName[i] + ": " + st.nextToken());
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public void findOrder(String id) {

        Boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
        
                    if (id.equals(st.nextToken())) {
                        System.out.println("La orden con id " + id + " tiene los siguientes atributos: \n" +
                                           "Fecha De Creación: " + st.nextToken() + "\n" +
                                           "Estado: " + st.nextToken() + "\n" +
                                           "ID Cliente: " + st.nextToken());
                        found = true;
                    }
            }

            if (!found) {
                System.out.println("Orden no fue encontrado.");
            }
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

    } 
}
