package com.slizokav.MusicToolsRestApi.service;

import com.slizokav.MusicToolsRestApi.model.Person;
import com.slizokav.MusicToolsRestApi.model.Tool;
import com.slizokav.MusicToolsRestApi.repositories.PersonRepository;
import com.slizokav.MusicToolsRestApi.repositories.ToolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToolService {

    private final ToolRepository toolRepository;
    private final PersonRepository personRepository;

    public ToolService(ToolRepository toolRepository, PersonRepository personRepository) {
        this.toolRepository = toolRepository;
        this.personRepository = personRepository;
    }

    // Создать инструмент и присвоить ему владельца
    public void createTool(Tool tool) {
        toolRepository.save(tool);
    }

    // Удаление инструмента по его id
    public void deleteTool(int id) {
        toolRepository.deleteById(id);
    }

    // Добавить владельца к существующему инструменту
    public void addPerson(int id, String username) {
        Tool tools = toolRepository.findById(id).get();
        Person person = personRepository.findByUsername(username).get();
        tools.setPerson(person);

        List<Tool> toolsList;
        if (person.getToolsList() == null) {
            toolsList = new ArrayList<>();
        } else {
            toolsList = person.getToolsList();
        }
        toolsList.add(tools);
        person.setToolsList(toolsList);
    }

    // Получение всего списка инструментов
    public List<Tool> getTools() {
        return toolRepository.findAll();
    }

    // Обновление инструмента
    public void update(int id, String toolName, int cost) {
        Tool oldTool = toolRepository.findById(id).get();
        oldTool.setTool_name(toolName);
        oldTool.setCost(cost);
        toolRepository.save(oldTool);
    }
}
