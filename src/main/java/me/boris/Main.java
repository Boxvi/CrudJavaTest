package me.boris;

import me.boris.controlador.Controller;
import me.boris.vista.Productos;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller(new Productos());

        controller.iniciar();


    }

        /*
        ProductoCrud productoCrud = new ProductoCrud();

        List<Producto> productoList = productoCrud.read();

        System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "ID", "DESCRIPCION", "NOMBRE", "PRECIO", "STOCK");
        for (Producto producto : productoList) {
            System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", producto.getPro_id(), producto.getPro_descripcion(),
                    producto.getPro_nombre(), producto.getPro_precio(), producto.getPro_stock());
        }

       // Producto productos = new Producto(0, "dfsfssf", "nombre", 30.44, 1000);

       // productoCrud.create(productos);

        System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "ID", "DESCRIPCION", "NOMBRE", "PRECIO", "STOCK");
        for (Producto producto : productoList) {
            System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", producto.getPro_id(), producto.getPro_descripcion(),
                    producto.getPro_nombre(), producto.getPro_precio(), producto.getPro_stock());
        }



    }*/
}