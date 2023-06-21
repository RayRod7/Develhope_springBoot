package com.example.springboot;

import model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Exercise 2.1

@RestController
public class Exercise2 {
    List<Meal> mealList = Arrays.asList(
            new Meal("Mediterranean Delight",
                    "Grilled chicken marinated in aromatic herbs, served with a bed of fluffy couscous, roasted vegetables, and a tangy tzatziki sauce.",
                    14.99),
            new Meal("Thai Curry Fusion",
                    "Tender shrimp simmered in a creamy coconut curry sauce with lemongrass, ginger, and a hint of spice.",
                    12.99),
            new Meal("Savory Steakhouse Burger",
                    "Juicy grilled beef patty topped with melted cheese, crispy bacon, fresh lettuce, and tangy BBQ sauce. Served with seasoned fries.",
                    10.99),
            new Meal("Veggie Fiesta Bowl",
                    "A colorful bowl packed with black beans, roasted corn, diced tomatoes, avocado, and a zesty lime-cilantro dressing.",
                    9.99),
            new Meal("Teriyaki Salmon Stir-Fry",
                    "Succulent salmon fillet glazed with teriyaki sauce, served over a bed of stir-fried vegetables and steamed jasmine rice.",
                    14.99),
            new Meal("Classic Margherita Pizza",
                    "Thin crust pizza topped with ripe tomatoes, fresh basil leaves, and mozzarella cheese.",
                    11.99),
            new Meal("Spicy Szechuan Noodles",
                    "Stir-fried noodles tossed in a fiery Szechuan sauce with bell peppers, mushrooms, and tender strips of chicken.",
                    13.99)

    );

    @GetMapping("/meals")
    public ResponseEntity<?> allMeals() {
        return ResponseEntity.ok(mealList);
    }
}

//Exercise 2.2

@RestController
class MealByNameController {
    List<Meal> mealList = Arrays.asList(
            new Meal("Mediterranean Delight",
                    "Grilled chicken marinated in aromatic herbs, served with a bed of fluffy couscous, roasted vegetables, and a tangy tzatziki sauce.",
                    14.99),
            new Meal("Thai Curry Fusion",
                    "Tender shrimp simmered in a creamy coconut curry sauce with lemongrass, ginger, and a hint of spice.",
                    12.99),
            new Meal("Savory Steakhouse Burger",
                    "Juicy grilled beef patty topped with melted cheese, crispy bacon, fresh lettuce, and tangy BBQ sauce. Served with seasoned fries.",
                    10.99),
            new Meal("Veggie Fiesta Bowl",
                    "A colorful bowl packed with black beans, roasted corn, diced tomatoes, avocado, and a zesty lime-cilantro dressing.",
                    9.99),
            new Meal("Teriyaki Salmon Stir-Fry",
                    "Succulent salmon fillet glazed with teriyaki sauce, served over a bed of stir-fried vegetables and steamed jasmine rice.",
                    14.99),
            new Meal("Classic Margherita Pizza",
                    "Thin crust pizza topped with ripe tomatoes, fresh basil leaves, and mozzarella cheese.",
                    11.99),
            new Meal("Spicy Szechuan Noodles",
                    "Stir-fried noodles tossed in a fiery Szechuan sauce with bell peppers, mushrooms, and tender strips of chicken.",
                    13.99)

    );

    @GetMapping("/meal/{name}")
    public ResponseEntity<?> getMealByName(@PathVariable("name") String name) {
        List<Meal> selectedMealsByName = new ArrayList<>();
        for (Meal meal : mealList) {
            if (meal.getName().toLowerCase().contains(name)) {
                selectedMealsByName.add(meal);
            }
        }
        return ResponseEntity.ok(selectedMealsByName);
    }
}

//Exercise 2.3

@RestController
class MealByDescriptionController {
    List<Meal> mealList = Arrays.asList(
            new Meal("Mediterranean Delight",
                    "Grilled chicken marinated in aromatic herbs, served with a bed of fluffy couscous, roasted vegetables, and a tangy tzatziki sauce.",
                    14.99),
            new Meal("Thai Curry Fusion",
                    "Tender shrimp simmered in a creamy coconut curry sauce with lemongrass, ginger, and a hint of spice.",
                    12.99),
            new Meal("Savory Steakhouse Burger",
                    "Juicy grilled beef patty topped with melted cheese, crispy bacon, fresh lettuce, and tangy BBQ sauce. Served with seasoned fries.",
                    10.99),
            new Meal("Veggie Fiesta Bowl",
                    "A colorful bowl packed with black beans, roasted corn, diced tomatoes, avocado, and a zesty lime-cilantro dressing.",
                    9.99),
            new Meal("Teriyaki Salmon Stir-Fry",
                    "Succulent salmon fillet glazed with teriyaki sauce, served over a bed of stir-fried vegetables and steamed jasmine rice.",
                    14.99),
            new Meal("Classic Margherita Pizza",
                    "Thin crust pizza topped with ripe tomatoes, fresh basil leaves, and mozzarella cheese.",
                    11.99),
            new Meal("Spicy Szechuan Noodles",
                    "Stir-fried noodles tossed in a fiery Szechuan sauce with bell peppers, mushrooms, and tender strips of chicken.",
                    13.99)

    );


    @GetMapping("/meal/description-match/{phrase}")
    public ResponseEntity<?> getMealByDescription(@PathVariable("phrase") String phrase) {
        List<Meal> selectedMealsByPhrase = new ArrayList<>();
        for (Meal meal : mealList) {
            if (meal.getDescription().toLowerCase().contains(phrase)) {
                selectedMealsByPhrase.add(meal);
            }
        }
        return ResponseEntity.ok(selectedMealsByPhrase);
    }
}

//Exercise 2.4

@RestController
class MealByPrice {
    List<Meal> mealList = Arrays.asList(
            new Meal("Mediterranean Delight",
                    "Grilled chicken marinated in aromatic herbs, served with a bed of fluffy couscous, roasted vegetables, and a tangy tzatziki sauce.",
                    14.99),
            new Meal("Thai Curry Fusion",
                    "Tender shrimp simmered in a creamy coconut curry sauce with lemongrass, ginger, and a hint of spice.",
                    12.99),
            new Meal("Savory Steakhouse Burger",
                    "Juicy grilled beef patty topped with melted cheese, crispy bacon, fresh lettuce, and tangy BBQ sauce. Served with seasoned fries.",
                    10.99),
            new Meal("Veggie Fiesta Bowl",
                    "A colorful bowl packed with black beans, roasted corn, diced tomatoes, avocado, and a zesty lime-cilantro dressing.",
                    9.99),
            new Meal("Teriyaki Salmon Stir-Fry",
                    "Succulent salmon fillet glazed with teriyaki sauce, served over a bed of stir-fried vegetables and steamed jasmine rice.",
                    14.99),
            new Meal("Classic Margherita Pizza",
                    "Thin crust pizza topped with ripe tomatoes, fresh basil leaves, and mozzarella cheese.",
                    11.99),
            new Meal("Spicy Szechuan Noodles",
                    "Stir-fried noodles tossed in a fiery Szechuan sauce with bell peppers, mushrooms, and tender strips of chicken.",
                    13.99)

    );

    @GetMapping("/meal/price")
    public ResponseEntity<?> getMealByPrice
            (@RequestParam("min") double min,
             @RequestParam("max") double max) {
        List<Meal> mealByPrice = new ArrayList<>();
        for (Meal meal : mealList) {
            if (meal.getPrice() >= min && meal.getPrice() <= max) {
                mealByPrice.add(meal);
            }
        }
        return ResponseEntity.ok(mealByPrice);
    }

}
