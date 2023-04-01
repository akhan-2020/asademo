package com.example.asa.asademo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
public class ApiController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;



    //hello world endpoint
    public String helloWorld() {
        return "Hello World!";
    }

    //endpoint that takes name as a parameter
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        // file deepcode ignore XSS: <please specify a reason of ignoring this>
        return "Hello " + name + "!";
    }

    //endpoint that returns the app name and version
    @GetMapping("/version")
    public String version() {
        return appName + " " + appVersion;
    }

  
}
