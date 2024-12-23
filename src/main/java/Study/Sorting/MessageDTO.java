package Study.Sorting;

import java.util.HashMap;
import java.util.Map;

public class MessageDTO {

    private final Map<String, String> content = new HashMap<>();
    final private EnrichmentType enrichmentType;

    public MessageDTO(Map<String, String> content, EnrichmentType enrichmentType) {
        synchronized (this) {
            this.content.putAll(content);
            this.enrichmentType = enrichmentType;
        }
    }
    public MessageDTO(MessageDTO msg) {
        synchronized (this) {
            this.content.putAll(msg.getContent());
            this.enrichmentType = msg.enrichmentType;
        }
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

    public Map<String, String>  getContent() {
        return content;
    }

    public enum EnrichmentType {
        MSISDN, EMAIL, LANGUAGE
    }
}
