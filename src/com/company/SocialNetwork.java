package com.company;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

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
        couples.put(p1,p2);
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

    public void addFriendship(Person p1, Person p2){}

    public Set<Person> getFriends(Person person){return null;}
        //Set y no List para que no haya amigos duplicados

    public Set<Person> getCouplesFriends (Person person){return null;}

    public Set<Person> getFriendsCouple (Person person){return null;}

    public Set<Person> popularity (Person person) {return null;}

    public int getConnectionDegree(Person p1, Person p2){return 0;}

    public SortedSet<Person> getConnectionDegreePath
            (Person p1,Person p2) {return null;}



}
