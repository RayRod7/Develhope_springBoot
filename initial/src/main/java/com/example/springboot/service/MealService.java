package com.example.springboot.service;

import com.example.springboot.model.Meal;
import com.example.springboot.dao.MealDao;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.springboot.controller.MealController.MAX_WINTER_TEMP;

@Service
public class MealService {
    private MealDao mealDao;

    @Autowired
    public MealService(MealDao mealDao){
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal){
        if (meal == null) { throw new IllegalArgumentException("Meal cannot be null!");}
        if (meal.getName() == null) {throw new IllegalArgumentException("Meal name cannot be null!");}
        if (meal.getDescription() == null) {throw new IllegalArgumentException("Meal description cannot be null!");}
        if (meal.getPrice() <= 0) {throw new IllegalArgumentException("Meal price cannot be less than zero!");}
        mealDao.addMeal(meal);
    }

    public void deleteMeal(String mealName){
    mealDao.deleteMeal(mealName);
    }

    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);
    }

    public List<Meal> getMeals(){
        return mealDao.getMeals();
    }

    private Double getCurrentTemperatureInCelsius() {
        try {
            JSONObject response =
                    Unirest.get("https://open-meteo.com/en/docs#latitude=40.8762&longitude=14.5195")
                            .asJson().getBody().getObject();

            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Meal> getWinterMeals() {
        List<Meal> meals = getMeals();
        Double currentTemp = getCurrentTemperatureInCelsius();
        List<Meal> winterMeals = new ArrayList<>();
        if (currentTemp < MAX_WINTER_TEMP){
            for (Meal m : meals){
                if(m.getWinterMeal()){
                    winterMeals.add(m);
                }
            }
        }

        return winterMeals;

    }
}
