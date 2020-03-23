package laboratorium.zadanie.uruun;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.hamcrest.collection.IsEmptyCollection.*;

public class FriendshipsTestHamcrest {
    
    private Friendships fs;
    
    @Before
    public void setUp() {
        fs = new Friendships();
    }
    
    @Test
    public void test_makeFriends() {
        final String f1 = "John";
        final String f2 = "Peter";
        
        fs.makeFriends(f1, f2);
        
        assertThat(fs.getFriendsList(f1), hasItem(f2));
        assertThat(fs.getFriendsList(f2), hasItem(f1));
    }
    
    @Test
    public void test_makeFriends_2() {
        final String f1 = "John";
        final String f2 = "Peter";
        final String f3 = "Mark";
        
        List<String> friends = new ArrayList<>();
        friends.add(f2);
        fs.friendships.put(f1, friends);
        
        fs.makeFriends(f1, f3);
        
        assertThat(fs.getFriendsList(f3), allOf(hasItem(f1)));
    }
    
    @Test
    public void test_getFriends() {
        final String f1 = "John";
        final String f2 = "Peter";
        final String f3 = "Mark";
        
        fs.friendships.put(f1, Arrays.asList(f2, f3));
        final List<String> result = fs.getFriendsList(f1);
        assertThat(result, allOf((Matcher<? super List<String>>) hasSize(3), hasItems(f2, f3)));
    }
    
    @Test
    public void test_areFriends() {
        final String f1 = "John";
        final String f2 = "Peter";
        
        fs.friendships.put(f1, Collections.singletonList(f2));
        assertThat(fs.areFriends(f1, f2), is(true));
    }
    
    @Test
    public void shouldReturnFalseWhenCheckingForFriendship() {
        final String f1 = "John";
        final String f2 = "Peter";
        final String f3 = "Mark";
        
        fs.friendships.put(f1, Collections.singletonList(f3));
        assertThat(fs.areFriends(f1, f2), is(false));
    }
    
    @After
    public void teardown() {
        fs = null;
    }
}