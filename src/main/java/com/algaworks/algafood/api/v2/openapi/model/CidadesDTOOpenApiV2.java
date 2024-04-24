package com.algaworks.algafood.api.v2.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.dto.CidadeDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("CidadesDTO")
@Data
public class CidadesDTOOpenApiV2 {
	
	private CidadeEmbeddedDTOOpenApi _embedded;
	private Links _links;

	@ApiModel("CidadesEmbeddedDTO")
	@Data
	public class CidadeEmbeddedDTOOpenApi {
		private List<CidadeDTO> cidades;
	}
}
