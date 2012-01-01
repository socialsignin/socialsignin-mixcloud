package org.socialsignin.provider.mixcloud;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.social.mixcloud.api.Mixcloud;
import org.springframework.social.mixcloud.api.impl.MixcloudTemplate;
import org.springframework.stereotype.Service;

@Service
public class MixcloudProviderService extends AbstractProviderService<Mixcloud> {

	@Override
	public Class<Mixcloud> getApiClass() {
		return Mixcloud.class;
	}

	@Override
	public Mixcloud getUnauthenticatedApi() {
		return new MixcloudTemplate();
	}

}
