package Study.Sorting;

public class EnrichmentServiceMsisdn implements EnrichmentServiceInterface {
    private static final String EnrichmentTypeName = "msisdn";
    private final UserRepository ur;
    public EnrichmentServiceMsisdn(UserRepository ur){
        this.ur = ur;
    }
    // возвращается обогащенный (или необогащенный content сообщения)
    public MessageDTO enrich(MessageDTO msg) {
        String msisdnValue = msg.getContent().get(EnrichmentTypeName);
        MessageDTO enrichedMessage = new MessageDTO(msg);

        if (msisdnValue != null) {
            User userToEnrich = ur.findByMsisdn(msisdnValue);
            if (userToEnrich != null) {
                //m.put(EnrichmentTypeName, msisdnValue);
                    enrichedMessage.getContent().put("firstName", userToEnrich.getFirstName());
                    enrichedMessage.getContent().put("lastName", userToEnrich.getLastName());
            }
        }
        return enrichedMessage;
    }
}
