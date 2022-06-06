package com.cetys.proyectox;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        MainFrame.setSize(700, 700);

        Scanner scn = new Scanner(System.in);

        System.out.println("Bienvenido al recetario, ingrese el nombre de la receta: ");
        String nombre = scn.nextLine();
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
    }

}
