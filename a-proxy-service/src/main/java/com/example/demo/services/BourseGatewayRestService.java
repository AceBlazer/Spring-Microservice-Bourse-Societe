package com.example.demo.services;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;

@RestController
public class BourseGatewayRestService {

	@Autowired
	private RestTemplate rt;

	
	
	@RequestMapping(value="/names")
	public Collection<Societe> listSocietes() throws RestClientException {
		ParameterizedTypeReference<Resources<Societe>> responseType = new ParameterizedTypeReference<Resources<Societe>>() { } ;
		return rt.exchange("http://societe-service/societes", HttpMethod.GET, null, responseType).getBody().getContent();
	}
}




class Societe {
	private Long id;
	String nomSociete;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
}
