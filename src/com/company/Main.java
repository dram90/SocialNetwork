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

    }

    private static void initializeSocialNetwork() {
        Person cristina = new Person(1L,"Cristina","Duran");
        Person juan = new Person(2L,"Juan","Martínez");
        Person ana = new Person(3L,"Ana","Gómez");
        Person marc = new Person(4L,"Marc","Fuentes");
        Person antonio = new Person(5L,"Antonio","Martínez");
        Person pedro = new Person(6L,"Pedro","González");
        Person pau = new Person(7L, "Pau","Claris");


        socialNetwork.addPerson(cristina);
        socialNetwork.addPerson(juan);
        socialNetwork.addPerson(ana);
        socialNetwork.addPerson(marc);
        socialNetwork.addPerson(antonio);
        socialNetwork.addPerson(pedro);
        socialNetwork.addPerson(pau);
    }


}
