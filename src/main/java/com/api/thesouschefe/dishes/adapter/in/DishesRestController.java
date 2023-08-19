package com.api.thesouschefe.dishes.adapter.in;

import com.api.thesouschefe.dishes.application.usecases.CreateNewDishUC;
import com.api.thesouschefe.dishes.application.usecases.DishesUC;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
