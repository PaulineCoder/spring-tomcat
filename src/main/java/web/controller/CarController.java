package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    CarService carService = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(defaultValue = "-1", value = "count", required = false) Integer count, ModelMap model) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("BMW", "M2", 87));
        cars.add(new Car("Mazda", "CX-30", 1));
        cars.add(new Car("Subaru", "WRX", 4));
        cars.add(new Car("Acura", "EL", 3));
        cars.add(new Car("Lexus", "LS", 6));

        model.addAttribute("cars", carService.getCars(cars, count));

        return "cars";
    }
}
