package com.cetys.proyectox;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Receta {

    // variables
    String Name;
    boolean error = true;

    // scanner y files
    Scanner scn;
    File file;
    FileWriter write;

    // archivos
    public String pasos = "C:/Users/Josea/Desktop/Programas/Proyectos_de_Java/proyectox/src/main/java/com/cetys/proyectox/Storage/Pasos.txt";
    public String datos = "C:/Users/Josea/Desktop/Programas/Proyectos_de_Java/proyectox/src/main/java/com/cetys/proyectox/Storage/Ingredientes.txt";
    public String receta = "C:/Users/Josea/Desktop/Programas/Proyectos_de_Java/proyectox/src/main/java/com/cetys/proyectox/Storage/Receta.txt";

    // arraylists
    private ArrayList<Ingrediente> ingred = new ArrayList<>();
    public ArrayList<String> Pasos = new ArrayList<>();

    // nuevas variables
    public boolean flag = false;

    // constructor
    public Receta(String name) throws IOException, FileNotFoundException {
        this.Name = name;
        // checa si existe el archivo en la direccion de datos, y si no, crea uno
        file = new File(datos);
        File conF = new File(pasos);
        File recetA = new File(receta);
        if (!file.exists()) {
            if (!file.createNewFile())
                System.out.println("El archivo no se pudo crear");
        }
        if (!conF.exists()) {
            if (!conF.createNewFile())
                System.out.println("El archivo no se pudo crear");
        }
        if (!recetA.exists()) {
            if (!recetA.createNewFile())
                System.out.println("El archivo no se pudo crear");
        }
        new FileOutputStream(datos).close();
        new FileOutputStream(pasos).close();
        new FileOutputStream(receta).close();

    }

    // --------------------------------------------------------------------------------------//

    // agregar ingredient al arraylist
    final public void add_ingred(String i, String c, String u) throws IOException, FileNotFoundException {
        ingred.add(new Ingrediente(i));
        ingred.get(ingred.size() - 1).set_cantidad(c);
        ingred.get(ingred.size() - 1).set_Unidad(u);
        save_Ingred(ingred.get(ingred.size() - 1));// salva el ingrediente en el arraylist
    }

    // --------------------------------------------------------------------------------------//

    // Guarda el ingrediente en el archivo
    public void save_Ingred(Ingrediente ingred) throws IOException, FileNotFoundException {
        file = new File(datos);
        if (check_file()) {// aqui es la funcion en la que se guarda el ingrediente, escribiendo el nombre,
                           // cantidad y medida
            scn = new Scanner(file);
            write = new FileWriter(file, true);
            write.write(String.valueOf(ingred.get_Nombre() + "\n" + ingred.get_cantidad()) + "\n" +
                    ingred.get_unidad() + "\n");
            write.close();
        } else
            System.out.println("Hubo un error");
    }

    // --------------------------------------------------------------------------------------//

    // checa si el archivo existe o no, y en caso de que no exista, lo crea
    public boolean check_file() throws IOException, FileNotFoundException {
        file = new File(datos);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                System.out.println("El archivo no se pudo crear");
                return false;
            }
        }
        return true;
    }

    // --------------------------------------------------------------------------------------------------//
    // TERMINA PARTE DE INGREDIENTES Y EMPIEZA PARTE DE PASOS
    final public void add_paso(String p) throws IOException, FileNotFoundException {
        Pasos.add(p);
        save_Paso(p);// salva el ingrediente en el arraylist
    }

    public void save_Paso(String paso) throws IOException, FileNotFoundException {
        File pasO = new File(pasos);
        if (pasO.exists()) {
            scn = new Scanner(pasO);
            write = new FileWriter(pasO, true);
            write.write(paso + "\n");
            write.close();
        } else
            System.out.println("Hubo un error");
    }

    public void save_rec() throws IOException, FileNotFoundException {
        File recetA = new File(receta);
        write = new FileWriter(recetA, true);
        for (int i = 0; i < ingred.size(); i++) {
            write.write(String.valueOf(ingred.get(i).get_Nombre() + "\n" + ingred.get(i).get_cantidad()) +
                    "\n" + ingred.get(i).get_unidad() + "\n");
        }
        for (int i = 0; i < Pasos.size(); i++) {
            write.write(Pasos.get(i) + "\n");
        }
        write.close();
    }

    public String printRec() throws FileNotFoundException {
        String a = "";
        file = new File(receta);
        scn = new Scanner(file);
        while (scn.hasNextLine()) {
            a = a + (scn.nextLine()) + "\n";
        }
        return a;
    }
}

/*
 * Para este proyecto no he dormido
 * de alguna forma u otra siempre me malpaso haciendo todo de ultimo momento
 */