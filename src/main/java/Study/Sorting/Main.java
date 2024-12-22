package Study.Sorting;


import java.util.Map;

public class Main {


    public static void main(String[] args) {

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

    }
}
