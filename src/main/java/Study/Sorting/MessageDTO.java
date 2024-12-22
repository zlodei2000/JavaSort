package Study.Sorting;

import java.util.Map;

public class MessageDTO {

    final private Map<String, String> content;
    final private EnrichmentType enrichmentType;

    public MessageDTO(Map<String, String> content, EnrichmentType enrichmentType) {
        this.content = content;
        this.enrichmentType = enrichmentType;
    }
    @Override
    public String toString() {
        return "Message {" +
                "content=" + content +
                ", enrichmentType=" + enrichmentType +
                '}';
    }

    public EnrichmentType getEnrichmentType() {
        return enrichmentType;
    }

    public enum EnrichmentType {
        MSISDN, EMAIL, LANGUAGE
    }
}
