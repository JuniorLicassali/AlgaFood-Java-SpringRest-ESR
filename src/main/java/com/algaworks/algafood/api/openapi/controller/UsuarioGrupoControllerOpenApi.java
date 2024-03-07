package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.dto.GrupoDTO;
import com.algaworks.algafood.api.exceptionhandler.Problem;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Usuários")
public interface UsuarioGrupoControllerOpenApi {

	@ApiResponses({
		@ApiResponse(code = 404, message = "Usuário não encontrado", response = Problem.class)
	})
	@ApiOperation("Lista os grupos associados a um usuário")
	public List<GrupoDTO> listar(@ApiParam(value = "ID do usuário", example = "1", required = true) Long usuarioId);
	
	@ApiOperation("Associação de grupo com usuário")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Desassociação realizada com sucesso"),
		@ApiResponse(code = 404, message = "Usuário ou grupo não encontrado", 
			response = Problem.class)
	})
	public void associar(@ApiParam(value = "ID do usuário", example = "1", required = true) Long usuarioId, @ApiParam(value = "ID do grupo", example = "1", required = true) Long grupoId);
	
	@ApiOperation("Desassociação de grupo com usuário")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Associação realizada com sucesso"),
		@ApiResponse(code = 404, message = "Usuário ou grupo não encontrado", 
			response = Problem.class)
	})
	public void desassociar(@ApiParam(value = "ID do usuário", example = "1", required = true) Long usuarioId, @ApiParam(value = "ID do grupo", example = "1", required = true) Long grupoId);
	
}
