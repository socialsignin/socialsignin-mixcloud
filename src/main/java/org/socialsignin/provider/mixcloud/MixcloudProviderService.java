package org.socialsignin.provider.mixcloud;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.social.mixcloud.api.Mixcloud;
import org.springframework.social.mixcloud.api.impl.MixcloudTemplate;
import org.springframework.stereotype.Service;

@Service
public class MixcloudProviderService extends AbstractProviderService<Mixcloud,MixcloudProviderConfig> {

	
	public MixcloudProviderService() {
		super();
	}

	public MixcloudProviderService(MixcloudProviderConfig providerConfig) {
		super(providerConfig);
	}

	@Override
	public Mixcloud getUnauthenticatedApi() {
		return new MixcloudTemplate();
	}

}
