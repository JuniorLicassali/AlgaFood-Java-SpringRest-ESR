package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.dto.UsuarioDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("UsuariosDTO")
@Data
public class UsuarioDTOOpenApi {

	private UsuariosEmbeddedDTOOpenApi _embedded;
	private Links _links;
	
	@ApiModel("UsuariosEmbeddedDTO")
	@Data
	public class UsuariosEmbeddedDTOOpenApi {
		private List<UsuarioDTO> usuarios;
	}
}
