package com.algaworks.algafood.api.openapi.model;

import com.algaworks.algafood.api.dto.CozinhaDTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CozinhasDTO")
@Getter
@Setter
public class CozinhasDTOOpenApi extends PagedDTOOpenApi<CozinhaDTO> {

}
