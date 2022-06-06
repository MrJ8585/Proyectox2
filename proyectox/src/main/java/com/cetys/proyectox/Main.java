package com.cetys.proyectox;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scn = new Scanner(System.in);

        System.out.println("Bienvenido al recetario, ingrese el nombre de la receta: ");
        String nombre = scn.nextLine();
        Receta nueva_Rec = new Receta(nombre);
        int dec = 1;
        System.out.println("Ahora se agregaran los ingredientes");
        while(dec == 1){
            nueva_Rec.add_ingred();
            System.out.println("Desea agregar otro ingrediente?\n1.- Si\n2.- No");
            dec = scn.nextInt();
        }dec = 1;
        System.out.println("Ahora se agregaran los pasos de preparacion");
        while(dec == 1){
            nueva_Rec.add_paso();
            System.out.println("Desea agregar otro paso?\n1.- Si\n2.- No");
            dec = scn.nextInt();
        }
        nueva_Rec.save_rec();
        scn.close();
    }
    
}
