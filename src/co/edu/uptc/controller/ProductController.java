package co.edu.uptc.controller;

import java.util.*;

import co.edu.uptc.model.Persistence;
import co.edu.uptc.model.Product;

public class ProductController {
    private static final String ARCHIVO = "product.txt";
    private Persistence fileManagement = new Persistence();

    public void guardarProducto(Product p) throws Exception {
        String linea = p.getId() + "|" + p.getDescription() + "|" + p.getPresentation();
        fileManagement.saveLine(ARCHIVO, linea);
    }

    public Product buscarPorId(String idBuscado) throws Exception {
        List<String> productos = fileManagement.readFile(ARCHIVO);
        for (String linea : productos) {
            StringTokenizer st = new StringTokenizer(linea, "|");
            String id = st.nextToken();
            String desc = st.nextToken();
            String pres = st.nextToken();
            if (id.equals(idBuscado)) {
                return new Product(id, desc, pres);
            }
        }
        return null;
    }

    public List<Product> buscarPorDescripcion(String descripcion) throws Exception {
        List<String> productos = fileManagement.readFile(ARCHIVO);
        List<Product> resultado = new ArrayList<>();
        for (String linea : productos) {
            StringTokenizer st = new StringTokenizer(linea, "|");
            String id = st.nextToken();
            String desc = st.nextToken();
            String pres = st.nextToken();
            if (desc.equalsIgnoreCase(descripcion)) {
                resultado.add(new Product(id, desc, pres));
            }
        }
        return resultado;
    }
}
