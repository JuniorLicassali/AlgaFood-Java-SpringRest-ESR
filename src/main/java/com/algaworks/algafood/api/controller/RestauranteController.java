package com.algaworks.algafood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.RestauranteDTOAssembler;
import com.algaworks.algafood.api.assembler.RestauranteInputDisassembler;
import com.algaworks.algafood.api.dto.RestauranteDTO;
import com.algaworks.algafood.api.dto.input.RestauranteInput;
import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@Autowired
	private RestauranteDTOAssembler restauranteDTOAssembler;
	
	@Autowired
	private RestauranteInputDisassembler restauranteInputDisassembler;

	@GetMapping
	public List<RestauranteDTO> listar() {
		return restauranteDTOAssembler.toCollectionDTO(restauranteRepository.findAll());
	}

	@GetMapping("/{restauranteId}")
	public RestauranteDTO buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
		
		RestauranteDTO restauranteDTO = restauranteDTOAssembler.toDTO(restaurante);
		
		return restauranteDTO;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RestauranteDTO adicionar(@RequestBody @Valid RestauranteInput restauranteInput) {
		try {
			Restaurante restaurante = restauranteInputDisassembler.toDomainObject(restauranteInput);
			
			return restauranteDTOAssembler.toDTO(cadastroRestaurante.salvar(restaurante));
		} catch (CozinhaNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}

	}

	@PutMapping("/{restauranteId}")
	public RestauranteDTO atualizar(@PathVariable Long restauranteId, @RequestBody @Valid RestauranteInput restauranteInput) {

		try {

			Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);
			
			restauranteInputDisassembler.copyToDomainObject(restauranteInput, restauranteAtual);

			return restauranteDTOAssembler.toDTO(cadastroRestaurante.salvar(restauranteAtual));
		} catch (CozinhaNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}

	}
}
