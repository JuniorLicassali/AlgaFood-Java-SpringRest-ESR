package com.algaworks.algafood.infrastructure.service.storage;

<<<<<<< HEAD
import java.io.IOException;
=======
>>>>>>> 6001a32eb4cbf62235d3aba2d18fb73a2fe767d4
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

<<<<<<< HEAD
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.algaworks.algafood.domain.service.FotoStorageService;

@Service
public class LocalFotoStorageService implements FotoStorageService {
	
	@Value("${algafood.storage.local.diretorio-fotos}")
	private Path diretorioFotos;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.algaworks.algafood.core.storage.StorageProperties;
import com.algaworks.algafood.domain.service.FotoStorageService;

public class LocalFotoStorageService implements FotoStorageService {
	
	@Autowired
	private StorageProperties storageProperties;
>>>>>>> 6001a32eb4cbf62235d3aba2d18fb73a2fe767d4

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
<<<<<<< HEAD
	public InputStream recuperar(String nomeArquivo) {
		Path arquivoPath = getArquivoPath(nomeArquivo);
		try {
			return Files.newInputStream(arquivoPath);
=======
	public FotoRecuperada recuperar(String nomeArquivo) {
		try {
			Path arquivoPath = getArquivoPath(nomeArquivo);
			
			FotoRecuperada fotoRecuperada = FotoRecuperada.builder()
					.inputStream(Files.newInputStream(arquivoPath))
					.build();
			
			return fotoRecuperada;
>>>>>>> 6001a32eb4cbf62235d3aba2d18fb73a2fe767d4
		} catch (Exception e) {
			throw new StorageException("Não foi possível recuperar o arquivo.", e);
		}
	}

	private Path getArquivoPath(String nomeArquivo) {
<<<<<<< HEAD
		return diretorioFotos.resolve(Path.of(nomeArquivo));
=======
		return storageProperties.getLocal().getDiretorioFotos().resolve(Path.of(nomeArquivo));
>>>>>>> 6001a32eb4cbf62235d3aba2d18fb73a2fe767d4
	}



}
