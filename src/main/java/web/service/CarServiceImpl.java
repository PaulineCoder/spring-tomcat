package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getCars(List<Car> list, int count) {
        if (count >= 5 || count == -1) {
            return list;
        }
        return list.stream().limit(count).collect(Collectors.toList());
    }
}
