package com.tuwaner.controller.client;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class ClientController {

    private static URI getBaseURI() {
        return UriBuilder.fromUri(
                "http://localhost:8080/").build();
    }

    public static void main(String[] args) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource resource = client.resource(getBaseURI());
        System.out.println(getClientResponse(resource));
        System.out.println(getResponse(resource));

    }

    private static String getClientResponse(WebResource resource) {
        return resource.path("greeting").accept(MediaType.APPLICATION_JSON).get(ClientResponse.class)
                .toString();
    }

    private static String getResponse(WebResource resource) {
        return resource.path("greeting").accept(MediaType.APPLICATION_JSON).get(String.class);
    }
}
