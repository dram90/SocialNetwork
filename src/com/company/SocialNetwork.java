package com.company;

import com.google.common.collect.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by professor on 04/07/2016.
 */
public class SocialNetwork {

    private Map<String, Person> peopleByName = new HashMap<>();
    private Map<Long, Person> peopleById = new HashMap<>();
    private BiMap<Person, Person> couples = HashBiMap.create();
    private Multimap<Person, Person> friends = ArrayListMultimap.create();

    public void addPerson(Person person){
        peopleByName.put(person.getName(),person);
        peopleById.put(person.getId(),person);
    }
    public Person getPerson(Long id){
        return peopleById.get(id);
    }

    public Person getPerson(String name){
        return peopleByName.get(name);
    }

    public void addCouple(Person p1,Person p2){


        //nos aseguramos que la persona no está en la lista de parejas. Si tiene paeja, no debe dejarnos añadir una

        /*

        if(couples.containsKey(p1)|| couples.values().contains(p1))
        {
            System.out.println("The person "+ p1.getName()+ "already has a couple");
            throw  new RuntimeException("The person " +p1.getName()+ "already has a couple"); //lanzar un error y parar la ejecución
        }

        if(couples.containsKey(p2)|| couples.values().contains(p2))
        {
            System.out.println("The person "+ p2.getName()+ "already has a couple");
            throw  new RuntimeException("The person " +p2.getName()+ "already has a couple"); //lanzar un error y parar la ejecución
        }
        */

        // El codigo anterior equivale al siguiente:

        checkIfPersonBelongsToACouple(p1);
        checkIfPersonBelongsToACouple(p2);
        couples.put(p1,p2);
    }

    private void checkIfPersonBelongsToACouple(Person p1) {
        if (couples.containsKey(p1) || couples.values().contains(p1)) {
            System.out.println("The person " + p1.getName() + " already has a couple");
            throw new RuntimeException("The person " + p1.getName() + " already has a couple"); //lanzar un error y parar la ejecución
        }
    }

    public Person getCouple(Person person){
        Person couple = couples.get(person);
        //búsqueda por key
        if(couple !=null)
        {return couple;}
        else
        {
            couple = couples.inverse().get(person);
            //búsqueda por value
            return couple;
        }
    }

    public void addFriendship(Person p1, Person p2) {

        friends.put(p1, p2);
    }

    public Set<Person> getFriends(Person person)//Set y no List para que no haya amigos duplicados
    {
        return null;
    }


    public Set<Person> getCouplesFriends (Person person){return null;}

    public Set<Person> getFriendsCouple (Person person){return null;}

    public Set<Person> popularity (Person person) {return null;}

    public int getConnectionDegree(Person p1, Person p2){return 0;}

    public SortedSet<Person> getConnectionDegreePath
            (Person p1,Person p2) {return null;}



}
