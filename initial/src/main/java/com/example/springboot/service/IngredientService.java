package com.example.springboot.service;

import com.example.springboot.model.Ingredient;
import com.example.springboot.dao.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long id) {
        try {
            return ingredientRepository.findById(id).orElseThrow();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient updateIngredient(Long id, Ingredient updatedIngredient) {
        Ingredient existingIngredient;
        try {
            existingIngredient = ingredientRepository.findById(id).orElseThrow();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        existingIngredient.setName(updatedIngredient.getName());
        existingIngredient.setIsVegetarian(updatedIngredient.getIsVegetarian());
        existingIngredient.setIsVegan(updatedIngredient.getIsVegan());
        existingIngredient.setIsGlutenFree(updatedIngredient.getIsGlutenFree());
        existingIngredient.setIsLactoseFree(updatedIngredient.getIsLactoseFree());

        return ingredientRepository.save(existingIngredient);
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

}