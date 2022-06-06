package com.cetys.proyectox;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static Receta nueva_receta;

    public static void funcion1(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel texto1 = new JLabel("Ahora se agregaran los ingredientes");
        texto1.setBounds(10, 10, 400, 20);
        JButton BS = new JButton("ok :)");
        BS.setBounds(10, 100, 80, 20);
        BS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcion2(frame);
            }

        });
        frame.add(texto1);
        frame.add(BS);

    }

    public static void funcion2(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel texto1 = new JLabel("Nombre del ingrediente");
        texto1.setBounds(10, 10, 400, 20);
        JTextField Nombre = new JTextField("");
        Nombre.setBounds(10, 40, 200, 20);
        JLabel texto2 = new JLabel("Cantidad del ingrediente");
        texto2.setBounds(10, 70, 400, 20);
        JTextField Cantidad = new JTextField("");
        Cantidad.setBounds(10, 100, 200, 20);
        JLabel texto3 = new JLabel("Unidad de Medida e.j. Rebanadas, tazas, etc");
        texto3.setBounds(10, 130, 400, 20);
        JTextField UD = new JTextField("");
        UD.setBounds(10, 160, 200, 20);
        JButton submit = new JButton("Submit :)");
        submit.setBounds(10, 190, 120, 20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nueva_receta.add_ingred(Nombre.getText(), Cantidad.getText(), UD.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                funcion3(frame);
            }

        });
        frame.add(texto1);
        frame.add(Nombre);
        frame.add(texto2);
        frame.add(Cantidad);
        frame.add(texto3);
        frame.add(UD);
        frame.add(submit);

    }

    public static void funcion3(JFrame frame) {

        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel texto1 = new JLabel("Desea agregar mas ingredientes?");
        texto1.setBounds(10, 10, 400, 20);
        JButton BS = new JButton("si :)");
        BS.setBounds(10, 100, 80, 20);
        JButton BN = new JButton("no :)");
        BN.setBounds(120, 100, 80, 20);
        BS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcion2(frame);
            }

        });
        BN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcion4(frame);
            }

        });
        frame.add(texto1);
        frame.add(BS);
        frame.add(BN);

    }

    public static void funcion4(JFrame frame) {

        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel texto1 = new JLabel("Ahora se agregaran los pasos");
        texto1.setBounds(10, 10, 400, 20);
        JButton BS = new JButton("ok :)");
        BS.setBounds(10, 100, 80, 20);
        BS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcion5(frame);
            }

        });
        frame.add(texto1);
        frame.add(BS);

    }

    public static void funcion5(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel texto1 = new JLabel("Paso");
        texto1.setBounds(10, 10, 400, 20);
        JTextField Nombre = new JTextField("");
        Nombre.setBounds(10, 40, 200, 20);
        JButton submit = new JButton("Submit :)");
        submit.setBounds(10, 190, 120, 20);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nueva_receta.add_paso(Nombre.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                funcion6(frame);
            }

        });
        frame.add(texto1);
        frame.add(Nombre);
        frame.add(submit);

    }

    public static void funcion6(JFrame frame) {

        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel texto1 = new JLabel("Desea agregar mas pasos?");
        texto1.setBounds(10, 10, 400, 20);
        JButton BS = new JButton("si :)");
        BS.setBounds(10, 100, 80, 20);
        JButton BN = new JButton("no :)");
        BN.setBounds(120, 100, 80, 20);
        BS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcion5(frame);
            }

        });
        BN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nueva_receta.save_rec();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    funcion7(frame);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }

        });
        frame.add(texto1);
        frame.add(BS);
        frame.add(BN);

    }

    public static void funcion7(JFrame frame) throws FileNotFoundException {

        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel texto1 = new JLabel("Receta");
        texto1.setBounds(10, 10, 400, 20);
        JLabel texto2 = new JLabel(nueva_receta.printRec());
        texto2.setBounds(10, 40, 200, 200);
        frame.add(texto1);
        frame.add(texto2);

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // aquí ta el frame uwu
        JFrame MainFrame = new JFrame("RECETARIO :)");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setResizable(false);
        MainFrame.setSize(500, 500);
        MainFrame.setLayout(null);

        // System.out.println("Bienvenido al recetario, ingrese el nombre de la receta:
        // ");
        // ok so esta es la pagina de inicio y tiene lo que es el recetario y pide el
        // nombre de la receta
        JLabel Benvenuto = new JLabel("Bienvenido al recetario, ingrese el nombre de la receta");
        Benvenuto.setBounds(10, 10, 400, 20);
        JTextField Nombre = new JTextField("");
        Nombre.setBounds(10, 40, 200, 20);
        JButton Buscar = new JButton("Aceptar :)");
        Buscar.setBounds(10, 100, 120, 20);
        nueva_receta = new Receta(Nombre.getText());
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // aquí creo que tiene que ir el if pa buscar las recetas
                funcion1(MainFrame);
            }

        });

        String nombre = Nombre.getText(); // aquí quité el scanner y puse gettext para que el usuario ingrese el nombre
                                          // de la receta
        MainFrame.setVisible(true); // ya hay frame lesgooo

        MainFrame.add(Benvenuto);
        MainFrame.add(Nombre);
        MainFrame.add(Buscar);
    }

}
