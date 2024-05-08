package com.slizokav.MusicToolsRestApi.controlers;

import com.slizokav.MusicToolsRestApi.dto.ToolDto;
import com.slizokav.MusicToolsRestApi.dto.response.BodyResponse;
import com.slizokav.MusicToolsRestApi.repositories.PersonRepository;
import com.slizokav.MusicToolsRestApi.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToolController {

    private final ToolService toolService;

    @Autowired
    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/tool")
    public ResponseEntity<?> getTools() {
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), toolService.getTools().toString()), HttpStatus.OK);
    }

    @PostMapping("/tool")
    public ResponseEntity<?> create(@RequestBody ToolDto toolDto) {
        toolService.create(toolDto.getToolName(), toolDto.getCost());
        return new ResponseEntity<>(new BodyResponse(HttpStatus.CREATED.toString(), toolDto.getToolName() + " успешно добавлен"), HttpStatus.CREATED);
    }

    @DeleteMapping("/tool/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        toolService.delete(id);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), "Инструмент с id: " + id + "успешно удален"), HttpStatus.OK);
    }

    @PutMapping("/tool/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody ToolDto toolDto) {
        toolService.update(id, toolDto.getToolName(), toolDto.getCost());
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), "Инструмент с id: " + id + "успешно обновлен"), HttpStatus.OK);
    }

    @PostMapping("/addPerson/{id}")
    public ResponseEntity<?> addPerson(@PathVariable int id, @RequestBody String username) {
        toolService.addPerson(id, username);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.CREATED.toString(), "Инструмент с id: " + id + " присвоен пользователю: " + username), HttpStatus.CREATED);
    }

    @PostMapping("/addBrand/{id}")
    public ResponseEntity<?> addBrand(@PathVariable int id, @RequestBody String brandName) {
        toolService.addBrand(id, brandName);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.CREATED.toString(), "Инструмент с id: " + id + " присвоен бренду: " + brandName), HttpStatus.CREATED);
    }

}


