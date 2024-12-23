package Study.Sorting;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    @Test
    void shouldSucceedEnrichmentInConcurrentEnvironmentSuccessfully() throws InterruptedException {
        Main app  = new Main();
        app.init();

        List<MessageDTO> enrichmentResults = new CopyOnWriteArrayList<>();

        MessageDTO msg  = new MessageDTO(new HashMap<>(Map.ofEntries(
                entry("action", "button_click"),
                entry("page", "book_card"),
                entry("msisdn", "123"))),
                MessageDTO.EnrichmentType.MSISDN);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    enrichmentResults.add(
                            app.enrich(msg)
                    );
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                latch.countDown();     // уменьшаем значение latch на 1
            });
        }
        latch.await(); // ждем, пока latch не станет равным 0, то есть пока не закончат работу все джобы в цикле

        // проверяем валидность полученных сообщений в enrichmentResult
        for(MessageDTO m: enrichmentResults) {
            assertEquals("Message {content={action=button_click, firstName=Ivan, lastName=Ivanov, page=book_card, msisdn=123}, enrichmentType=MSISDN}", m.toString());
        }
        assertEquals(5, enrichmentResults.size());
    }
}
