import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Chapter5Section3 {
    public static void main(String[] args) {
        Map<String, BiFunction<String, String, Car>> carTypeToConstructorMap = new HashMap<>();
        carTypeToConstructorMap.put("sedan", Sedan::new);
        carTypeToConstructorMap.put("suv", Suv::new);
        carTypeToConstructorMap.put("van", Van::new);

        User user = new User(1, "Alice");
        BiFunction<Integer, String, User> userCreator = User::new;
//        System.out.println(userCreator.apply(3, "Charlie"));

        String[][] inputs = new String[][] {
                {"sedan", "Sonata", "Hyndai"},
                {"van", "Sienna", "Toyota"},
                {"sedan", "Model S", "Tesla"},
                {"suv", "Sorento", "KIA"}
        };

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            cars.add(carTypeToConstructorMap.get(carType).apply(name, brand));
        }

        for (Car car : cars) {
            car.drive();
        }
    }
}
