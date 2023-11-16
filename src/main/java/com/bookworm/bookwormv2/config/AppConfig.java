package com.bookworm.bookwormv2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//==== This tool is used in a Java Spring Boot application to communicate with other services or APIs over the internet.

//==  Purpose: If different parts of your application need to make HTTP requests (e.g., talk to external APIs), they can just ask Spring for the RestTemplate bean. This makes it easy to reuse code and keeps things organized.


//== Tells spring that this class is the config setting for the application.
@Configuration
public class AppConfig {

    //== A reusbable component in a spring application
    //== a bean is simply a Java object which is created by Spring framework when the application starts.
    //== The purpose of the object can be pretty much anything - a configuration, a service, database connection factory etc. - Spring doesn't really care.
    @Bean
    //== creates and returns a new instance of the RestTemplate class.
    public RestTemplate restTemplate() {
        //== a class provided by Spring for making HTTP requests.
        //== It simplifies communication with RESTful web services.
        return new RestTemplate();
    }

    //== Additional Notes:

    //== By declaring RestTemplate as a bean in a @Configuration class, you're telling Spring, "I want to manage the creation of RestTemplate, and I want it to be available for use in other parts of my app."


}
