package com.algaworks.algafood.api.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.algaworks.algafood.api.dto.EstadoDTO;

public class CidadeInput {

	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	private EstadoDTO estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
}
