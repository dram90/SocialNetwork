package com.company;

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
                +socialNetwork.getPerson("Juan"));
        System.out.println("Name Ana:"
                +socialNetwork.getPerson("Ana"));
        System.out.println("Name Marc:"
                +socialNetwork.getPerson("Marc"));
        System.out.println("Name Antonio:"
                +socialNetwork.getPerson("Antonio"));
        System.out.println("Name Pedro:"
                +socialNetwork.getPerson("Pedro"));
        System.out.println("Name Pau:"
                +socialNetwork.getPerson("Pau"));


        Person cristina = new Person(1L,"Cristina","Duran");
        Person juan = new Person(2L,"Juan","Martínez");
        Person ana = new Person(3L,"Ana","Gómez");
        Person marc = new Person(4L,"Marc","Fuentes");
        Person antonio = new Person(5L,"Antonio","Martínez");
        Person pedro = new Person(6L,"Pedro","González");
        Person pau = new Person(7L, "Pau","Claris");
        Person julia = new Person(8L,"Julia","Domenech");
        Person carol = new Person(9L,"Carol","Castillo");
        Person luis = new Person(10L,"Luis", "Hernandez");



        socialNetwork.addPerson(cristina);
        socialNetwork.addPerson(juan);
        socialNetwork.addPerson(ana);
        socialNetwork.addPerson(marc);
        socialNetwork.addPerson(antonio);
        socialNetwork.addPerson(pedro);
        socialNetwork.addPerson(pau);
        socialNetwork.addPerson(julia);
        socialNetwork.addPerson(carol);
        socialNetwork.addPerson(luis);


        socialNetwork.addCouple(cristina,juan);
        socialNetwork.addCouple(ana,marc);
        socialNetwork.addCouple(antonio,pedro);

        /*socialNetwork.addCouple(cristina,pau); Trying code. Throws an exception and finishes execution because cristina already has a couple
        boolean returns true because she is a key in the bimap of couples*/

        /*socialNetwork.addCouple(pau,cristina); Trying code.Throws an exception and finishes execution because cristina already has a couple
        boolean returns true because she is a value in the bimap of couples*/


        System.out.println("Cristina's couple is: "+socialNetwork.getCouple(cristina));
        System.out.println("Juan's couple is:  "+socialNetwork.getCouple(juan));
        System.out.println("Ana's couple is: "+socialNetwork.getCouple(ana));
        System.out.println("Marc's couple is: "+ socialNetwork.getCouple(marc));
        System.out.println("Antonio's couple is: "+socialNetwork.getCouple(antonio));
        System.out.println("Pedro's couple is: "+socialNetwork.getCouple(pedro));
        System.out.println("Pau's couple is: "+socialNetwork.getCouple(pau));


        socialNetwork.addFriendship(juan,carol,marc);// adding more than one pers at a time
        socialNetwork.addFriendship(juan,antonio);
        socialNetwork.addFriendship(antonio,pedro,cristina,carol);
        socialNetwork.addFriendship(carol,ana,julia);
        socialNetwork.addFriendship(julia,luis);

        /* socialNetwork.addFriendship(marc,antonio); trying code .Throws an exception because they are already friends*/


        System.out.println("Cristina's friends are: " +socialNetwork.getFriends(cristina));
        System.out.println("Juan's friends are: " +socialNetwork.getFriends(juan));
        System.out.println("Ana's friends are: " +socialNetwork.getFriends(ana));
        System.out.println("Marc's friends are: " +socialNetwork.getFriends(marc));
        System.out.println("Antonio's friends are: " +socialNetwork.getFriends(antonio));
        System.out.println("Pedro's friends are: " +socialNetwork.getFriends(pedro));
        System.out.println("Julia's friends are: "+socialNetwork.getFriends(julia));
        System.out.println("Carol's friends are: " +socialNetwork.getFriends(carol));
        System.out.println("Pau's friends are: " +socialNetwork.getFriends(pau));


        System.out.println("The friends of Cristina's couple are: "+socialNetwork.getCouplesFriends(cristina));

        System.out.println("The couples of Cristina's friends are:" + socialNetwork.getFriendsCouple(cristina));

        System.out.println("Number of friends of antonio: " +socialNetwork.getNumberOfFriends(antonio));
        System.out.println("Number of friends of marc: " +socialNetwork.getNumberOfFriends(marc));


        System.out.println("Popularity" +socialNetwork.popularity());


        System.out.println("The connection degree between Juan and Pau is " + socialNetwork.existsConnection(juan,pau));
       System.out.println("The connection degree between Juan and Antonio is " + socialNetwork.existsConnection(juan,antonio));
        System.out.println("The connection degree between Juan and Cristina is " + socialNetwork.existsConnection(juan,cristina));
        System.out.println("The connection degree between Juan & Luis is "+ socialNetwork.existsConnection(juan,luis));


    }

    private static void initializeSocialNetwork() {
        Person cristina = new Person(1L,"Cristina","Duran");
        Person juan = new Person(2L,"Juan","Martínez");
        Person ana = new Person(3L,"Ana","Gómez");
        Person marc = new Person(4L,"Marc","Fuentes");
        Person antonio = new Person(5L,"Antonio","Martínez");
        Person pedro = new Person(6L,"Pedro","González");
        Person pau = new Person(7L, "Pau","Claris");
        Person julia = new Person(8L,"Julia","Domenech");
        Person carol = new Person(9L,"Carol","Castillo");

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
