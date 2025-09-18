package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class Principal {
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        Mago[] almacenMagos = new Mago[5];
        Monstruo[] almacenMonstruo = new Monstruo[5];
        String nombre;
        int vida;
        int nivelMagia;
        String hechizoFavorito;
        String tipo;
        int nivelPeligro;
        Monstruo monstruoJefe;
        int numMago=0;
        int numMonstruos=0;
        boolean continuar = true;

        System.out.println("Vamos a crear magos maximo 5");
        while (continuar && numMago<5) {
            System.out.println("nombre");
            nombre = sc.next();
            
            System.out.println("vida");
            vida = Math.abs(sc.nextInt());

            System.out.println("nivel magia");
            nivelMagia = Math.abs(sc.nextInt());

            System.out.println("hechizo favorito: adivinación, necromancia, piromancia e invocación");
            hechizoFavorito = sc.next();
            
            almacenMagos[numMago]=new Mago(nombre, vida, nivelMagia, hechizoFavorito);
            numMago++;

            System.out.println("Desea continuar escriba t");
            if ("t".contains(sc.next())){
                continuar=true;
            }
            else {
                continuar=false;
            }
        }   
        
        continuar=true;
        System.out.println("Vamos a crear monstruos maximo 5");
        while (continuar && numMonstruos<5) {
            System.out.println("nombre");
            nombre = sc.next();
            
            System.out.println("vida");
            vida = Math.abs(sc.nextInt());

            System.out.println("tipo");
            tipo = sc.next();

            
            
            almacenMonstruo[numMonstruos]=new Monstruo(nombre, vida, tipo);
            numMonstruos++;

            System.out.println("Desea continuar escriba t");
            if ("t".contains(sc.next())){
                continuar=true;
            }
            else {
                continuar=false;
            }
        }
        
        System.out.println("Vamos a crear el bosque");
        System.out.println("nombre");
        nombre=sc.next();

        System.out.println("nivel peligro");
        nivelPeligro=sc.nextInt();

        System.out.println("Indique el numero del jefe van del 0 al 4 en función de como lo has indicado");
        monstruoJefe=almacenMonstruo[sc.nextInt()];

        Bosque bosque = new Bosque(nombre, nivelPeligro, monstruoJefe);
        sc.close();

        while (almacenMagos[0].vida > 0 && bosque.monstruoJefe.vida>0) {
            System.out.println("Mago ataca");
            almacenMagos[0].atacar(bosque.monstruoJefe);
            System.out.println("Monstruo le queda "+bosque.monstruoJefe.vida);
            if (bosque.monstruoJefe.vida>0) {
                System.out.println("Monstruo ataca");
                bosque.monstruoJefe.atacar(almacenMagos[0]);
                System.out.println("Mago le queda "+almacenMagos[0]);
            }
        }
        if (almacenMagos[0].vida>0) {
            System.out.println("El mago ha ganado y domina el bosque");
        }
        else {
            System.out.println("El monstruo ha ganado y domina el bosque");
        }

        System.out.println("Personajes ordenados por vida");
        Personaje[] personajes = new Personaje[numMago+numMonstruos];
        for (int i=0; i<numMago; i++) {
            personajes[i]=almacenMagos[i];
        }
        for (int i=0; i<numMonstruos; i++) {
            personajes[i+numMago]=almacenMonstruo[i];
        }
        Arrays.sort(personajes, new VidaComparator());
        for (Personaje p: personajes) {
            System.out.println(p.nombre+" vida "+p.vida);
        }
    }
}

abstract class Personaje {
    String nombre;
    int vida;

    public abstract void atacar(Personaje nombre);
    public void recibir(int dano){
        this.vida=this.vida-dano;
    }
}

class Mago extends Personaje {
    enum Hechizos {adivinación, necromancia, piromancia, invocación}
    int nivelMagia;
    Hechizos hechizoFavorito;

    Mago(String nombre, int vida, int nivelMagia, String hechizoFavorito){
        this.nombre=nombre;
        this.vida=vida;
        this.nivelMagia=nivelMagia;
        try {
            this.hechizoFavorito=Hechizos.valueOf(hechizoFavorito);
        }
        catch (Exception e) {
            System.out.println("hechizo favorito invalido se autoasgina adivinación");
            this.hechizoFavorito=Hechizos.valueOf("adivinación");
        }
    }

    @Override
    public void atacar(Personaje nombre) {
        nombre.recibir(this.nivelMagia);
    }
    public void aprenderHechizo(String nuevoHechizo){
        try {
            this.hechizoFavorito=Hechizos.valueOf(nuevoHechizo);
        }
        catch (Exception e) {
            System.out.println("hechizo favorito invalido se autoasgina adivinación");
            this.hechizoFavorito=Hechizos.valueOf("adivinación");
        }
    }
}

class Monstruo extends Personaje {
    enum listaTipos {ogro, troll, espectro}
    listaTipos tipo;

    Monstruo(String nombre, int vida, String tipo){
        this.nombre=nombre;
        this.vida=vida;
        try {
            this.tipo=listaTipos.valueOf(tipo);
        }
        catch (Exception e) {
            System.out.println("tipo invalido se autoasigna ogro");
            this.tipo=listaTipos.valueOf("ogro");
        }
    }
    @Override
    public void atacar(Personaje nombre) {
        nombre.recibir(40);
    }
    
}

class Bosque {
    String nombre;
    int nivelPeligro;
    Monstruo monstruoJefe;

    Bosque(String nombre, int nivelPeligro, Monstruo monstruoJefe){
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruoJefe = monstruoJefe;
    }
    public void mostrarJefe(){
        System.out.println("Datos jefe:");
        System.out.println("Nombre: "+monstruoJefe.nombre);
        System.out.println("Vida: "+monstruoJefe.vida);
        System.out.println("Tipo: "+monstruoJefe.tipo);
    }
    public void cambiarJefe(Monstruo nuevoJefe){
        this.monstruoJefe=nuevoJefe;
    }
}

class VidaComparator implements Comparator<Personaje> {
    @Override
    public int compare(Personaje a, Personaje b) {
        return Integer.compare(a.vida, b.vida);
    }
}

