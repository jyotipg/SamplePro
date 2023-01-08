package com.learn.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@lombok.ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponseMessage extends APIResponse {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("statusCode")
	private int statusCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("statusMessage")
	private Object message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("errorMessage")
	private Object errors;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("message")
	private Object object;
}
