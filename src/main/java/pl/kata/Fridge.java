package pl.kata;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Fridge {
    private List<Food> foods= Collections.emptyList();
    private final OrderService orderService;

    @Inject
    public Fridge(OrderService orderService) {
        this.orderService = orderService;
    }


    public List<Food> getFoods() {
        return foods;
    }

    public List<Food> addFood(Food food) throws FoundException {
        Optional<Food> findedFood = findFood(food.getName());
        if(findedFood.isPresent()){
            throw new FoundException();
        } else {
            foods.add(food);
        }
        return foods;
    }

    public List<Food> removeFood(Food food){
        foods.remove(food);
        return foods;
    }

    public Optional<Food> findFood(String name){

        for(Food f : foods) {
            if(f.getName().equals(name)){
                return Optional.of(f);
            }
        }
        return Optional.empty();

    }

    public Optional<Food> increaseFood(String name, Double value){
        for(Food f : foods) {
            if(f.getName().equals(name)){
                f.increaseAmount(value);
                return Optional.of(f);
            }
        }
        return Optional.empty();
    }


    public Optional<Food> decrease(String name, Double value) {
        for(Food f : foods) {
            if(f.getName().equals(name)) {
                try {
                    f.decreaseAmount(value);
                } catch (ZeroAmountException e) {
                    orderService.order();
                }
            }
        }
        return Optional.empty();
    }

}
