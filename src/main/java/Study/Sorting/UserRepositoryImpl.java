package Study.Sorting;

import java.util.HashSet;

public class UserRepositoryImpl implements UserRepository {
    private final HashSet<User> users = new HashSet<>();

    @Override
    public User findByMsisdn(String msisdn) {
        return users.stream().filter(user -> user.getMsisdn().equals(msisdn)).findFirst().orElse(null);
    }

    @Override
    public boolean updateUserByMsisdn(String msisdn, User user) {
        synchronized (users) {
            User u = findByMsisdn(msisdn);
            if(u != null) {
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                return true;
            }else
                return false;
        }
    }

    public void addUser(User user) {
        users.add(user);
    }
    public HashSet<User> getUsers() {
        return users;
    }

    public void printUsers() {
        users.forEach(System.out::println);
        System.out.println("Users count:" + users.size());
    }
}
