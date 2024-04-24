package com.algaworks.algafood.api.v2.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.dto.input.CozinhaInput;
import com.algaworks.algafood.api.v2.dto.CozinhaDTOV2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cozinhas")
public interface CozinhaControllerOpenApiV2 {
	
	@ApiOperation("Lista as cozinhas com paginação")
	public PagedModel<CozinhaDTOV2> listar(Pageable pageable);
	
	@ApiOperation("Busca uma cozinha por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID da cozinha inválido", response = Problem.class), 
		@ApiResponse(code = 404, message = "Cozinha não encontrada", response = Problem.class)})
	public CozinhaDTOV2 buscar(@ApiParam(value = "ID de um cozinha", example = "1", required = true) Long cozinhaId);
	
	@ApiOperation("Cadastra uma cozinha")
	@ApiResponses({@ApiResponse(code = 201, message = "Cozinha cadastrada")})
	public CozinhaDTOV2 adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova cozinha", required = true)CozinhaInput cozinhaInput);
	
	@ApiOperation("Atualiza uma cozinha por ID")
	@ApiResponses({@ApiResponse(code = 200, message = "Cozinha atualizada"), @ApiResponse(code = 404, message = "Cozinha não encontrada", response = Problem.class)})
	public CozinhaDTOV2 atualizar(@ApiParam(value = "ID de uma cozinha", example = "1", required = true) Long cozinhaId, @ApiParam(name = "corpo", value = "Representação de uma cidade com os novos dados") CozinhaInput cozinhaInput);
	
	@ApiOperation("Exclui uma cozinha por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Cozinha excluída"),
		@ApiResponse(code = 404, message = "Cozinha não encontrada", response = Problem.class)
})
	public void remover(@ApiParam(value = "ID de uma cozinha", example = "1", required = true)
	Long cozinhaId);
	
}
