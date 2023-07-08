package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealController {
    private MealService mealService;

    @Autowired
    public  MealController(MealService mealService){
        this.mealService = mealService;
    }

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping(value = "/put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        try {
            mealService.addMeal((meal));
            return ResponseEntity.ok("Meal added");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/meal/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable String mealName){
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted");
    }

    public final static Double MAX_WINTER_TEMP = 20.00;


    @GetMapping("/meal/winter")
    public ResponseEntity<List<Meal>> getWinterMeals(){
        List<Meal> winterMeals =  mealService.getWinterMeals();
        return ResponseEntity.ok().body(winterMeals);
    }
}
