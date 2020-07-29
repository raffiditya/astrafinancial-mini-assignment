package id.co.astrafinancial.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// this is to disable default login page from spring security
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OauthApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OauthApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OauthApp.class);
    }
}
