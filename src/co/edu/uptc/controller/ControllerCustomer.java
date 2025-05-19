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

import co.edu.uptc.model.Customer;

public class ControllerCustomer {

     private String filePath = "MiVersionSesion25\\src\\co\\edu\\uptc\\repository\\customers.txt";
    private String[] customerName = {"Id", "Dirección", "Telefono","Email"};
    private String[] characteristics = new String[4];
    private Customer customer = new Customer();
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        String customerWrite = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (int i = 0; i < characteristics.length; i++) {
                System.out.print("Digite " + customerName[i] + " del Cliente: ");
                characteristics[i] = scanner.nextLine() ;
                customerWrite += characteristics[i] + ",";
            }

            customer = new Customer(characteristics[0], characteristics[1], characteristics[2], characteristics[3]);
            customers.add(customer);

            writer.write(customerWrite);
            writer.newLine();

            System.out.println("Cliente agregado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void readCustomer() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nClientes registrados:\n");

            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                for (int i = 0; i < customerName.length && st.hasMoreTokens(); i++) {
                    System.out.println(customerName[i] + ": " + st.nextToken());
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public void findCustomer(String id) {

        Boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
        
                    if (id.equals(st.nextToken())) {
                        System.out.println("El Cliente con id " + id + " tiene los siguientes atributos: \n" +
                                           "Direccion: " + st.nextToken() + "\n" +
                                           "Telefono: " + st.nextToken() + "\n" +
                                           "Email: " + st.nextToken());
                        found = true;
                    }
            }

            if (!found) {
                System.out.println("Cliente no fue encontrado.");
            }
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

    } 
}
