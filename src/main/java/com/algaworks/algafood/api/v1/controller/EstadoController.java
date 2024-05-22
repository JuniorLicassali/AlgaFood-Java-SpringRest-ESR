package com.algaworks.algafood.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.v1.assembler.EstadoDTOAssembler;
import com.algaworks.algafood.api.v1.assembler.EstadoInputDisassembler;
import com.algaworks.algafood.api.v1.dto.EstadoDTO;
import com.algaworks.algafood.api.v1.dto.input.EstadoInput;
import com.algaworks.algafood.api.v1.openapi.controller.EstadoControllerOpenApi;
import com.algaworks.algafood.core.security.CheckSecurity;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping(path = "/v1/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController implements EstadoControllerOpenApi {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CadastroEstadoService cadastroEstado;
	
	@Autowired
	private EstadoDTOAssembler estadoDTOAssembler;
	
	@Autowired
	private EstadoInputDisassembler estadoInputDisassembler;

	@CheckSecurity.FormasPagamento.PodeConsultar
	@Override
	@GetMapping
	public CollectionModel<EstadoDTO> listar() {
		
		List<Estado> estadoDTO = estadoRepository.findAll();
 		
		return estadoDTOAssembler.toCollectionModel(estadoDTO);
	}

	@CheckSecurity.FormasPagamento.PodeConsultar
	@Override
	@GetMapping("/{estadoId}")
	public EstadoDTO buscar(@PathVariable Long estadoId) {
	
		return estadoDTOAssembler.toModel(cadastroEstado.buscarOuFalhar(estadoId));
	}

	@CheckSecurity.FormasPagamento.PodeEditar
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoDTO adicionar(@RequestBody @Valid EstadoInput estadoInput) {
		
		Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);
		
		estado = cadastroEstado.salvar(estado);
		
		return estadoDTOAssembler.toModel(estado);
	}

	@CheckSecurity.FormasPagamento.PodeEditar
	@Override
	@PutMapping("/{estadoId}")
	public EstadoDTO atualizar(@PathVariable Long estadoId, @RequestBody @Valid EstadoInput estadoInput) {
		Estado estadoAtual = cadastroEstado.buscarOuFalhar(estadoId);
		
		estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);
		
		estadoAtual = cadastroEstado.salvar(estadoAtual);

		return  estadoDTOAssembler.toModel(estadoAtual);
	}

	@CheckSecurity.FormasPagamento.PodeEditar
	@Override
	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {
		cadastroEstado.excluir(estadoId);
	}

}
