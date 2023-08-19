package com.api.thesouschefe.dishes.adapter.in;

import com.api.thesouschefe.dishes.application.usecases.CreateNewDishUC;
import com.api.thesouschefe.dishes.application.usecases.DishesUC;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/dishes")
public class DishesRestController {
    private final DishesUC dishesUC;

    @PostMapping("/create")
    public ResponseEntity<?> createDish(@RequestBody CreateNewDishUC.Request request) {
        var response = dishesUC.createNewDish(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAllDishes() {
        var response = dishesUC.getAllDishes();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDishById(@PathVariable("id") UUID id) {
        var response = dishesUC.getDishById(id);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchDishByName(@PathVariable("name") String name) {
        var response = dishesUC.getDishesByName(name);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}
