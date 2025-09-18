package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Hello world!
 *
 */
public class Principal 
{
    public static void main( String[] args )
    {
        vehiculoCoche[] flotaVehiculos = new vehiculoCoche[3];
        flotaVehiculos[0]= new vehiculoCoche("1234ABC", 4, 2020, 5);
        flotaVehiculos[1]= new vehiculoCoche("5678DEF", 4, 2019, 3);
        flotaVehiculos[2]= new vehiculoCoche("1234ABC", 4, 2020, 5);


        if (flotaVehiculos[0].equals(flotaVehiculos[2])){
            System.out.println("El coche0 y coche2 están repetidos");
        }
        else {
            System.out.println("Coche0 y coche2 son diferentes");
        }
        if (flotaVehiculos[0].compareTo(flotaVehiculos[2])==1){
            System.out.println("El coche0 tiene más puertas que el coche");
        }
        else if (flotaVehiculos[0].compareTo(flotaVehiculos[2])==0) {
            System.out.println("El coche0 tiene las mismas puertas que el coche2");
        }
        else{
            System.out.println("El coche0 tiene menos puertas que el coche2");
        }

        Arrays.sort(flotaVehiculos);
        for (int i = 0; i<flotaVehiculos.length;i++){
            System.out.println(flotaVehiculos[i].toString());
        }
    }
}

interface vehiculo {
    String getMatricula();
    int getRuedas();
    int getAnoFabricacion();

    
}

interface coche{
    int getNumPuertas();

    int compareTo(vehiculoCoche otro);

    @Override
    boolean equals(Object obj);
    
}
class vehiculoCoche implements vehiculo,coche, Comparable<vehiculoCoche> {
    String Matricula;
    int Ruedas;
    int AnoFabricacion;
    int NumPuertas;

    public vehiculoCoche(String matricula, int ruedas, int anoFabricacion, int numPuertas) {
        this.Matricula = matricula;
        this.Ruedas = ruedas;
        this.AnoFabricacion = anoFabricacion;
        this.NumPuertas = numPuertas;
    }

    @Override
    public String getMatricula() {
        return this.Matricula;
    }

    @Override
    public int getRuedas() {
        return this.Ruedas;
    }

    @Override
    public int getAnoFabricacion() {
        return this.AnoFabricacion;
    }

    @Override
    public int getNumPuertas() {
        return this.NumPuertas;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        vehiculoCoche other = (vehiculoCoche) obj;
        return Matricula.equals(other.Matricula) && Ruedas == other.Ruedas &&
               AnoFabricacion == other.AnoFabricacion && NumPuertas == other.NumPuertas;
    }

    @Override
    public int compareTo(vehiculoCoche otro){
        int devolver;
        if (this.NumPuertas>otro.NumPuertas) {
            devolver=1;
        }
        else if (this.NumPuertas==otro.NumPuertas) {
            devolver=0;
        }
        else{
            devolver=-1;
        }
        return devolver;
    }

    @Override
    public String toString() {
        return "vehiculoCoche [Matricula=" + Matricula + ", Ruedas=" + Ruedas + ", AnoFabricacion=" + AnoFabricacion
                + ", NumPuertas=" + NumPuertas + "]";
    }
    
}

class ComparaMatricula implements Comparator<vehiculo>{
    @Override
    public int compare(vehiculo arg0, vehiculo arg1) {
        // 1111AAA
        int devolver = 0;
        vehiculoCoche coche1=(vehiculoCoche)arg0;
        vehiculoCoche coche2=(vehiculoCoche)arg1;
        String Matricula1=coche1.getMatricula().toUpperCase();
        String Matricula2=coche2.getMatricula().toUpperCase();
        for (int i = 0;i<7;i++) {
            if (Matricula1.charAt(i) > Matricula2.charAt(i)) {
                devolver = 1;
                break;
            }
            if (Matricula2.charAt(i) > Matricula2.charAt(i)) {
                devolver = -1;
                break;
            }
        }
        return devolver;
    }
}