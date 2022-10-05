package com.devsuperior.dscatalog.sevices;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list =  repository.findAll();

        List<CategoryDTO> listDto = list.stream().map(el -> new CategoryDTO(el)).collect(Collectors.toList());

        return listDto;

//        // Forma de conversão
//        List<CategoryDTO> listDto = new ArrayList<>();
//
//        for (Category category : list) {
//            listDto.add(new CategoryDTO(category));
//        }
//
//        return listDto;
//        // Fim Forma de conversão
    }
}
