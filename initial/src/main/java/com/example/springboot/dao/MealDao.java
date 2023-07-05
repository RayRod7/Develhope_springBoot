package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDao {
    private List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal){
        this.meals.add(meal);
    }

    public void deleteMeal(String mealName){
        for(Meal m : meals){
            if (m.getName().equals(mealName)){
                meals.remove(m);
            }
        }
    }

    public void updateMeal(Meal meal){
        for(Meal m : meals){
            if (m.getName().equals(meal.getName())){
                meals.remove(m);
                this.meals.add(meal);
            }
        }
    }

    public List<Meal> getMeals(){
        return this.meals;
    }
}
