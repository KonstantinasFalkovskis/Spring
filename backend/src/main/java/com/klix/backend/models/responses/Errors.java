package com.klix.backend.models.responses;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@JsonPropertyOrder({
        "errors"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Errors implements Serializable {
    private static final ObjectMapper objectMapper =
            new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    @JsonProperty("errors")
    public Error errors;


    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
