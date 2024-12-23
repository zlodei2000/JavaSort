package Study.Sorting;

import java.util.HashMap;

public class EnrichmentHandlers {
    private final HashMap<MessageDTO.EnrichmentType, EnrichmentServiceInterface> handlers = new HashMap<>();

    public EnrichmentHandlers(UserRepository ur) {
            handlers.put(MessageDTO.EnrichmentType.MSISDN, new EnrichmentServiceMsisdn(ur));
            handlers.put(MessageDTO.EnrichmentType.EMAIL, new EnrichmentServiceEmail(ur));
    }
    public MessageDTO enrich(MessageDTO message) throws Exception {
        EnrichmentServiceInterface handler = handlers.get(message.getEnrichmentType());
        if (handler == null) {
            throw new Exception("No handler for enrichment type " + message.getEnrichmentType());
        }
        return handler.enrich(message);
    }
}
