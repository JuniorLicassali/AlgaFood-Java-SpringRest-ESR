package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.dto.PedidoResumoDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PedidosDTO")
@Getter
@Setter
public class PedidosResumoDTOOpenApi {

	private PedidosResumoEmbeddeDTOOpenApi _embedded;
	private Links _links;
	private PageDTOOpenApi page;
	
	@ApiModel("PedidosResumoEmbeddedDTO")
	@Data
	public class PedidosResumoEmbeddeDTOOpenApi {
		List<PedidoResumoDTO> pedidos;
	}

}
