package com.algaworks.algafood.api.v1.dto.input;

import javax.validation.constraints.NotNull;

public class CozinhaIdInput {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
