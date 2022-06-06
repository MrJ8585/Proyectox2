package com.cetys.proyectox;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Receta{

    //variables
    String Name;
    boolean error = true;

    //scanner y files
    Scanner scn;
    File file;
    FileWriter write;

    //archivos
    public String pasos = "C:/Users/Josea/Desktop/Programas/Proyectos_de_Java/proyectox/src/main/java/com/cetys/proyectox/Storage/Pasos.txt";
    public String datos = "C:/Users/Josea/Desktop/Programas/Proyectos_de_Java/proyectox/src/main/java/com/cetys/proyectox/Storage/Ingredientes.txt";
    public String receta = "C:/Users/Josea/Desktop/Programas/Proyectos_de_Java/proyectox/src/main/java/com/cetys/proyectox/Storage/Receta.txt"; 

    //arraylists
    private ArrayList<Ingrediente> ingred = new ArrayList<>(); 
    public ArrayList<String> Pasos = new ArrayList<>();

    //constructor
    public Receta(String name) throws IOException, FileNotFoundException{
        this.Name = name;
        //checa si existe el archivo en la direccion de datos, y si no, crea uno
        file = new File(datos);
        File conF = new File(pasos);
        File recetA = new File(receta);
        if(!file.exists()){
            if(!file.createNewFile())
                System.out.println("El archivo no se pudo crear");
        }  
        if(!conF.exists()){
            if(!conF.createNewFile())
                System.out.println("El archivo no se pudo crear");
        }
        if(!recetA.exists()){
            if(!recetA.createNewFile())
                System.out.println("El archivo no se pudo crear");
        }
        while(error){
            scn = new Scanner(file);
            final Scanner scn2 = new Scanner(System.in);
            final Scanner scnC = new Scanner(conF);
            try{
                /*si en el archivo no esta vacio, el programa asumira que tiene datos guardados de usos anteriores
                por lo que preguntara si se quieren cargar esos archivos anteriores al arraylist de esta sesion
                si no quiere cargarlo, borrara la informacion del archivo */
                if(scn.hasNextLine()){
                    System.out.println("Hay datos guardados en el archivo\nDesea cargarlos en el programa?\n" +
                    "1.- Si\n2.- No");
                    int opc = scn2.nextInt();
                    if(opc == 1){ //if para cargar los datos y crear un nuevo ingrediente en el arraylist
                        System.out.println("Se cargaran los datos");
                        //se cargan ls datos de los ingredientes
                        for(int i=0; scn.hasNextLine(); i++){
                            ingred.add(new Ingrediente(scn.nextLine()));
                            ingred.get(i).set_cantidad(Double.valueOf(scn.nextLine()));
                            ingred.get(i).set_Unidad(scn.nextLine());
                        }
                        while(scnC.hasNextLine()){
                            Pasos.add(scnC.nextLine());
                        }
                    }else{//aqui borrara el contenido del archivo
                        System.out.println("No se cargaran los datos");
                        new FileOutputStream(datos).close();
                        new FileOutputStream(pasos).close();
                    }
                }error = !error;// para salir del while
            }catch(Exception e){
                System.out.println(e);
                System.out.println("Se debe ingresar un numero");
                scn2.close();
                scnC.close();
            }scn.close();
        }error = true;
        new FileOutputStream(receta).close(); //se borra el contenido del archivo receta
    }
    //--------------------------------------------------------------------------------------//

    //agregar ingredient al arraylist
    final public void add_ingred() throws IOException, FileNotFoundException{
        while(error){
            try{
                scn = new Scanner(System.in);
                System.out.println("Que ingrediente quiere agregar?: ");
                ingred.add(new Ingrediente(scn.nextLine()));
                System.out.println("Que cantidad se le debe agregar a la receta?: ");
                ingred.get(ingred.size()-1).set_cantidad(scn.nextDouble());
                System.out.println("Ingrese la unidad de medida del ingrediente: ");
                ingred.get(ingred.size()-1).set_Unidad(scn.next());
                error = !error;
            }catch(Exception e){
                System.out.println("se debe agregar un numero");
            }
        }error = true;
        /*aqui es para confirmar que todo lo ingresado esta correcto, en caso de que lo este, guardara el ingrediente
        en el arraylist, en caso contrario, preguntara que es lo que se quiere cambiar*/
        System.out.println("Esta correcta toda la informacion?\n1.- Si\n2.- No");
        print_ingrediente();//imprime el ingrediente
        int opc = 3;
        while(!(opc < 3 && opc > 0)){
            try{
                opc = new Scanner(System.in).nextInt();
            }catch(Exception e){
                System.out.println("se debe agregar un numero");
            }
        }
        if(opc == 2) //en caso de que no se quiera 
            mod_Ingred();//funcion para modificar el ingrediente
        save_Ingred(ingred.get(ingred.size()-1));//salva el ingrediente en el arraylist
    }

    //--------------------------------------------------------------------------------------//

    //Guarda el ingrediente en el archivo
    public void save_Ingred(Ingrediente ingred) throws IOException, FileNotFoundException{
        file = new File(datos);
        if(check_file()){//aqui es la funcion en la que se guarda el ingrediente, escribiendo el nombre, cantidad y medida
            scn = new Scanner(file);
            write = new FileWriter(file, true);
            write.write(String.valueOf(ingred.get_Nombre() + "\n" + ingred.get_cantidad()) +  "\n" +
            ingred.get_unidad() + "\n");
            write.close();
        }else System.out.println("Hubo un error");
    }

    //--------------------------------------------------------------------------------------//

    //imprimir ingrediente
    final public void print_Ingred(){
        System.out.println("Ingredientes: ");
        for(int i=0; i<ingred.size(); i++)
            System.out.println("\n" + (i + 1) + ".- " + ingred.get(i).get_cantidad() + " " +
                ingred.get(i).get_unidad() + " de " +  ingred.get(i).get_Nombre());
    }

    //--------------------------------------------------------------------------------------//
    //imprime el ultimo ingrediente, es usado solo para imprimir el ultimo elemento de la lista
    final private void print_ingrediente(){ 
        int i = ingred.size()-1;
        System.out.println("\n" + (i + 1) + ".- " + ingred.get(i).get_cantidad() + " " +
                ingred.get(i).get_unidad() + " de " +  ingred.get(i).get_Nombre());
    }

    //--------------------------------------------------------------------------------------//

    //modificar ingrediente
    final private void mod_Ingred(){
        while(error){
            Scanner scn2 = new Scanner(System.in);
            try{
                int opc = 5;
                while(!(opc < 5 && opc > 0)){
                    System.out.println("Ingrese la opcion de lo que le gustaria modificar\n" + 
                    "1.- El nombre\n2.- La cantidad\n3.- La unidad de medida\n4.- Salir");
                    opc = scn.nextInt();
                }if(opc != 4){
                    System.out.println("Ingrese el valor por el que lo quiere cambiar: ");
                    //dependiendoo del numero ingresado, es el atributo del ingrediente que se va a modificar
                    //1 el nombre, 2 la cantidad y 3 el la unidad de medida
                    switch(opc){
                        case 1:
                            ingred.get(ingred.size()-1).set_Nombre(scn2.nextLine()); break;
                        case 2:
                            ingred.get(ingred.size()-1).set_cantidad(scn2.nextDouble()); break;
                        case 3:
                            ingred.get(ingred.size()-1).set_Unidad(scn2.nextLine()); break;
                    }
                }
            }catch(Exception e){
                System.out.println("Se debe agregar un numero");
                scn2.close();
            }error = !error;
        }
        
    }

    //--------------------------------------------------------------------------------------//    


    //checa si el archivo existe o no, y en caso de que no exista, lo crea
    public boolean check_file() throws IOException, FileNotFoundException{
        file = new File(datos);
        if(!file.exists()){
            if(!file.createNewFile()){
                System.out.println("El archivo no se pudo crear");
                return false;
            }
        }return true;
    }

    //--------------------------------------------------------------------------------------------------//
    //TERMINA PARTE DE INGREDIENTES Y EMPIEZA PARTE DE PASOS
    final public void add_paso() throws IOException, FileNotFoundException{
        String paso = "";
        while(error){
            scn = new Scanner(System.in);
            System.out.println("Ingrese el paso: ");
            paso = scn.nextLine();
            Pasos.add(paso);
            error = !error;
        }error = true;
        save_Paso(paso);//salva el ingrediente en el arraylist
    }

    public void save_Paso(String paso) throws IOException, FileNotFoundException{
        File pasO = new File(pasos);
        if(pasO.exists()){
            scn = new Scanner(pasO);
            write = new FileWriter(pasO, true);
            write.write(paso + "\n");
            write.close();
        }else System.out.println("Hubo un error");
    }

    public void save_rec() throws IOException, FileNotFoundException{
        File recetA = new File(receta);
        write = new FileWriter(recetA, true);
        for(int i=0; i<ingred.size(); i++){
            write.write(String.valueOf(ingred.get(i).get_Nombre() + "\n" + ingred.get(i).get_cantidad()) +
            "\n" +ingred.get(i).get_unidad() + "\n");
        }
        for(int i=0; i<Pasos.size(); i++){
            write.write(Pasos.get(i) + "\n");
        }
        write.close();
    }
}

/* son las 3:30 de la mañana, tengo sueño y media botella de tequila en mi organismo, no se ni como
salio este program, pero salio */