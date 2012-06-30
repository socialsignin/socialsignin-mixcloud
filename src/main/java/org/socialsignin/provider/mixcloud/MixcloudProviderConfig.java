/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socialsignin.provider.mixcloud;

import org.socialsignin.provider.AbstractProviderConfig;
import org.socialsignin.springsocial.security.MixcloudConnectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.mixcloud.api.Mixcloud;
import org.springframework.social.mixcloud.api.impl.MixcloudTemplate;
import org.springframework.social.mixcloud.connect.MixcloudConnectionFactory;

/** 
* @author Michael Lavelle
*/
@Configuration
public class MixcloudProviderConfig extends AbstractProviderConfig<Mixcloud> {

	@Autowired(required=false)
	private MixcloudConnectInterceptor mixcloudConnectInterceptor;

	@Value("${mixcloud.consumerKey}")
	private String mixcloudConsumerKey;

	@Value("${mixcloud.consumerSecret}")
	private String mixcloudConsumerSecret;

	public MixcloudProviderConfig() {
		super();
	}
	
	public MixcloudProviderConfig(String mixcloudConsumerKey,
			Mixcloud authenticatedApi) {
		super(authenticatedApi);
		this.mixcloudConsumerKey = mixcloudConsumerKey;
	}
	
	public MixcloudProviderConfig(String mixcloudConsumerKey,String accessToken) {
		super(new MixcloudTemplate(accessToken));
		this.mixcloudConsumerKey = mixcloudConsumerKey;
	}
	
	public MixcloudProviderConfig(String mixcloudConsumerKey,String mixcloudConsumerSecret,ConnectionRepository connectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(connectionRepository, connectionFactoryRegistry);
		this.mixcloudConsumerSecret = mixcloudConsumerSecret;
		this.mixcloudConsumerSecret  = mixcloudConsumerSecret;
	}

	public MixcloudProviderConfig(String mixcloudConsumerKey,String mixcloudConsumerSecret,ConnectionRepository connectionRepository,
			UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(connectionRepository, usersConnectionRepository,
				connectionFactoryRegistry);
		this.mixcloudConsumerKey = mixcloudConsumerSecret;
		this.mixcloudConsumerSecret  = mixcloudConsumerSecret;
	}
	
	public MixcloudProviderConfig(String mixcloudConsumerKey,String mixcloudConsumerSecret,String userId,	UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(userId,usersConnectionRepository,
				connectionFactoryRegistry);
		this.mixcloudConsumerKey = mixcloudConsumerKey;
		this.mixcloudConsumerSecret  = mixcloudConsumerSecret;
	}
	
	
	
	public void setMixcloudConsumerKey(String mixcloudConsumerKey) {
		this.mixcloudConsumerKey = mixcloudConsumerKey;
	}

	public void setMixcloudConsumerSecret(String mixcloudConsumerSecret) {
		this.mixcloudConsumerSecret = mixcloudConsumerSecret;
	}

	@Override
	protected ConnectionFactory<Mixcloud> createConnectionFactory() {
		return new MixcloudConnectionFactory(mixcloudConsumerKey,
				mixcloudConsumerSecret);
	}

	@Override
	protected ConnectInterceptor<Mixcloud> getConnectInterceptor() {
		return mixcloudConnectInterceptor;
	}

	@Override
	public Class<Mixcloud> getApiClass() {
		return Mixcloud.class;
	}

}
