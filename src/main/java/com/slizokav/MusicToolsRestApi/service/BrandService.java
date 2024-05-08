package com.slizokav.MusicToolsRestApi.service;

import com.slizokav.MusicToolsRestApi.model.Brand;
import com.slizokav.MusicToolsRestApi.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    // Создать бренд
    public void create(String brandName) {
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brandRepository.save(brand);
    }

    // Удаление бренда по его id
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    // Получение всего списка брендов
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    // / Обновление бренда
    public void update(int id, String brandName) {
        Brand brand = brandRepository.findById(id).get();
        brand.setBrandName(brandName);
        brandRepository.save(brand);
    }
}
