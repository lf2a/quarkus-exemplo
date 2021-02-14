package com.lf2a.quarkus;

import javax.enterprise.context.ApplicationScoped;

/**
 * <h1>HelloService.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 14/02/2021
 */
@ApplicationScoped
public class HelloService {

    public String hello(String name) {
        return String.format("Olá %s!", name);
    }
}
