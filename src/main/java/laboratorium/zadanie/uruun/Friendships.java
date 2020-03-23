package laboratorium.zadanie.uruun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!	
    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }
    
    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return friendships.get(person);
    }
    
    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        if(friendships.get(person1).contains(person2)) {
        	if(friendships.get(person2).contains(person1)) {
        		return true;
        	}
        }
        return false;
    }
    
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
    	if(!friendships.containsKey(person)) {
    		friendships.put(person, new ArrayList<String>());
    	}
    	if(!friendships.get(person).contains(friend)) {
    		friendships.get(person).add(friend);
    	}
    }
}