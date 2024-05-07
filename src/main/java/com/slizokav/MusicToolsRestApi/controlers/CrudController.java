package com.slizokav.MusicToolsRestApi.controlers;

import com.slizokav.MusicToolsRestApi.dto.response.BodyResponse;
import com.slizokav.MusicToolsRestApi.dto.PersonDto;
import com.slizokav.MusicToolsRestApi.model.Person;
import com.slizokav.MusicToolsRestApi.security.JWTUtil;
import com.slizokav.MusicToolsRestApi.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {
    private final PersonService personService;
    private final JWTUtil jwtUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CrudController(PersonService personService, JWTUtil jwtUtil, ModelMapper modelMapper) {
        this.personService = personService;
        this.jwtUtil = jwtUtil;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/test")
    public String mainPage() {
        return "test";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin response";
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody PersonDto personDto) {
        Person person = convertPersonDtoToPerson(personDto);
        personService.create(person);
        String jwt = "Token: " + jwtUtil.generateToken(person.getUsername());

        return new ResponseEntity<>(new BodyResponse(HttpStatus.CREATED.toString(), jwt), HttpStatus.CREATED);
    }

    public Person convertPersonDtoToPerson(PersonDto personDto) {
        return modelMapper.map(personDto, Person.class);
    }
}