package com.algaworks.algafood.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.dto.EstadoDTO;
import com.algaworks.algafood.api.v1.dto.input.EstadoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Estados")
public interface EstadoControllerOpenApi {

	@ApiOperation(value = "Lista os estados")
	public CollectionModel<EstadoDTO> listar();

	@ApiOperation("Busca um restaurante por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do estado inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Estado não encontrado", response = Problem.class)})
	public EstadoDTO buscar(@ApiParam(value = "ID de um estado", example = "1", required = true) Long estadoId);
	
	@ApiOperation(value = "Cadastra um estado")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Estado cadastrado", response = Problem.class)})
	public EstadoDTO adicionar(@ApiParam(value = "corpo", example = "Representação de um novo estado", required = true) EstadoInput estadoInput);
	
	@ApiOperation("Atualiza um estado por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Estado atualizado"),
		@ApiResponse(code = 404, message = "Estado não encontrado", response = Problem.class)
	})
	public EstadoDTO atualizar(@ApiParam(value = "ID de um estado", example = "1", required = true) Long estadoId, @ApiParam(name = "corpo", value = "Representação de um restaurante com os novos dados", required = true) EstadoInput estadoInput);
	

	@ApiOperation("Exclui um estado por ID")
	@ApiResponses({@ApiResponse(code = 204, message = "Estado excluído"), @ApiResponse(code = 404, message = "Estado não encontrado", response = Problem.class)})
	public void remover(@ApiParam(value = "ID de um estado", example = "1", required = true) Long estadoId);
	
}
