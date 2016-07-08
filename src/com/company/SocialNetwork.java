package com.company;

import com.google.common.collect.*;

import java.util.*;

/**
 * Created by professor on 04/07/2016.
 */
public class SocialNetwork {

    private Map<String, Person> peopleByName = new HashMap<>();
    private Map<Long, Person> peopleById = new HashMap<>();
    private BiMap<Person, Person> couples = HashBiMap.create();
    private TreeMultimap<Person,Person> friendships = TreeMultimap.create();
    private HashSet<Person> friendsVisited = new HashSet<>();



        //API PÚBLICO

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
        if(couples.containsKey(p1)|| couples.values().contains(p1))
        {
            System.out.println("The person "+ p1.getName()+ " already has a couple");
            throw  new RuntimeException("The person " +p1.getName()+ " already has a couple"); //lanzar un error y parar la ejecución
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


    public void addFriendship (Person p1, Person p2)
    {
        checkFriendship(p1, p2);

        friendships.put(p1,p2);
        friendships.put (p2, p1);
    }


    private void checkFriendship(Person p1, Person p2) {
        if (friendships.containsKey(p1)
                && friendships.get(p1).contains(p2)){
            System.out.println(p2.getName()+ " is already a friend of " +p2.getName());
            throw new RuntimeException(p2.getName()+ " is already a friend of " +p1.getName());
        }
    }

    public void addFriendship (Person p1, Person... friends){

        for (Person friend: friends)
        {
            addFriendship(p1,friend);
        }
    }


    public Set<Person> getFriends(Person person)//Set y no List para que no haya amigos duplicados
    {

        Set<Person> friends = friendships.get(person);
        if (friends!=null) //por si no tiene amigos.
        {
            return friends;
        }
        else
            return new TreeSet<>();
    }


    public Set<Person> getCouplesFriends (Person person){


        Person couple = getCouple(person);
        if (couple==null)
        {
            System.out.println("The person" +person.getName()+ " hasn't couple");
            return new TreeSet<Person>();
        }
        else
            return getFriends(couple);
    }

    public Set<Person> getFriendsCouple (Person person) {

        Set<Person> friends = getFriends(person);
        Set<Person> couples= new HashSet<>();
        for (Person friend : friends) {

            Person couple = getCouple(friend);
            if (couple != null)
            {
                couples.add(couple);
            }
        }

        return couples;
    }

    public Integer getNumberOfFriends(Person person)
    {
       return getFriends(person).size();
    }

    public List<Person> popularity () {

        List<Person> personList = new ArrayList<>(peopleByName.values()); // guardamos el map de personas en una array list
        Collections.sort(personList, (p1, p2) -> {
            int numFriends1 =getNumberOfFriends(p1);
            int numFriends2 = getNumberOfFriends(p2);
            if (numFriends1<numFriends2)
            {
                return 1;
            }

            if (numFriends1>numFriends2)
            {
               return -1;
            }

            else return 0;
        });

        return personList;
    }

    public boolean existsConnection(Person p1, Person p2) {

        Set<Person> visitedPeople = new HashSet<>();
        Queue<Person> peopleQueue = new LinkedList<>();

        Person nextPerson = p1;
        boolean friendFound = false;
        visitedPeople.add(p1);

        globalLoop:
        while (nextPerson != null) {

            for (Person friend : getFriends(nextPerson)) {

                if (friend.equals(p2)) {
                    friendFound = true;
                    break globalLoop;
                }

                if (!visitedPeople.contains(friend)) {

                    visitedPeople.add(friend);
                    peopleQueue.offer(friend);

                }
            }

            nextPerson = peopleQueue.poll();
        }

        return friendFound;
    }


        public SortedSet<Person> getConnectionDegreePath(Person p1, Person p2)
        {
            return null;
        }



}
