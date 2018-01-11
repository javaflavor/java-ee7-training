package com.redhat.example.commons.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.example.commons.annotation.Candidate;
import com.redhat.example.model.ClientHost;
import com.redhat.example.model.ClientHostImpl;

@Dependent
public class ClientHostFactory {
	@Inject Logger log;

	@Inject
	@Candidate
	Instance<ClientHost> candidates;

	@Produces
	@Named("clientHost")
	public ClientHost getClientHost() {
		if (!candidates.isAmbiguous() && !candidates.isUnsatisfied()) {
			return candidates.get();
		} else {
			List<ClientHost> defaults = new ArrayList<>();
			List<ClientHost> others = new ArrayList<>();
			candidates.forEach(host -> {
				if (host instanceof ClientHostImpl) {
					defaults.add(host);
				} else {
					others.add(host);
				}
			});
			if (others.size() == 0) {
				// デフォルト以外の候補がいなければ、デフォルトを返す。
				return defaults.get(0);
			}
			if (others.size() == 1) {
				// デフォルト以外の候補が１つだけであれば、それを返す。
				return others.get(0);
			} else {
				throw new IllegalStateException(String.format("%s is unsatisfied or ambiguous. defaults=%s, others=%s",
						ClientHost.class.getSimpleName(), defaults, others));
			}
		}
	}

}
