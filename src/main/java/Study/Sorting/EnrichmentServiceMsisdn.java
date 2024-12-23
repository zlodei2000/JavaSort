package Study.Sorting;

public class EnrichmentServiceMsisdn implements EnrichmentServiceInterface {
    private static final String EnrichmentTypeName = "msisdn";
    private final UserRepository ur;
    public EnrichmentServiceMsisdn(UserRepository ur){
        this.ur = ur;
    }
    // возвращается обогащенный (или необогащенный content сообщения)
    public MessageDTO enrich(MessageDTO message) {
        String msisdnValue = message.getContent().get(EnrichmentTypeName);
        if (msisdnValue != null) {
            User userToEnrich = ur.findByMsisdn(msisdnValue);
            if (userToEnrich != null) {
                //m.put(EnrichmentTypeName, msisdnValue);
                message.getContent().put("firstName", userToEnrich.getFirstName());
                message.getContent().put("lastName", userToEnrich.getLastName());
            }
        }
        return message;
    }
}
