package com.slizokav.MusicToolsRestApi.controlers;

import com.slizokav.MusicToolsRestApi.dto.ToolDto;
import com.slizokav.MusicToolsRestApi.dto.response.BodyResponse;
import com.slizokav.MusicToolsRestApi.model.Person;
import com.slizokav.MusicToolsRestApi.model.Tool;
import com.slizokav.MusicToolsRestApi.repositories.PersonRepository;
import com.slizokav.MusicToolsRestApi.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToolController {

    private final ToolService toolService;
    private final PersonRepository personRepository;

    @Autowired
    public ToolController(ToolService toolService, PersonRepository personRepository) {
        this.toolService = toolService;
        this.personRepository = personRepository;
    }

    @GetMapping("/tool")
    public ResponseEntity<?> getTools() {
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), toolService.getTools().toString()), HttpStatus.OK);
    }

    @PostMapping("/tool")
    public ResponseEntity<?> create(@RequestBody ToolDto toolDto) {
        toolService.createTool(convertToolsDtoToTools(toolDto));
        return new ResponseEntity<>(new BodyResponse(HttpStatus.CREATED.toString(), toolDto.getTool_name() + " успешно добавлен и присвоен к " + toolDto.getPersonUsername()), HttpStatus.CREATED);
    }

    @DeleteMapping("/tool{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        toolService.deleteTool(id);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), "Инструмент с id: " + id + "успешно удален"), HttpStatus.OK);
    }

    @PutMapping("/tool{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody String toolName, @RequestBody int cost) {
        toolService.update(id, toolName, cost);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), "Инструмент с id: " + id + "успешно обновлен"), HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<?> addPerson(@RequestBody int id, @RequestBody String username) {
        toolService.addPerson(id, username);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.CREATED.toString(), "Инструмент с id: " + id + " присвоен пользователю: " + username), HttpStatus.CREATED);
    }


    public Tool convertToolsDtoToTools(ToolDto toolDto) {
        Person person = personRepository.findByUsername(toolDto.getPersonUsername()).get();
        Tool tools = new Tool();
        tools.setTool_name(toolDto.getTool_name());
        tools.setCost(toolDto.getCost());
        tools.setPerson(person);

        List<Tool> toolsList = person.getToolsList();
        toolsList.add(tools);
        person.setToolsList(toolsList);
        return tools;
    }
}


