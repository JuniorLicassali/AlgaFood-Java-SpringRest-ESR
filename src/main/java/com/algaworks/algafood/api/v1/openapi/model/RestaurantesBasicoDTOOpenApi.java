package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.dto.RestauranteBasicoDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("RestaurantesBasicoDTO")
@Data
public class RestaurantesBasicoDTOOpenApi {

	private RestaurantesEmbeddedDTOOpenApi _embedded;
	private Links _links;
	
	@ApiModel("RestaurantesEmbeddedSTO")
	@Data
	public class RestaurantesEmbeddedDTOOpenApi {
		private List<RestauranteBasicoDTO> restaurantes;
	}
}
