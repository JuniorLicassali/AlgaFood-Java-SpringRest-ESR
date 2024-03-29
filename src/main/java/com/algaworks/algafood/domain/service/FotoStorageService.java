package com.algaworks.algafood.domain.service;

import java.io.InputStream;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
<<<<<<< HEAD

public interface FotoStorageService {
	
	InputStream recuperar(String nomeArquivo);
=======
import lombok.Setter;

public interface FotoStorageService {
	
	FotoRecuperada recuperar(String nomeArquivo);
>>>>>>> 6001a32eb4cbf62235d3aba2d18fb73a2fe767d4

	void armazenar(NovaFoto novaFoto);
	
	void remover(String nomeArquivo);
	
	default void substituir(String nomeArquivoAntigo, NovaFoto novaFoto) {
		this.armazenar(novaFoto);
		
		if (nomeArquivoAntigo != null) {
			this.remover(nomeArquivoAntigo);
		}
	}
	
	default String gerarNomeArquivo(String nomeOriginal) {
		return UUID.randomUUID().toString() + "_" + nomeOriginal;
	}
	
	@Builder
	@Getter
	class NovaFoto {
		private String nomeArquivo;
<<<<<<< HEAD
		private InputStream inputStream;
	}
=======
		private String ContentType;
		private InputStream inputStream;
	}
	
	@Builder
	@Getter
	class FotoRecuperada {
		private InputStream inputStream;
		private String url;
		
		public boolean temUrl() {
			return url != null;
		}
		
		public boolean temInputStream() {
			return inputStream != null;
		}
	}
>>>>>>> 6001a32eb4cbf62235d3aba2d18fb73a2fe767d4
}
