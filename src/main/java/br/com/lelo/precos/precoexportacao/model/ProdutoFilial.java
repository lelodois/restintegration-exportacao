package br.com.lelo.precos.precoexportacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoFilial {

	private Long produto;
	private Long filial;
	private boolean pesavel;
	private boolean precoReplicador;

	public Long getFilial() {
		return filial;
	}

	public Long getProduto() {
		return produto;
	}

	public boolean isPesavel() {
		return pesavel;
	}

	public boolean isPrecoReplicador() {
		return precoReplicador;
	}

	public void setFilial(Long filial) {
		this.filial = filial;
	}

	public void setPesavel(boolean pesavel) {
		this.pesavel = pesavel;
	}

	public void setPrecoReplicador(boolean precoReplicador) {
		this.precoReplicador = precoReplicador;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

}
