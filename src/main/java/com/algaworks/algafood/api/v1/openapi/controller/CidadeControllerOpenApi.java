package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.dto.CidadeDTO;
import com.algaworks.algafood.api.v1.dto.input.CidadeInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cidades")
public interface CidadeControllerOpenApi {

	@ApiOperation("Lista as cidades")
	public CollectionModel<CidadeDTO> listar();

	@ApiOperation("Busca uma cidade por ID")
	@ApiResponses({@ApiResponse(code = 400, message = "ID da cidade inválido", response = Problem.class), @ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class)})
	public CidadeDTO buscar(@ApiParam(value = "ID de uma cidade", example = "1", required = true) Long cidadeId);

	@ApiOperation("Cadastra uma cidade")
	@ApiResponses({@ApiResponse(code = 201, message = "Cidade cadastrada")})
	public CidadeDTO adicionar(@ApiParam(name = "corpo", value = "Representação de uma nova cidade", required = true) CidadeInput cidadeInput);

	@ApiOperation("Atualiza uma cidade por ID")
	@ApiResponses({@ApiResponse(code = 200, message = "Cidade atualizada"), @ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class)})
	public CidadeDTO atualizar(@ApiParam(value = "ID de uma cidade", example = "1", required = true) Long cidadeId, @ApiParam(name = "corpo", value = "Representação de uma nova cozinha") CidadeInput cidadeInput);

	@ApiOperation("Exclui uma cidade por ID")
	@ApiResponses({@ApiResponse(code = 204, message = "Cidade excluída"), @ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class)})
	public void remover(@ApiParam(value = "Id de uma cidade", example = "1", required = true) Long cidadeId);
}
