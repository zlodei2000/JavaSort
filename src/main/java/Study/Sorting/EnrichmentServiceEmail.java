package Study.Sorting;

public class EnrichmentServiceEmail implements EnrichmentServiceInterface {
    private static final String EnrichmentTypeName = "email";
    private final UserRepository ur;
    public EnrichmentServiceEmail(UserRepository ur) {
        this.ur = ur;
    }
    @Override
    public MessageDTO enrich(MessageDTO message) {
        return message;
    }
}
