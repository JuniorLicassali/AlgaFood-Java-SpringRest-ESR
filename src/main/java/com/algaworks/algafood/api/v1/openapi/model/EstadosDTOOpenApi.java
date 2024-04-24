package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.dto.EstadoDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("EstadosDTO")
@Data
public class EstadosDTOOpenApi {
	
	private EstadoEmbeddedDTOOpenApi _embedded;
	private Links _links;

	@ApiModel("EstadosEmbeddedDTO")
	@Data
	public class EstadoEmbeddedDTOOpenApi {
		private List<EstadoDTO> estados;
	}
}
