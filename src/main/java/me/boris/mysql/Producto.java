package me.boris.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {

    private int pro_id;
    private String pro_descripcion;
    private String pro_nombre;
    private double pro_precio;
    private int pro_stock;

    public Producto() {
    }

}
