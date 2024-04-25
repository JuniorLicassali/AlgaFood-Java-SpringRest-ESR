package com.algaworks.algafood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.api.v1.dto.EnderecoDTO;
import com.algaworks.algafood.domain.model.Endereco;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		
//		modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
//			.addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);
		
		
		  var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
		  Endereco.class, EnderecoDTO.class);
		  
		 enderecoToEnderecoModelTypeMap.<String>addMapping( enderecoSrc ->
		  enderecoSrc.getCidade().getEstado().getNome(),(enderecoDTODest, value) ->
		  enderecoDTODest.getCidade().setEstado(value));
		 
		return modelMapper;
	}
	
}
