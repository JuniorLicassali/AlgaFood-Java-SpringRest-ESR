package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.dto.ProdutoDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("ProdutosDTO")
@Data
public class ProdutosDTOOpenApi {

	private ProdutosEmbeddeDTOOpenApi _embedded;
	private Links _links;
	
	@ApiModel("ProdutosEmbedded")
	@Data
	public class ProdutosEmbeddeDTOOpenApi {
		List<ProdutoDTO> produtos;
	}
}
