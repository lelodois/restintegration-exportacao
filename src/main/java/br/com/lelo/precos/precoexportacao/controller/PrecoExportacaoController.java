package br.com.lelo.precos.precoexportacao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.precos.precoexportacao.business.PrecoExportacaoBusiness;

@RestController
@RequestMapping("precos-exportacao")
public class PrecoExportacaoController {

	@Autowired
	private PrecoExportacaoBusiness business;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@PutMapping(value = "exportar/{id}")
	public void exportar(@PathVariable String id) throws Exception {
		log.info(" \n*********** inicio *************\n");
		log.info(id);

		business.exportar(id);

		log.info(" \n************** fim *************\n");
	}

}
