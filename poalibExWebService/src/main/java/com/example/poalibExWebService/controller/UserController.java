package com.example.poalibExWebService.controller;

import com.example.poalibExWebService.dataservice.AddressConstants;
import com.example.poalibExWebService.dataservice.PersonDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import viewmodel.Person;
import viewmodel.ResultWithSuccess;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(AddressConstants.personEndPoint)
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private PersonDataService personDataService;

    @RequestMapping(method = RequestMethod.GET, value = AddressConstants.findALL)
    public ResponseEntity<List<Person>> findAll() {
        try {
            List<Person> all = personDataService.getAllPeople();
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        catch (Exception e)
        {
            logger.error("error to get users:"+e.toString());
            List<Person> people=new ArrayList<>();
            Person person=new Person();
            person.setSaveResult(new ResultWithSuccess<>(false,e.toString()));
            people.add(person);
            return new ResponseEntity<>(people, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @RequestMapping(method = RequestMethod.GET, value = AddressConstants.findByPrefix)
    public ResponseEntity<List<Person>> findByPrefix() {
        try {
            List<Person> personsAnK = personDataService.getpersonaAnK();
            return new ResponseEntity<>(personsAnK, HttpStatus.OK);
        }
        catch (Exception e)
        {
            logger.error("error to get users by prefix:"+e.toString());
            List<Person> people=new ArrayList<>();
            Person person=new Person();
            person.setSaveResult(new ResultWithSuccess<>(false,e.toString()));
            people.add(person);
            return new ResponseEntity<>(people, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = AddressConstants.findFatPeopleInIsrael)
    public ResponseEntity<List<Person>> findFatPeopleInIsrael() {
        try {
            List<Person> personsAnK = personDataService.getFatManInIsrael();
            return new ResponseEntity<>(personsAnK, HttpStatus.OK);
        }
        catch (Exception e)
        {
            logger.error("error to get fat users in israel:"+e.toString());
            List<Person> people=new ArrayList<>();
            Person person=new Person();
            person.setSaveResult(new ResultWithSuccess<>(false,e.toString()));
            people.add(person);
            return new ResponseEntity<>(people, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
