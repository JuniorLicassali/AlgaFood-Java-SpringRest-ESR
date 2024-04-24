package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Link;

import com.algaworks.algafood.api.v1.dto.FormaPagamentoDTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("FormasPagamentoDTO")
@Data
public class FormasPagamentoDTOOpenApi {

	private FormasPagamentoEmbeddedDTOOpenApi _embedded;
	private Link _links;
	
	@ApiModel("FormasPagamentoEmbeddedDTO")
	@Data
	public class FormasPagamentoEmbeddedDTOOpenApi {
		private List<FormaPagamentoDTO> formasPagamento;
	}
}
