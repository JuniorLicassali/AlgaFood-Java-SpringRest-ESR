package com.algaworks.algafood.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class EnderecoDTO {
	
	@ApiModelProperty(example = "38400-000")
	private String cep;
	
	@ApiModelProperty(example = "Rua Floriano Peixoto")
	private String logradouro;
	
	@ApiModelProperty(example = "1500")
	private String numero;
	
	@ApiModelProperty(example = "Apto 901")
	private String complemento;
	
	@ApiModelProperty(example = "Centro")
	private String bairro;
	
	private CidadeResumoDTO cidade;
}
