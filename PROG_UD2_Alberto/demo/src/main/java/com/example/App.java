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
        Scanner sc = new Scanner(System.in);
        int entrada=0;
        while (entrada !=4) {
            
            System.out.println("Bienvenido a la aplicación 2");
            System.out.println("1- Incremento al sueldo");
            System.out.println("2- Alumnado mayor de edad");
            System.out.println("3- Alumnado alto");
            System.out.println("4- Salir");

            entrada = sc.nextInt();
            switch (entrada) {
                case 1:
                    incrementoSueldo();
                    break;
                case 2:
                    mayorEdad();
                    break;

                case 3:
                    alumnadoAlto();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\n");
                    System.out.println("Introduzca un valor valido");
                    System.out.println("\n");
                    break;
            }
        }
    }

    public static void incrementoSueldo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un salario en decimal");
        double sueldo = sc.nextDouble();
        if (sueldo>1000.00) {
            sueldo=sueldo*1.12;
        }
        else {
            sueldo=sueldo*1.15;
        }
        System.out.println(sueldo);

    }
    public static void mayorEdad(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca 5 edades de 1 en 1");
        int [] edades = new int[5];

        for (int i = 0; i < 5;i++){
            edades[i] = sc.nextInt();
        }
        
        int mayores = 0;
        for (int i=0; i < 5;i++){
            if (edades[i] > 18) {
                mayores++;
            }
        }
        System.out.println(mayores);

    }
    public static void alumnadoAlto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca 5 alturas en m de 1 en 1 recuerde los decimales son con ,");
        double [] edades = new double[5];

        for (int i = 0; i < 5;i++){
            edades[i] = sc.nextDouble();
        }
        
        int altos = 0;
        for (int i=0; i < 5;i++){
            if (edades[i] > 1.75) {
                altos++;
            }
        }
        System.out.println(altos);
    }
}
