package Study.Sorting;

import java.util.Map;

public class MessageDTO {

    final private Map<String, String> content;
    final private EnrichmentType enrichmentType;

    public MessageDTO(Map<String, String> content, EnrichmentType enrichmentType) {
        this.content = content;
        this.enrichmentType = enrichmentType;
    }

    public enum EnrichmentType {
        MSISDN, EMAIL
    }
}
