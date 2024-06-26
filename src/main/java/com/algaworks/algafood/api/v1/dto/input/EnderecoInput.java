package com.algaworks.algafood.api.v1.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {
	
	@ApiModelProperty(example = "38400-000", required = true)
	@NotBlank
	private String cep;
	
	@ApiModelProperty(example = "Rua Floriano Peixoto", required = true)
	@NotBlank
	private String logradouro;
	
	@ApiModelProperty(example = "1500", required = true)
	@NotBlank
	private String numero;
	
	@ApiModelProperty(example = "apto 901")
	private String complemento;
	
	@ApiModelProperty(example = "Centro", required = true)
	@NotBlank
	private String bairro;
	
	@Valid
	@NotNull
	private CidadeIdInput cidade;
}
