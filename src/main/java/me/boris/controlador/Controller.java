package me.boris.controlador;

import me.boris.mysql.Producto;
import me.boris.mysql.ProductoCrud;
import me.boris.vista.Productos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Controller extends java.lang.Thread {

    private Productos view;
    private int contador = 0;

    private ProductoCrud productoCrud = new ProductoCrud();


    public Controller(Productos view) {


        this.view = view;

        nombres();
        tamanios();

    }

    private void nombres() {
        view.getBtn1().setText("Hola");
        view.getBtn2().setText("Adios");

        view.getTable1().setModel(new DefaultTableModel(
                null,
                new String[]{
                        "ID", "DESCRIPCION", "NOMBRE", "PRECIO", "STOCK"
                }
        ));

    }

    private void tamanios() {
        JFrame frame = new JFrame("Controller");
        frame.setContentPane(view.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
    }

    public void iniciar() {

        view.getBtn1().addActionListener(e -> {
            view.getJlbl2().setText("cambie texto 1 + HOLA");

        });

        view.getBtn2().addActionListener(e -> {
            view.getJlbl1().setText("cambie texto 2 + ADIOS");
        });

        run();
    }

    @Override
    public void run() {
        while (true) {
            contador++;
            System.out.println(contador);

            List<Producto> lista = productoCrud.read();


            DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
            model.setRowCount(0);
            Object[] fila = new Object[5];
            for (int i = 0; i < lista.size(); i++) {
                fila[0] = lista.get(i).getPro_id();
                fila[1] = lista.get(i).getPro_descripcion();
                fila[2] = lista.get(i).getPro_nombre();
                fila[3] = lista.get(i).getPro_precio();
                fila[4] = lista.get(i).getPro_stock();
                model.addRow(fila);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
