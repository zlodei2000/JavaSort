package Study.Sorting;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

class MessageDTOTest {
    private final MessageDTO msg;
    public MessageDTOTest() {
        msg  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "123"))),
                MessageDTO.EnrichmentType.MSISDN);
    }
    @Test
    void testToString() {
        assertEquals("Message {content={action=button_click, page=book_card, msisdn=123}, enrichmentType=MSISDN}", msg.toString());
    }

    @Test
    void getEnrichmentType() {
        assertEquals(MessageDTO.EnrichmentType.MSISDN, msg.getEnrichmentType());
    }

    @Test
    void getContent() {
        assertEquals("button_click", msg.getContent().get("action"));
    }
}
