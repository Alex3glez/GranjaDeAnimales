/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granja;

import animales.Animal;
import animales.Gato;
import animales.Perro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Animal> miGranja = new ArrayList();
        Iterator iterador;

        String codigoAnimal;
        String fechaNacimientoAnimal;
        char sexoAnimal;
        double pesoAnimal;
        String raza;
        String tipoAnimal;

        int numAnimales;
        Animal animal;
        Perro perro;
        Gato gato;

        System.out.println("Procesando animales de la granja");
        System.out.println("----------------------------------");
        numAnimales = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= numAnimales; i++) {

            tipoAnimal = sc.nextLine();

            codigoAnimal = sc.nextLine();
            fechaNacimientoAnimal = sc.nextLine();
            sexoAnimal = sc.nextLine().charAt(0);
            pesoAnimal = sc.nextDouble();
            sc.nextLine();

            if (tipoAnimal.equals("perro")) {
                raza = sc.nextLine();
                try {
                    perro = new Perro(codigoAnimal, fechaNacimientoAnimal, sexoAnimal, pesoAnimal, raza);
                    miGranja.add(perro);
                } catch (IllegalArgumentException ex) {
                    System.out.println("ERROR procesando perro. Datos incorrectos. Procesando siguiente animal");
                }
            } else if (tipoAnimal.equals("gato")) {
                raza = sc.nextLine();
                try {
                    gato = new Gato(codigoAnimal, fechaNacimientoAnimal, sexoAnimal, pesoAnimal, raza);
                    miGranja.add(gato);
                } catch (IllegalArgumentException ex) {
                    System.out.println("ERROR procesando gato. Datos incorrectos. Procesando siguiente animal");
                }
            }
        }

        iterador = miGranja.iterator();
        while (iterador.hasNext()) {
            System.out.println();
            animal = (Animal) iterador.next();
            System.out.println(animal.toString());
            System.out.println(animal.queSoy());
            System.out.println("Hago " + animal.hacerSonido());
            System.out.println("Cuando estoy alegre " + animal.alegrarse());
            System.out.println("Cuando me enfado " + animal.enfadarse());
        }
        miGranja.clear();
    }
}
