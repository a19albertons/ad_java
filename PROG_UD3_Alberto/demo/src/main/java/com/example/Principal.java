package com.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Principal 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        Mago Mago1=new Mago(sc.next(),sc.nextInt(),sc.nextInt(),sc.next());
        Bosque Bosque= new Bosque(sc.next(), sc.nextInt(), new Monstruo(sc.next(), sc.nextInt(), sc.next(), sc.nextInt()));

        while (Mago1.vida>0 && Bosque.monstruoJefe.vida>0) {
            Mago1.lanzarHechizo(Bosque.monstruoJefe);
            if (Bosque.monstruoJefe.vida<=0) {
                System.out.println("Mago gana y es dueño del bosque");
                break;
            }
            Bosque.monstruoJefe.atacar(Mago1);
            if (Mago1.vida<=0) {
                System.out.println("Gana el monstruo y es dueño del bosque");
                break;
            }
        }
    }
}


class Mago {
    enum Hechizos {adivinación, necromancia, piromancia, invocacion,}
    String nome;
    int vida;
    int nivelMagia;
    Hechizos hechizoFavorito;

    Mago(String nome, int vida, int nivelMagia, String hechizoFavorito){
        this.nome =nome;
        this.vida= Math.abs(vida);
        this.nivelMagia=Math.abs(nivelMagia);
        if (Hechizos.valueOf(hechizoFavorito) != null) {
            this.hechizoFavorito=Hechizos.valueOf(hechizoFavorito);
        }
        else {
            System.out.println("hechizo favorito invalido se autoasgina adivinación");
            this.hechizoFavorito=Hechizos.valueOf("adivinación");
        }
    }

    public void  lanzarHechizo(Monstruo quitarVida){
        quitarVida.recibirDaño(nivelMagia);
    }
    public void aprenderHechizo(String nuevoHechizo){
        if (Hechizos.valueOf(nuevoHechizo) != null) {
            this.hechizoFavorito=Hechizos.valueOf(nuevoHechizo);
        }
        else {
            System.out.println("hechizo favorito invalido se autoasgina adivinación");
            this.hechizoFavorito=Hechizos.valueOf("adivinación");
        }
    }
}

class Monstruo {
    enum listaTipo {ogro, troll, espectro}
    String nombre;
    int vida;
    listaTipo tipo;
    int fuerza;

    public Monstruo(String nombre, int vida, String tipo, int fuerza) {
        this.nombre = nombre;
        this.vida = vida;
        if (listaTipo.valueOf(tipo) != null) {
            this.tipo=listaTipo.valueOf(tipo);
        }
        else {
            System.out.println("tipo invalido se autoasigna ogro");
            this.tipo=listaTipo.valueOf("ogro");
        }
        this.fuerza = fuerza;
    }

    public void atacar(Mago mago){
        mago.vida=mago.vida-fuerza;
    }
    public void recibirDaño(int vida){
        this.vida=this.vida-vida;
    }
}


class Bosque {
    String nombre;
    int nivelPeligro ;
    Monstruo monstruoJefe;

    public Bosque(String nombre, int nivelPeligro, Monstruo monstruo){
        this.nombre=nombre;
        this.nivelPeligro=nivelPeligro;
        this.monstruoJefe=monstruo;
    }

    public void mostrarJefe(){
        System.out.println("Datos jefe:");
        System.out.println("Nombre: "+monstruoJefe.nombre);
        System.out.println("Vida: "+monstruoJefe.vida);
        System.out.println("Tipo: "+monstruoJefe.tipo);
        System.out.println("fuerza:"+monstruoJefe.fuerza);
    }
    public void cambiarJefe(Monstruo nuevoJefe){
        this.monstruoJefe=nuevoJefe;
    }
}