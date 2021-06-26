package personal.nutrisport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.nutrisport.common.Common.*;
import personal.nutrisport.fatsecret.dto.FoodDto;
import personal.nutrisport.fatsecret.model.Food;
import personal.nutrisport.repository.FoodRepository;

import java.util.List;

@RequestMapping(Href.HOME)
@RestController
public class FoodController {

    private final FoodRepository repository;

    @Autowired
    public FoodController(FoodRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = Href.FOODS)
    public String createFood(@RequestBody FoodDto foodDto) {
        return null;
    }

    @GetMapping(path = Href.FOODS)
    public List<Food> getAllFoods() {
        return repository.findAll();
    }


}
