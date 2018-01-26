package br.com.lelo.precos.precoexportacao;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.lelo.precos.precoexportacao.message.PrecoExportacaoMessageDesserializer;
import br.com.lelo.precos.precoexportacao.message.PrecoExportacaoMessageSerializer;
import br.com.lelo.precos.precoexportacao.model.PrecoExportacao;

@Component
public class PrecoExportacaoProperties {

	private Properties properties = new Properties();

	@Value("${myproperties.kafka.url}")
	private String servers;

	@PostConstruct
	public void inicializar() {
		properties.put("bootstrap.servers", servers);
		properties.put("key.serializer", StringSerializer.class.getCanonicalName());
		properties.put("key.deserializer", StringDeserializer.class.getCanonicalName());

		properties.put("value.serializer", PrecoExportacaoMessageSerializer.class.getCanonicalName());
		properties.put("value.deserializer", PrecoExportacaoMessageDesserializer.class.getCanonicalName());
	}

	public final KafkaProducer<String, PrecoExportacao> createProducer() {
		return new KafkaProducer<String, PrecoExportacao>(properties);
	}

	public final Properties getProperties() {
		return properties;
	}

}
