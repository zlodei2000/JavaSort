package Study.Sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    UserRepositoryImpl ur = new UserRepositoryImpl();
    public UserRepositoryImplTest() {
        ur.addUser(new User("Ivan", "Ivanov","123", "ivan@gmail.com"));
    }
    @Test
    void findByMsisdn() {
        assertNotNull (ur.findByMsisdn("123"));
    }

    @Test
    void updateUserByMsisdn() {
        ur.updateUserByMsisdn("123", new User("Jonh", "Doe","123", "jonh@gmail.com"));
        assertNotNull (ur.findByMsisdn("123"));
        assertEquals("Jonh", ur.findByMsisdn("123").getFirstName());
        assertEquals("Doe", ur.findByMsisdn("123").getLastName());
    }

    @Test
    void addUser() {
        ur.addUser(new User("Sidor" , "Sidorov","555", "sidor@gmail.com"));
        assertNotNull (ur.findByMsisdn("555"));
        assertEquals("Sidor" , ur.findByMsisdn("555").getFirstName());
        assertEquals("Sidorov", ur.findByMsisdn("555").getLastName());
        assertEquals(2, ur.getUsers().size());
    }

    @Test
    void getUsers() {
        assertNotNull(ur.getUsers());
    }
}
