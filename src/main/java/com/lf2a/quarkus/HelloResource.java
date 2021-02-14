package com.lf2a.quarkus;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @Inject
    HelloService helloService;

    @ConfigProperty(name = "linguagem.programacao", defaultValue = "Java")
    String linguagemDeProgramacao;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String helloName(@PathParam String name) {
        return helloService.hello(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        System.out.println("Aplicação feita em: " + linguagemDeProgramacao);

        String username = ConfigProvider.getConfig().getValue("github.username", String.class);
        System.out.println("Meu perfil no github: http://github.com/" + username);

        return "Olá Mundo!";
    }
}