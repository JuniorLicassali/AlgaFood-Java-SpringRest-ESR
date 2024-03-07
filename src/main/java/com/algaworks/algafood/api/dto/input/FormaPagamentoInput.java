package com.algaworks.algafood.api.dto.input;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormaPagamentoInput {
	
	@ApiModelProperty(example = "Cartão de crédito", required = true)
	@NotNull
	private String descricao;
	
}
