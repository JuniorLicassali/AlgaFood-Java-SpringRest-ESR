package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.dto.GrupoDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("GruposDTO")
@Data
public class GruposDTOOpenApi {
	
	private GruposEmbeddedDTOOpenApi _embedded;
	private Links _links;
	
	@ApiModel("GruposEmbeddedDTO")
	@Data
	public class GruposEmbeddedDTOOpenApi {
		
		private List<GrupoDTO> grupos;
		
	}
}
