package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.dto.PedidoDTO;
import com.algaworks.algafood.api.v1.dto.PedidoResumoDTO;
import com.algaworks.algafood.api.v1.dto.input.PedidoInput;
import com.algaworks.algafood.domain.filter.PedidoFilter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Pedidos")
public interface PedidoControllerOpenApi {

	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nomes das propriedades para filtrar na resposta, separados por vírgula",
				name = "campos", paramType = "query", type = "string")
	})
	@ApiOperation("Pesquisa os pedidos")
	public PagedModel<PedidoResumoDTO> pesquisar(PedidoFilter filtro, Pageable pageable);

	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nomes das propriedades para filtrar na resposta, separados por vírgula",
				name = "campos", paramType = "query", type = "string")
	})
	@ApiOperation("Busca um pedido por código")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Pedido não encontrado", response = Problem.class)})
	public PedidoDTO buscar(@ApiParam(value = "Código de um pedido", example = "f9981ca4-5a5e-4da3-af04-933861df3e55", required = true) String codigoPedido);
	
	@ApiOperation("Registra um pedido")
	@ApiResponses({@ApiResponse(code = 201, message = "Pedido registrado")})
	public PedidoDTO adicionar(@ApiParam(name = "corpo", value = "Representação de um novo pedido", required = true) PedidoInput pedidoInput);
	
}
