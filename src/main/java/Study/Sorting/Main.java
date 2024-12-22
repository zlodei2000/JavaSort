package Study.Sorting;


import java.util.Map;

public class Main {


    public static void main(String[] args) throws Exception {

        UserRepositoryImpl ur  = new UserRepositoryImpl();
        ur.addUser(new User("Ivan", "Ivanov","123", "ivan@gmail.com"));
        ur.addUser(new User("Petr", "Petrov","456", "petr@gmail.com"));
        ur.addUser(new User("Sidor", "Sidorov","789", "sidor@gmail.com"));

        ur.updateUserByMsisdn("123", new User("Ivan", "Kozlov","111", "ivan@gmail.com"));
        ur.updateUserByMsisdn("333", new User("Ivan", "Dolbakov","111", "ivan@gmail.com"));

        ur.printUsers();

        MessageDTO msg1  = new MessageDTO(Map.of("action", "button_click", "page", "book_card", "msisdn", "123"), MessageDTO.EnrichmentType.MSISDN);
        MessageDTO msg2  = new MessageDTO(Map.of("action", "button_click", "page", "book_card", "msisdn", "123"), MessageDTO.EnrichmentType.EMAIL);
        MessageDTO msg3  = new MessageDTO(Map.of("action", "button_click", "page", "book_card", "msisdn", "555"), MessageDTO.EnrichmentType.MSISDN);
        MessageDTO msg4  = new MessageDTO(Map.of("action", "button_click", "page", "book_card", "msisdn", "789",
                "firstName", "Jonh", "lastName", "Doe"), MessageDTO.EnrichmentType.MSISDN);
        MessageDTO msg5  = new MessageDTO(Map.of("action", "button_click", "page", "book_card", "msisdn", "555"), MessageDTO.EnrichmentType.LANGUAGE);

        EnrichmentHandlers eh = new EnrichmentHandlers();

        msg1 = eh.enrich(msg1);
        System.out.println(msg1);
        msg2 = eh.enrich(msg2);
        System.out.println(msg2);
        msg3 = eh.enrich(msg3);
        System.out.println(msg3);
        msg4 = eh.enrich(msg4);
        System.out.println(msg4);
        msg5 = eh.enrich(msg5);
        System.out.println(msg5);

    }
}
