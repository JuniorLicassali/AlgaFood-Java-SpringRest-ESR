package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.dto.PermissaoDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("PermissoesDTO")
@Data
public class PermissoesDTOOpenApi {
	
	private PermissoesEmbeddedDTOOpenApi _embedded;
	private Links links_;
	
	@ApiModel("PermissoesEmbeddedDTO")
	@Data
	public class PermissoesEmbeddedDTOOpenApi {
		private List<PermissaoDTO> permissoes;
	}

}
