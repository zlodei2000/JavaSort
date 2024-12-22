package Study.Sorting;

public class EnrichmentServiceEmail implements EnrichmentServiceInterface {
    private static final String EnrichmentTypeName = "email";

    @Override
    public MessageDTO enrich(MessageDTO message) {
        return message;
    }
}
