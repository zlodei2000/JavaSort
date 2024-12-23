package Study.Sorting;


import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

public class Main {
    static private final UserRepositoryImpl ur = new UserRepositoryImpl();
    private static final EnrichmentHandlers eh = new EnrichmentHandlers(ur);

    public static void main(String[] args) throws Exception {
        ur.addUser(new User("Ivan", "Ivanov","123", "ivan@gmail.com"));
        ur.addUser(new User("Petr", "Petrov","456", "petr@gmail.com"));
        ur.addUser(new User("Sidor", "Sidorov","789", "sidor@gmail.com"));

        ur.updateUserByMsisdn("123", new User("Ivan", "Kozlov","111", "ivan@gmail.com"));
        ur.updateUserByMsisdn("333", new User("Ivan", "Dolbakov","111", "ivan@gmail.com"));
        ur.printUsers();

        MessageDTO msg1  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "123"))),
                MessageDTO.EnrichmentType.MSISDN);

        MessageDTO msg2  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "123"))),
                MessageDTO.EnrichmentType.EMAIL);

        MessageDTO msg3  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "555"))),
                MessageDTO.EnrichmentType.MSISDN);

        MessageDTO msg4  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("firstName", "Jonh"),
                entry("lastName", "Doe"),
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "789"))),
                MessageDTO.EnrichmentType.MSISDN);

        MessageDTO msg5  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "555"))),
                MessageDTO.EnrichmentType.LANGUAGE);

        System.out.println("before " + msg1);
        msg1 = eh.enrich(msg1);
        System.out.println("after " + msg1);

        System.out.println("before " + msg2);
        msg2 = eh.enrich(msg2);
        System.out.println("after " + msg2);

        System.out.println("before " + msg3);
        msg3 = eh.enrich(msg3);
        System.out.println("after " + msg3);

        System.out.println("before " + msg4);
        msg4 = eh.enrich(msg4);
        System.out.println("after " + msg4);

        System.out.println("before " + msg5);
        msg5 = eh.enrich(msg5);
        System.out.println("after " + msg5);

    }

    public void init() {
        ur.addUser(new User("Ivan", "Ivanov","123", "ivan@gmail.com"));
        ur.addUser(new User("Petr", "Petrov","456", "petr@gmail.com"));
        ur.addUser(new User("Sidor", "Sidorov","789", "sidor@gmail.com"));
    }
    public MessageDTO enrich(MessageDTO message) throws Exception {
        return eh.enrich(message);
    }
}
