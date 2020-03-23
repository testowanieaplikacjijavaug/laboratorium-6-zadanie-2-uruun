package laboratorium.zadanie.uruun;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.*;

public class FriendshipsTestAssertj {

	Friendships fs;
	
    @BeforeEach
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
        assertThat(fs.getFriendsList(f3)).is(null);
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

    @AfterEach
    public void teardown(){
        fs = null;
    }
}
