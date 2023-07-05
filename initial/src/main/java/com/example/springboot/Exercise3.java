package com.example.springboot;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
@RestController
public class Exercise3 {

    List<Meal> mealList = new ArrayList<>();

    @GetMapping("/get/mealList")
    public ResponseEntity<?> getMeals() {
        if(mealList.size() < 1){
            return ResponseEntity.ok("The meal list is empty!");
        }
            return ResponseEntity.ok(mealList);
    }



    //Exercise 3.1
    @PutMapping("/put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        this.mealList.add(meal);
        return ResponseEntity.ok("Meal added!");
    }



    //Exercise 3.2
    @PostMapping("/post/meal/{name}")
    public ResponseEntity<?> updateMealByName (@PathVariable String name, @RequestBody Meal updatedMeal){
        for (Meal m : mealList){
            if(m.getName().equals(name)){
                m.setName(updatedMeal.getName());
                m.setDescription(updatedMeal.getDescription());
                m.setPrice(updatedMeal.getPrice());
                return ResponseEntity.ok("Meal updated");
            }
        }
        return ResponseEntity.notFound().build();
    }



    //Exercise 3.3
    @DeleteMapping("/delete/meal/{mealName}")
    public ResponseEntity<?> deleteMeal(@PathVariable String mealName){
        for(Meal m : mealList){
            if (m.getName().equals(mealName)){
                mealList.remove(m);
                return ResponseEntity.ok("Meal Deleted");
            }
        }
        return ResponseEntity.notFound().build();
    }



    //Exercise 3.4
    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<?> deleteMealByPrice(@PathVariable Double price){
        List<Meal> mealsToDelete = new ArrayList<>();

        for(Meal m : mealList){
            if (m.getPrice() > price){
                mealsToDelete.add(m);

                mealList.removeAll(mealsToDelete);
                return ResponseEntity.ok("Meal Deleted");
            }
        }

        return ResponseEntity.notFound().build();
    }



    //Exercise 3.5
    @PutMapping("/meal/{name}/price")
    public ResponseEntity<?> updateMealPrice(@PathVariable String name, @RequestBody Double price){
        for(Meal m : mealList){
            if(m.getName().equals(name)){
                m.setPrice(price);
                return  ResponseEntity.ok("Meal updated");
            }
        }
        return ResponseEntity.notFound().build();
    }

}
*/
