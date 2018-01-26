package br.com.lelo.precos.precoexportacao.message;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lelo.precos.precoexportacao.model.PrecoExportacao;

public class PrecoExportacaoMessageSerializer implements Serializer<PrecoExportacao> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(String topic, PrecoExportacao data) {
		try {
			return objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() {
	}

}
