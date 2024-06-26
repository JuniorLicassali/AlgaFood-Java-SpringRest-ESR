package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.dto.CozinhaDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CozinhasDTO")
@Getter
@Setter
public class CozinhasDTOOpenApi {
	
	private CozinhasEmbeddedDTOOpenApi _embedded;
	private Links _links;
	private PageDTOOpenApi page;

	@ApiModel("CozinhasEmbeddedDTO")
	@Data
	public class CozinhasEmbeddedDTOOpenApi {
		private List<CozinhaDTO> cozinhas;
	}
	
}
