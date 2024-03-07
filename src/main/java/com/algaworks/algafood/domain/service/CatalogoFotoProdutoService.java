package com.algaworks.algafood.domain.service;

import java.io.InputStream;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.FotoProdutoNaoEncontradaException;
import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.repository.ProdutoRepository;
import com.algaworks.algafood.domain.service.FotoStorageService.NovaFoto;

@Service
public class CatalogoFotoProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FotoStorageService fotoStorage;
	
	@Transactional
	public FotoProduto salvar(FotoProduto foto, InputStream dadosArquivo) {
		Long restauranteId = foto.getRestauranteId();
		Long produtoId = foto.getProduto().getId();
		String nomeNovoArquivo = fotoStorage.gerarNomeArquivo(foto.getNomeArquivo());
		String nomeArquivoExistente = null;
		
		Optional<FotoProduto> fotoExistente = produtoRepository.findFotoById(restauranteId, produtoId);
		
		if (fotoExistente.isPresent()) {
			nomeArquivoExistente = fotoExistente.get().getNomeArquivo();
			produtoRepository.delete(fotoExistente.get());
		}
		
		foto.setNomeArquivo(nomeNovoArquivo);
		foto = produtoRepository.save(foto);
		produtoRepository.flush();

<<<<<<< HEAD
		NovaFoto novaFoto = NovaFoto.builder().nomeArquivo(foto.getNomeArquivo()).inputStream(dadosArquivo).build();
=======
		NovaFoto novaFoto = NovaFoto.builder()
				.nomeArquivo(foto.getNomeArquivo())
				.ContentType(foto.getContentType())
				.inputStream(dadosArquivo)
				.build();
>>>>>>> 6001a32eb4cbf62235d3aba2d18fb73a2fe767d4
		
		
		fotoStorage.substituir(nomeArquivoExistente, novaFoto);
		
		return foto;
<<<<<<< HEAD
=======
	}
	
	public FotoProduto buscarOuFalhar(Long restauranteId, Long produtoId) {
		
		return produtoRepository.findFotoById(restauranteId, produtoId)
				.orElseThrow( () -> new FotoProdutoNaoEncontradaException(restauranteId, produtoId));
	}
	
	public void excluir(Long restauranteId, Long produtoId) {
		FotoProduto foto = buscarOuFalhar(restauranteId, produtoId);
		
		produtoRepository.delete(foto);
		produtoRepository.flush();
		
		fotoStorage.remover(foto.getNomeArquivo());
>>>>>>> 6001a32eb4cbf62235d3aba2d18fb73a2fe767d4
	}
}
