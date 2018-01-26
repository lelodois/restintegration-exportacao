package br.com.lelo.precos.precoexportacao.producer;

import java.util.List;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lelo.precos.precoexportacao.PrecoExportacaoProperties;
import br.com.lelo.precos.precoexportacao.model.PrecoExportacao;
import br.com.lelo.precos.precoexportacao.topic.TopicEnum;

@Service
public class PrecoExportacaoProducer {

	@Autowired
	private PrecoExportacaoProperties properties;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public void send(PrecoExportacao message, List<TopicEnum> topics) {

		for (TopicEnum topicName : topics) {
			try (KafkaProducer<String, PrecoExportacao> producer = properties.createProducer()) {
				String topic = topicName.getTopicName();
				log.info("[preco-exportacao] " + topic + " the message : " + message);
				producer.send(new ProducerRecord<String, PrecoExportacao>(topic, message));
			}
		}
	}
}
