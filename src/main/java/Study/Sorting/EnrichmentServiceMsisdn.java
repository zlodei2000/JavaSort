package Study.Sorting;

public class EnrichmentServiceMsisdn implements EnrichmentServiceInterface {
    private static final String EnrichmentTypeName = "msisdn";
    // возвращается обогащенный (или необогащенный content сообщения)
    public MessageDTO enrich(MessageDTO message) {
        return message;
    }
}
