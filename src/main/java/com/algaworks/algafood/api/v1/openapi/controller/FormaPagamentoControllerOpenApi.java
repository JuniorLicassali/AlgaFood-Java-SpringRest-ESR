package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.dto.FormaPagamentoDTO;
import com.algaworks.algafood.api.v1.dto.input.FormaPagamentoInput;
import com.algaworks.algafood.api.v1.openapi.model.FormasPagamentoDTOOpenApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Formas de pagamento")
public interface FormaPagamentoControllerOpenApi {
	
	@ApiOperation(value = "Lista as formas de pagemento", response = FormasPagamentoDTOOpenApi.class )
	public ResponseEntity<CollectionModel<FormaPagamentoDTO>> listar(ServletWebRequest request);
	
	@ApiOperation("Busca uma forma de pagemento por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID de uma forma de pagamento inválido", response = Problem.class), 
		@ApiResponse(code = 404, message = "Forma de pagamento não encontrada", response = Problem.class)})
	public ResponseEntity<FormaPagamentoDTO> buscar(@ApiParam(value = "ID de uma forma de pagamento", example = "1", required = true) Long formaPagamentoId, ServletWebRequest request);
	
	@ApiOperation("Cadastra uma forma de pagemento")
	@ApiResponses({@ApiResponse(code = 201, message = "Forma de pagamento cadastrada")})
	public FormaPagamentoDTO adicionar(@ApiParam(name = "corpo", value = "Representação de uma nova forma de pagamento", required = true)FormaPagamentoInput formaPagamantoInput);
	
	
	@ApiOperation("Atualiza uma forma de pagamento por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Forma de pagamento atualizada"),
		@ApiResponse(code = 404, message = "Forma de pagamento não encontrada", response = Problem.class)
	})
	public FormaPagamentoDTO atualizar(@ApiParam(value = "ID de uma forma de pagamento", example = "1", required = true) Long formaPagamentoId, @ApiParam(name = "corpo", value = "Representação de uma forma de pagamento com os novos dados", required = true) FormaPagamentoInput formaPagamantoInput);
	
	@ApiOperation("Exclui uma forma de pagamento por ID")
	@ApiResponses({@ApiResponse(code = 204, message = "Forma de pagamento excluída"), @ApiResponse(code = 404, message = "Forma de pagamento não encontrado", response = Problem.class)})
	public void remover(@ApiParam(value = "ID de uma forma de pagamento", example = "1", required = true) Long formaPagamentoId);
}
