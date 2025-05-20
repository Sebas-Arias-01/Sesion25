package co.edu.uptc.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.uptc.model.Product;

public class ControllerProduct {
   
    private String filePath = "Sesion25\\src\\co\\edu\\uptc\\repository\\products.txt";
    private String[] productsName = {"Id", "Descripcion", "Presentacion"};
    private String[] characteristics = new String[3];
    private Product product = new Product();
    private List<Product> products = new ArrayList<>();

    public void addProduct() {
        
        Scanner scanner = new Scanner(System.in);
        String productWrite = "";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (int i = 0; i < characteristics.length; i++) {
                System.out.print("Digite " + productsName[i] + " del producto: ");
                characteristics[i] = scanner.nextLine() ;
                productWrite += characteristics[i] + ",";
            }

            product = new Product(Integer.parseInt(characteristics[0]), characteristics[1], characteristics[2]);
            products.add(product);

            writer.write(productWrite);
            writer.newLine();

            System.out.println("Producto agregado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void readProduct() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nProductos registrados:\n");

            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                for (int i = 0; i < productsName.length && st.hasMoreTokens(); i++) {
                    System.out.println(productsName[i] + ": " + st.nextToken());
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public void findProduct(String id) {

        Boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
        
                    if (id.equals(st.nextToken())) {
                        System.out.println("El producto con id " + id + " tiene los siguientes atributos: \n" +
                                           "Descripción: " + st.nextToken() + "\n" +
                                           "Presentación: " + st.nextToken());
                        found = true;
                    }
            }

            if (!found) {
                System.out.println("Producto no fue encontrado.");
            }
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

    } 
}
