package Study.Sorting;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

class EnrichmentHandlersTest {

    @Test
    void enrich() throws Exception {
        UserRepositoryImpl ur  = new UserRepositoryImpl();
        ur.addUser(new User("Ivan", "Ivanov","123", "ivan@gmail.com"));

        MessageDTO msg1  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "123"))),
                MessageDTO.EnrichmentType.MSISDN);

        MessageDTO msg2  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "123"))),
                MessageDTO.EnrichmentType.LANGUAGE);

        EnrichmentHandlers eh = new EnrichmentHandlers(ur);
        //assertDoesNotThrow(() -> {
        MessageDTO res = eh.enrich(msg1);
        //});
        assertEquals("Message {content={action=button_click, firstName=Ivan, lastName=Ivanov, page=book_card, msisdn=123}, enrichmentType=MSISDN}", res.toString());
        assertThrows(Exception.class, () -> {
            eh.enrich(msg2);
        });
    }
}
