package org.netunion.manager.service.keycloak;

import org.netunion.manager.service.ApiBinding;

public class Keycloak extends ApiBinding {
    private String userInfoEndpointUri;

    public Keycloak(String accessToken, String userInfoEndpointUri) {
        super(accessToken);
        this.userInfoEndpointUri = userInfoEndpointUri;
    }

    public String getProfile() {
        return restTemplate.getForObject(userInfoEndpointUri, String.class);
    }
}
