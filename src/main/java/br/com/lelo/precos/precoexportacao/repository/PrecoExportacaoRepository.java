package br.com.lelo.precos.precoexportacao.repository;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lelo.precos.precoexportacao.model.PrecoExportacao;
import br.com.lelo.precos.precoexportacao.model.ProdutoFilial;

@Repository
public class PrecoExportacaoRepository {

	@Value("${myproperties.precificacao.url}")
	private String precificacaoUrl;

	@Value("${myproperties.produtofilial.url}")
	private String produtoFilialUrl;

	public PrecoExportacao getMessage(String id) throws Exception {
		String asString = Request.Get(precificacaoUrl + id).execute().returnContent().asString();
		return new ObjectMapper().readValue(asString, PrecoExportacao.class);
	}

	public ProdutoFilial loadProdutoFilial(PrecoExportacao preco) throws Exception {
		String fullUrl = StringUtils.join(produtoFilialUrl, preco.getProduto(), "/", preco.getFilial());
		String asString = Request.Post(fullUrl).execute().returnContent().asString();
		return new ObjectMapper().readValue(asString, ProdutoFilial.class);
	}

}
