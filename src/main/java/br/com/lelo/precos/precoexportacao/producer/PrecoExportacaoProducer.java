package br.com.lelo.precos.precoexportacao.producer;

import java.util.List;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import br.com.lelo.precos.precoexportacao.PrecoExportacaoProperties;
import br.com.lelo.precos.precoexportacao.model.PrecoExportacao;
import br.com.lelo.precos.precoexportacao.topic.TopicEnum;

@Component
@ApplicationScope
public class PrecoExportacaoProducer {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private KafkaProducer<String, PrecoExportacao> producer;

	public PrecoExportacaoProducer(@Autowired PrecoExportacaoProperties properties) {
		producer = properties.createProducer();
	}

	public void send(PrecoExportacao message, List<TopicEnum> topics) {

		for (TopicEnum topicName : topics) {
			String topic = topicName.getTopicName();
			log.info("[preco-exportacao] " + topic + " the message : " + message);
			producer.send(new ProducerRecord<String, PrecoExportacao>(topic, message));
		}
	}
}
