package com.example.poalibExWebService.dataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import viewmodel.FindCreteria;
import viewmodel.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PersonDataService {

    private static final Logger logger = LoggerFactory.getLogger(PersonDataService.class);

    private final RestTemplate restTemplate;

    private final HttpHeaders headers;

    private List<Person> fatManInIsrael;

    private List<Person> personaAnK;


    public PersonDataService() {
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
        this.headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        fatManInIsrael = new ArrayList<>();
        personaAnK = new ArrayList<>();
    }

    public List<Person> getAllPeople() {
        logger.info("get all person");
        ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(
                AddressConstants.personEndService + AddressConstants.findALL,
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                new ParameterizedTypeReference<List<Person>>() {
                });
        fatManInIsrael = responseEntity.getBody();
        return fatManInIsrael;

    }

    public List<Person> getFatManInIsrael() {
        logger.info("get all fat people from israel");
        ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(
                AddressConstants.personEndService + AddressConstants.findFatPeopleInIsrael,
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                new ParameterizedTypeReference<List<Person>>() {
                });
        fatManInIsrael = responseEntity.getBody();
        return fatManInIsrael;

    }

    public List<Person> getpersonaAnK() {
        logger.info("get all  people their name start with a or k");
        List<String> prefix = new ArrayList<>();
        prefix.add("a");
        prefix.add("k");
        FindCreteria FindCreteria = new FindCreteria(prefix);
        ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(
                AddressConstants.personEndService + AddressConstants.findByPrefix,
                HttpMethod.GET,
                new HttpEntity<>(FindCreteria, headers),
                new ParameterizedTypeReference<List<Person>>() {
                });
        personaAnK = responseEntity.getBody();
        return personaAnK;
    }
}
