package com.example.demo;

import java.util.stream.Stream;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.example.demo.dao.SocieteRepository;
import com.example.demo.entities.*;

@EnableEurekaClient
@SpringBootApplication
public class ABourseSocieteServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ABourseSocieteServiceApplication.class, args);
		SocieteRepository sr = ctx.getBean(SocieteRepository.class);
		Stream.of("A","B","C").forEach(s->sr.save(new Societe(s)));
		sr.findAll().forEach(s->System.out.println(s.getNomSociete()));
	}
}



