package me.boris.mysql;

import org.junit.Test;

public class ProductoTest {

    @Test
    public void test() throws Exception{
        ProductoCrud productoCrud = new ProductoCrud();
        Producto producto = new Producto(1, "descripcion", "nombre", 1.0, 1);
        productoCrud.create(producto);

        assert productoCrud.read(1).getPro_id() == 1;


    }


}
