package com.nontius.proje.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Value(
		@JsonProperty("firstname") String name, 
		@JsonProperty("lastname") String lastname) 
{

}
