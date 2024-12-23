package Study.Sorting;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

class EnrichmentServiceMsisdnTest {

    @Test
    void enrich() {
        UserRepositoryImpl ur  = new UserRepositoryImpl();
        ur.addUser(new User("Ivan", "Ivanov","123", "ivan@gmail.com"));

        MessageDTO msg  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "123"))),
                MessageDTO.EnrichmentType.MSISDN);
        assertEquals("Message {content={action=button_click, page=book_card, msisdn=123}, enrichmentType=MSISDN}", msg.toString());
        EnrichmentServiceMsisdn es = new EnrichmentServiceMsisdn(ur);
        assertDoesNotThrow(() -> {
            es.enrich(msg);
        });
        assertEquals("Message {content={action=button_click, firstName=Ivan, lastName=Ivanov, page=book_card, msisdn=123}, enrichmentType=MSISDN}", msg.toString());
    }
}
