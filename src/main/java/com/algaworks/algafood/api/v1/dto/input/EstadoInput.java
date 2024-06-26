package com.algaworks.algafood.api.v1.dto.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoInput {

	@ApiModelProperty(example = "Minas Gerais", required = true)
	@NotBlank
	private String nome;

}
