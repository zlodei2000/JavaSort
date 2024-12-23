package Study.Sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User u = new User("", "", "","");
    @Test
    void getMsisdn() {
        u.setMsisdn("1234");
        assertEquals("1234", u.getMsisdn());
    }

    @Test
    void setMsisdn() {
        u.setMsisdn("123");
        assertEquals("123", u.getMsisdn());
    }

    @Test
    void testToString() {
        u = new User("Ivan", "Ivanov", "123", "ivan@gmail.com");
        assertEquals("Ivan Ivanov 123 ivan@gmail.com", u.toString());
    }

    @Test
    void setFirstName() {
        u.setFirstName("Ivan");
        assertEquals("Ivan", u.getFirstName());
    }

    @Test
    void setLastName() {
        u.setLastName("Ivanov");
        assertEquals("Ivanov", u.getLastName());
    }

    @Test
    void getFirstName() {
        u.setFirstName("Ivan");
        assertEquals("Ivan", u.getFirstName());
    }

    @Test
    void getLastName() {
        u.setLastName("Ivanov");
        assertEquals("Ivanov", u.getLastName());
    }

    @Test
    void getEmail() {
        u.setEmail("ivan@gmail.com");
        assertEquals("ivan@gmail.com", u.getEmail());
    }

    @Test
    void setEmail() {
        u.setEmail("ivan2@gmail.com");
        assertEquals("ivan2@gmail.com", u.getEmail());
    }
}
