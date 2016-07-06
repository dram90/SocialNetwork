package com.company;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static SocialNetwork socialNetwork = new SocialNetwork();

    public static void main(String[] args) {

        initializeSocialNetwork();

        System.out.println("Query of person by Id:");
        System.out.println("Id 1: "+socialNetwork.getPerson(1L));

        System.out.println("Query of person by Name ");
        System.out.println("Name Cristina:"
                +socialNetwork.getPerson("Cristina"));
        System.out.println("Name Juan:"
                + socialNetwork.getPerson("Juan"));
        System.out.println("Name Ana:"
                + socialNetwork.getPerson("Ana"));
        System.out.println("Name Marc:"
                + socialNetwork.getPerson("Marc"));
        System.out.println("Name Antonio:"
                + socialNetwork.getPerson("Antonio"));
        System.out.println("Name Pedro:"
                + socialNetwork.getPerson("Pedro"));
        System.out.println("Name Pau:"
                + socialNetwork.getPerson("Pau"));


        Person cristina = new Person(1L, "Cristina", "Duran");
        Person juan = new Person(2L, "Juan", "Martínez");
        Person ana = new Person(3L, "Ana", "Gómez");
        Person marc = new Person(4L, "Marc", "Fuentes");
        Person antonio = new Person(5L, "Antonio", "Martínez");
        Person pedro = new Person(6L, "Pedro", "González");
        Person pau = new Person(7L, "Pau", "Claris");
        Person julia = new Person(8L, "Julia", "Domenech");
        Person carol = new Person(9L, "Carol", "Castillo");


        socialNetwork.addPerson(cristina);
        socialNetwork.addPerson(juan);
        socialNetwork.addPerson(ana);
        socialNetwork.addPerson(marc);
        socialNetwork.addPerson(antonio);
        socialNetwork.addPerson(pedro);
        socialNetwork.addPerson(pau);
        socialNetwork.addPerson(julia);
        socialNetwork.addPerson(carol);


        socialNetwork.addCouple(cristina, juan);
        socialNetwork.addCouple(ana, marc);
        socialNetwork.addCouple(antonio, pedro);

        /*socialNetwork.addCouple(cristina,pau);  throws an exception and finishes execution because cristina already has a couple
        boolean returns true because she is a key in the bimap of couples*/

        /*socialNetwork.addCouple(pau,cristina); throws an exception and finishes execution because cristina already has a couple
        boolean returns true because she is a value in the bimap of couples*/


        System.out.println("Cristina's couple is: " + socialNetwork.getCouple(cristina));
        System.out.println("Juan's couple is:  " + socialNetwork.getCouple(juan));
        System.out.println("Ana's couple is: " + socialNetwork.getCouple(ana));
        System.out.println("Marc's couple is: " + socialNetwork.getCouple(marc));
        System.out.println("Antonio's couple is: " + socialNetwork.getCouple(antonio));
        System.out.println("Pedro's couple is: " + socialNetwork.getCouple(pedro));
        System.out.println("Pau's couple is: " + socialNetwork.getCouple(pau));



    }

    private static void initializeSocialNetwork() {
        Person cristina = new Person(1L,"Cristina","Duran");
        Person juan = new Person(2L,"Juan","Martínez");
        Person ana = new Person(3L,"Ana","Gómez");
        Person marc = new Person(4L,"Marc","Fuentes");
        Person antonio = new Person(5L,"Antonio","Martínez");
        Person pedro = new Person(6L,"Pedro","González");
        Person pau = new Person(7L, "Pau","Claris");
        Person julia = new Person(8L, "Julia", "Domenech");
        Person carol = new Person(9L, "Carol", "Castillo");

        socialNetwork.addPerson(cristina);
        socialNetwork.addPerson(juan);
        socialNetwork.addPerson(ana);
        socialNetwork.addPerson(marc);
        socialNetwork.addPerson(antonio);
        socialNetwork.addPerson(pedro);
        socialNetwork.addPerson(pau);
        socialNetwork.addPerson(julia);
        socialNetwork.addPerson(carol);
    }


}
