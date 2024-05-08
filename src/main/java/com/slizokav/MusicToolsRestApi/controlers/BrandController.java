package com.slizokav.MusicToolsRestApi.controlers;

import com.slizokav.MusicToolsRestApi.dto.response.BodyResponse;
import com.slizokav.MusicToolsRestApi.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brand")
    public ResponseEntity<?> getBrands() {
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), brandService.getBrands().toString()), HttpStatus.OK);
    }

    @PostMapping("/brand")
    public ResponseEntity<?> create(@RequestBody String brandName) {
        brandService.create(brandName);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.CREATED.toString(), brandName + " успешно добавлен"), HttpStatus.CREATED);
    }

    @DeleteMapping("/brand{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        brandService.delete(id);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), "Бренд с id: " + id + "успешно удален"), HttpStatus.OK);
    }

    @PutMapping("/brand{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody String toolName) {
        brandService.update(id, toolName);
        return new ResponseEntity<>(new BodyResponse(HttpStatus.OK.toString(), "Бренд с id: " + id + "успешно обновлен"), HttpStatus.OK);
    }
}
