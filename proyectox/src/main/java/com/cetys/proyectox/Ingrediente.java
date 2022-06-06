package com.cetys.proyectox;

public class Ingrediente{

    private String Nombre, Unidad_medida;
    private double Cantidad;
    
    public Ingrediente(String nombre){
        this.Nombre = nombre;
    }

    public void set_cantidad(double cantidad){
        this.Cantidad = cantidad;
    }

    public double get_cantidad(){
        return Cantidad;
    }

    public void set_Unidad(String Unidad){
        this.Unidad_medida = Unidad;
    }

    public String get_unidad(){
        return Unidad_medida;
    }

    public String get_Nombre(){
        return Nombre;
    }

    public void set_Nombre(String nombre){
        this.Nombre = nombre;
    }


}
