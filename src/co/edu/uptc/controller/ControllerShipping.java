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
import co.edu.uptc.model.Shipping;

public class ControllerShipping {

    private String filePath = "Sesion25\\src\\co\\edu\\uptc\\repository\\shippings.txt";
    private String[] shippingName = {"Id", "Nombre Del Transporte", "Estado","Fecha"};
    private String[] characteristics = new String[4];
    private Shipping shipping = new Shipping();
    private List<Shipping> shippings = new ArrayList<>();

    public void addShipping() {
        Scanner scanner = new Scanner(System.in);
        String shippingWrite = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (int i = 0; i < characteristics.length; i++) {
                System.out.print("Digite " + shippingName[i] + " del Envio: ");
                characteristics[i] = scanner.nextLine() ;
                shippingWrite += characteristics[i] + ",";
            }

            shipping = new Shipping(Integer.parseInt(characteristics[0]), characteristics[1], characteristics[2], characteristics[3]);
            shippings.add(shipping);

            writer.write(shippingWrite);
            writer.newLine();

            System.out.println("Envio agregado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void readShipping() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nClientes registrados:\n");

            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                for (int i = 0; i < shippingName.length && st.hasMoreTokens(); i++) {
                    System.out.println(shippingName[i] + ": " + st.nextToken());
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public void findShipping(String id) {

        Boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
        
                    if (id.equals(st.nextToken())) {
                        System.out.println("El envio con id " + id + " tiene los siguientes atributos: \n" +
                                           "Nombre Transporte: " + st.nextToken() + "\n" +
                                           "Estado: " + st.nextToken() + "\n" +
                                           "Fecha: " + st.nextToken());
                        found = true;
                    }
            }

            if (!found) {
                System.out.println("Envio no fue encontrado.");
            }
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

    } 
}
