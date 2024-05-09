package com.slizokav.MusicToolsRestApi.controlers;

import com.slizokav.MusicToolsRestApi.dto.response.BodyResponse;
import com.slizokav.MusicToolsRestApi.service.BrandService;
import com.slizokav.MusicToolsRestApi.service.PersonService;
import com.slizokav.MusicToolsRestApi.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private final ToolService toolService;
    private final PersonService personService;
    private final BrandService brandService;

    @Autowired
    public ReportController(ToolService toolService, PersonService personService, BrandService brandService) {
        this.toolService = toolService;
        this.personService = personService;
        this.brandService = brandService;
    }

    @GetMapping("/report")
    public ResponseEntity<?> getReport() {
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), "Отчет по людям: " + personService.getPersons().toString() +
                " Отчет по брендам: " + brandService.getBrands().toString() +
         " Отчет по инструментам: " + toolService.getTools().toString()), HttpStatus.OK);
    }

}
