package br.com.lelo.precos.precoexportacao.message;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lelo.precos.precoexportacao.model.PrecoExportacao;

public class PrecoExportacaoMessageDesserializer implements Deserializer<PrecoExportacao> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public PrecoExportacao deserialize(String arg0, byte[] arg1) {
		try {
			return objectMapper.readValue(arg1, PrecoExportacao.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() {
	}

}
