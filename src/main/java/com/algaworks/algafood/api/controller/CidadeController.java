package com.algaworks.algafood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.CidadeDTOAssembler;
import com.algaworks.algafood.api.assembler.CidadeInputDisassembler;
import com.algaworks.algafood.api.dto.CidadeDTO;
import com.algaworks.algafood.api.dto.input.CidadeInput;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidade;
	
	@Autowired
	private CidadeDTOAssembler cidadeDTOAssembler;
	
	@Autowired
	private CidadeInputDisassembler cidadeInputDisassembler;

	@GetMapping
	public List<CidadeDTO> listar() {
		
		return cidadeDTOAssembler.toCollectionDTO(cidadeRepository.findAll());
	}

	@GetMapping("/{cidadeId}")
	public CidadeDTO buscar(@PathVariable Long cidadeId) {
		
		return cidadeDTOAssembler.toDTO(cadastroCidade.buscarCidadeOuFalhar(cidadeId));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeDTO adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
		try {
			Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);
			
			cidade = cadastroCidade.salvar(cidade);
			
			return cidadeDTOAssembler.toDTO(cidade);
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping("/{cidadeId}")
	public CidadeDTO atualizar(@PathVariable Long cidadeId, @RequestBody @Valid CidadeInput cidadeInput) {
		try {
			Cidade cidadeAtual = cadastroCidade.buscarCidadeOuFalhar(cidadeId);
			
			cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeAtual);
			
			cidadeAtual = cadastroCidade.salvar(cidadeAtual);

			return cidadeDTOAssembler.toDTO(cidadeAtual);
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cidadeId) {
		cadastroCidade.excluir(cidadeId);
	}
}