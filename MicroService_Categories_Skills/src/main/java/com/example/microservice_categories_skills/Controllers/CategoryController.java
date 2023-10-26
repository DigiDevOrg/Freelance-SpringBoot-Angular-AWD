package com.example.microservice_categories_skills.Controllers;

import com.example.microservice_categories_skills.Entity.Category;
import com.example.microservice_categories_skills.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Get all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Create a new category
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    // Get a single category by ID
       @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long categoryId) {
           Category category = categoryRepository.findById(categoryId).get();
           return category;
       }
    // Update a category by ID
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable(value = "id") Long categoryId, @RequestBody Category categoryDetails) {
        Category category = categoryRepository.findById(categoryId).get();
        category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription());
        Category updatedCategory = categoryRepository.save(category);
        return updatedCategory;
    }

    // Delete a category by ID
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
       Category category = categoryRepository.findById(id).get();
        if (category.getName() != null) {
            categoryRepository.delete(category);
        } else {
            System.out.println("Category not found");
        }
    }

    // Search for categories by name

   // @GetMapping("/search")
    //public List<Category> searchCategories(@RequestParam(value = "name") String name) {
      //  List<Category> categories = categoryRepository.findByName(name);
       // return categories;
   // }
}

