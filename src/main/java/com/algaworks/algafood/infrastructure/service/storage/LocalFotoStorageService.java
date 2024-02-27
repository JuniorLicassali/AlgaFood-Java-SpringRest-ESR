package com.algaworks.algafood.infrastructure.service.storage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.algaworks.algafood.domain.service.FotoStorageService;

@Service
public class LocalFotoStorageService implements FotoStorageService {
	
	@Value("${algafood.storage.local.diretorio-fotos}")
	private Path diretorioFotos;

	@Override
	public void armazenar(NovaFoto novaFoto) {
		
		
		try {
			Path arquivoPath = getArquivoPath(novaFoto.getNomeArquivo());
			
			FileCopyUtils.copy(novaFoto.getInputStream(), Files.newOutputStream(arquivoPath));
		} catch (Exception e) {
			throw new StorageException("Não foi possivel armazenar arquivo.", e);
		}
	}
	
	@Override
	public void remover(String nomeArquivo) {

		try {
			Path arquivoPath = getArquivoPath(nomeArquivo);
			
			Files.delete(arquivoPath);
		} catch (Exception e) {
			throw new StorageException("Não foi possivel excluir arquivo.", e);
		}
	}
	
	@Override
	public InputStream recuperar(String nomeArquivo) {
		Path arquivoPath = getArquivoPath(nomeArquivo);
		try {
			return Files.newInputStream(arquivoPath);
		} catch (Exception e) {
			throw new StorageException("Não foi possível recuperar o arquivo.", e);
		}
	}

	private Path getArquivoPath(String nomeArquivo) {
		return diretorioFotos.resolve(Path.of(nomeArquivo));
	}



}
