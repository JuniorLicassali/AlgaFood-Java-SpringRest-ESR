package com.algaworks.algafood.api.v1.openapi.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("Links")
public class LinksDTOOpenApi {
	
	private LinkModel rel;
	
	@Setter
	@Getter
	@ApiModel("Link")
	private class LinkModel {
		private String href;
		private boolean templated;
	}
}
