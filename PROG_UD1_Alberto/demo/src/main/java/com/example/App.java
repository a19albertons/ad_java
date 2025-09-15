package com.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Guarda la variable que maneja nuestro escaner de teclado
        Scanner sc = new Scanner(System.in);

        // Primer metodo requerido que usa el escaner uno debe usar la , en lugar de . cosas del utf-8
        System.out.println("Ejecución metodo 2");
        metodo2(sc.nextDouble(), sc.nextDouble());

        // Segundo metodo requerido que usa 2 literales para pasar valores
        System.out.println("\n");
        System.out.println("Ejecución metodo 3");
        System.out.println(metodo3("texto",'x'));

        // Creamos las 2 variables del metodo 4
        // La primera es 1
        double var1_metodo4 = 1.00;
        // La segunda es 1
        double var2_metodo4 = 2.00;
        // Invocamos el metodo con la variable
        System.out.println("\n");
        System.out.println("Ejecución metodo 4");
        metodo4(var1_metodo4,var2_metodo4);

    }
    public static int metodo2(double val1, double val2) {
        int val_int1 = ((int)val1);
        int val_int2 = ((int)val2);
        return val_int1 % val_int2;
    }
    public static boolean metodo3(String cadena, Character caracter) {
        boolean devolver = false;
        for (int i=0; i<cadena.length(); i++){
            if (cadena.charAt(i)==caracter) {
                devolver = true;
                break;
            }
        }
        return devolver;
    }
    public static void metodo4(double val1, double val2){
        float flotante = ((float)(val1+val2));
        System.out.println(flotante);
        System.out.println(((int)flotante));
        System.out.println(flotante-(int)flotante);
    }
}
