package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.Category;
import com.capgemini.HEAR.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    ICategoryRepository categoryRepository;

    @GetMapping("/all")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    //get id
    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable int id) {

        return categoryRepository.findById(id).isPresent() ? categoryRepository.findById(id).get() : null;
    }

    @PostMapping("/edit")
    public Category editCategory(Category category) {
        return categoryRepository.save(category);
    }

    //delete
    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id) {

        System.out.println("try to delete");

        categoryRepository.deleteById(id);
    }

}
