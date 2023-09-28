package com.algaworks.algafood.api.dto.input;

import javax.validation.constraints.NotNull;

public class FormaPagamentoInput {
	

	@NotNull
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
