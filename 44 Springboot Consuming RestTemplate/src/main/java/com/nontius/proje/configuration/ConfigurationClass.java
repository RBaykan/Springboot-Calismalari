package com.nontius.proje.configuration;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nontius.proje.ProjeApplication;
import com.nontius.proje.domain.Quote;


@Configuration
public class ConfigurationClass{
	

	private static final Logger log = LoggerFactory.getLogger(ConfigurationClass.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		
		return restTemplateBuilder.build();
	}
	
	
	
	@Bean
	@Profile("!test")
	public CommandLineRunner runner(RestTemplate restTemplate) throws Exception {
		
		String api = "http://localhost:8080/api/employee/nameSurname";
		return args -> {
			ResponseEntity<List<Quote>> response = restTemplate.exchange(
                    api,  // API URL'si
                    HttpMethod.GET,  // GET isteği
                    null,  // Body gerekmediği için null geçiyoruz
                    new ParameterizedTypeReference<List<Quote>>() {}  // Dönen veri tipi List<Quote> olacak
            );	log.info(response.toString());
		};
	}
	
	
	

	

}
