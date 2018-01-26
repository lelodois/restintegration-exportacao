package br.com.lelo.precos.precoexportacao.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lelo.precos.precoexportacao.model.PrecoExportacao;
import br.com.lelo.precos.precoexportacao.model.ProdutoFilial;
import br.com.lelo.precos.precoexportacao.producer.PrecoExportacaoProducer;
import br.com.lelo.precos.precoexportacao.repository.PrecoExportacaoRepository;
import br.com.lelo.precos.precoexportacao.topic.TopicEnum;

@Service
public class PrecoExportacaoBusiness {

	@Autowired
	private PrecoExportacaoRepository repository;

	@Autowired
	private PrecoExportacaoProducer producer;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public void exportar(String id) throws Exception {
		log.info("lendo a mensagem do couchdb");
		PrecoExportacao message = repository.getMessage(id);

		log.info("lendo dados do cadastro produto filial");
		ProdutoFilial prodFilial = repository.loadProdutoFilial(message);

		log.info("publicando a mensagem");
		producer.send(message, TopicEnum.getTopics(prodFilial));
	}

}
