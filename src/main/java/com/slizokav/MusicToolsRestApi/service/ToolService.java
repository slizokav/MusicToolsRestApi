package com.slizokav.MusicToolsRestApi.service;

import com.slizokav.MusicToolsRestApi.model.Brand;
import com.slizokav.MusicToolsRestApi.model.Person;
import com.slizokav.MusicToolsRestApi.model.Tool;
import com.slizokav.MusicToolsRestApi.repositories.BrandRepository;
import com.slizokav.MusicToolsRestApi.repositories.PersonRepository;
import com.slizokav.MusicToolsRestApi.repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToolService {

    private final ToolRepository toolRepository;
    private final PersonRepository personRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ToolService(ToolRepository toolRepository, PersonRepository personRepository, BrandRepository brandRepository) {
        this.toolRepository = toolRepository;
        this.personRepository = personRepository;
        this.brandRepository = brandRepository;
    }

    // Создать инструмент
    public void create(String toolName, int cost) {
        Tool tool = new Tool();
        tool.setTool_name(toolName);
        tool.setCost(cost);
        toolRepository.save(tool);
    }

    // Удаление инструмента по его id
    public void delete(int id) {
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

    // Добавить бренд к существующему инструменту
    public void addBrand(int id, String brandName) {
        Tool tools = toolRepository.findById(id).get();
        Brand brand = brandRepository.findByBrandName(brandName).get();
        tools.setBrand(brand);

        List<Tool> toolList;
        if (brand.getToolList() == null) {
            toolList = new ArrayList<>();
        } else {
            toolList = brand.getToolList();
        }
        toolList.add(tools);
        brand.setToolList(toolList);
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
