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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // aquí ta el frame uwu
        JFrame MainFrame = new JFrame("RECETARIO :)");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setResizable(false);
        MainFrame.setSize(500, 500);
        MainFrame.setLayout(null);

        Scanner scn = new Scanner(System.in);

        // System.out.println("Bienvenido al recetario, ingrese el nombre de la receta:
        // ");
        // ok so esta es la pagina de inicio y tiene lo que es el recetario y pide el
        // nombre de la receta
        JLabel Benvenuto = new JLabel("Bienvenido al recetario, ingrese el nombre de la receta");
        Benvenuto.setBounds(10, 10, 300, 20);
        JTextField Nombre = new JTextField("Receta");
        Nombre.setBounds(10, 40, 200, 20);
        JButton Buscar = new JButton("Aceptar :)");
        Buscar.setBounds(10, 100, 80, 20);
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // aquí creo que tiene que ir el if pa buscar las recetas

            }

        });

        String nombre = Nombre.getText(); // aquí quité el scanner y puse gettext para que el usuario ingrese el nombre
                                          // de la receta
        Receta nueva_Rec = new Receta(nombre);
        int dec = 1;
        System.out.println("Ahora se agregaran los ingredientes");
        while (dec == 1) {
            nueva_Rec.add_ingred();
            System.out.println("Desea agregar otro ingrediente?\n1.- Si\n2.- No");
            dec = scn.nextInt();
        }
        dec = 1;
        System.out.println("Ahora se agregaran los pasos de preparacion");
        while (dec == 1) {
            nueva_Rec.add_paso();
            System.out.println("Desea agregar otro paso?\n1.- Si\n2.- No");
            dec = scn.nextInt();
        }
        nueva_Rec.save_rec();
        scn.close();

        MainFrame.setVisible(true); // ya hay frame lesgooo

        MainFrame.add(Benvenuto);
        MainFrame.add(Nombre);
        MainFrame.add(Buscar);
    }

}
