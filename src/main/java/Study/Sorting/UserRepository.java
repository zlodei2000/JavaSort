package Study.Sorting;

public interface UserRepository {

    User findByMsisdn(String msisdn);

    boolean updateUserByMsisdn(String msisdn, User user);
}
