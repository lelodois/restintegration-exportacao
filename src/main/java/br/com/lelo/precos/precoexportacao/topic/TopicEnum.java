package br.com.lelo.precos.precoexportacao.topic;

import java.util.List;

import org.assertj.core.util.Lists;

import br.com.lelo.precos.precoexportacao.model.ProdutoFilial;

public enum TopicEnum {

	TOPIC_PDV {
		protected void add(List<TopicEnum> topics, ProdutoFilial prodFilial) {
			topics.add(this);
		}
	},
	TOPIC_BALANCA {
		protected void add(List<TopicEnum> topics, ProdutoFilial prodFilial) {
			if (prodFilial.isPesavel()) {
				topics.add(this);
			}
		}
	},
	TOPIC_REPLICADOR {
		protected void add(List<TopicEnum> topics, ProdutoFilial prodFilial) {
			if (prodFilial.isPrecoReplicador()) {
				topics.add(this);
			}
		}
	};

	public static List<TopicEnum> getTopics(ProdutoFilial prodFilial) {
		List<TopicEnum> topics = Lists.newArrayList();
		for (TopicEnum topicEnum : TopicEnum.values()) {
			topicEnum.add(topics, prodFilial);
		}
		return topics;
	}

	protected abstract void add(List<TopicEnum> topics, ProdutoFilial prodFilial);

	public final String getTopicName() {
		return this.name().toLowerCase();
	}

}
