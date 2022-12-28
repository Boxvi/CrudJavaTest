package me.boris.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoCrud extends Producto implements CrudGeneric<Producto, Integer> {

    private Conexion conexion = new Conexion();

    @Override
    public boolean create(Producto producto) {

        String sql = "INSERT INTO producto (pro_descripcion,pro_nombre,pro_precio,pro_stock)VALUES('"
                + producto.getPro_descripcion() + "','" + producto.getPro_nombre() + "'," + producto.getPro_precio() + ","
                + producto.getPro_stock() + ");";

       // System.out.println(sql);

        return conexion.updateCreateDelete(sql);
    }

    @Override
    public boolean update(Producto producto) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Producto read(Integer integer) {

        String sql = "SELECT * FROM producto WHERE pro_id = " + integer;

        ResultSet resultSet = conexion.select(sql);
        Producto producto = new Producto();
        try {
            while (resultSet.next()) {

                producto.setPro_id(resultSet.getInt("pro_id"));
                producto.setPro_descripcion(resultSet.getString("pro_descripcion"));
                producto.setPro_nombre(resultSet.getString("pro_nombre"));
                producto.setPro_precio(resultSet.getDouble("pro_precio"));
                producto.setPro_stock(resultSet.getInt("pro_stock"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return producto;
    }

    @Override
    public List<Producto> read() {

        String sql = "SELECT * FROM producto";

        ResultSet resultSet = conexion.select(sql);
        List<Producto> productoList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Producto producto = new Producto();

                producto.setPro_id(resultSet.getInt("pro_id"));
                producto.setPro_descripcion(resultSet.getString("pro_descripcion"));
                producto.setPro_nombre(resultSet.getString("pro_nombre"));
                producto.setPro_precio(resultSet.getDouble("pro_precio"));
                producto.setPro_stock(resultSet.getInt("pro_stock"));

                productoList.add(producto);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return productoList;
    }
}

