package laboratorium.zadanie.uruun;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class FriendshipsTestAssertj {

	Friendships fs;
	
    @Before
    public void setup(){
        fs = new Friendships();
    }

    @Test
    public void test_makeFriends(){
        String f1 = "John";
        String f2 = "Peter";
        String f3 = "Mark";
        fs.makeFriends(f1, f2);
        assertThat(fs.getFriendsList(f1)).hasSize(1).contains(f2).doesNotContain(f3);
    }
    
    @Test
    public void test_getFriends(){
        String f1 = "John";
        String f2 = "Peter";
        fs.makeFriends(f1, f2);
        assertThat(fs.getFriendsList(f1)).isNotEmpty();
    }
    
    @Test
    public void test_getFriends_null(){
        String f1 = "John";
        String f2 = "Peter";
        String f3 = "Mark";
        fs.makeFriends(f1, f2);
        assertThat(fs.getFriendsList(f3)).isEqualTo(null);
    }
    
    @Test
    public void test_areFriends(){
        String f1 ="John";
        String f2 ="Peter";
        fs.makeFriends(f1, f2);
        assertThat(fs.areFriends(f1, f2)).isTrue();
    }
    
    @Test
    public void test_areFriends_false(){
        String f1 = "John";
        String f2 = "Peter";
        String f3 = "Mark";
        fs.makeFriends(f1, f2);
        assertThat(fs.areFriends(f1, f3)).isFalse();
    }
    
    @Test
    public void test_makeFriends_already_friends(){
        String f1 = "John";
        String f2 = "Peter";
        String f3 = "Mark";
        fs.makeFriends(f1, f2);
        fs.makeFriends(f1, f2);
        assertThat(fs.getFriendsList(f1)).hasSize(1).doesNotContain(f3).contains(f2);
    }

    @After
    public void teardown(){
        fs = null;
    }
}
