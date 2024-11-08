import model.Order;
import model.OrderLine;
import priceprocessor.OrderLineAggregationPriceProcessor;
import priceprocessor.TaxPriceProcessor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Chapter9Section3 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
        Function<Integer, Integer> addTen = x -> x + 10;
        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
//        System.out.println(composedFunction.apply(3));

        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))
                ));

        List<Function<Order, Order>> priceProcessors = getPriceProcessor(unprocessedOrder);
        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(), Function::andThen);
        Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
        System.out.println(processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessor(Order order) {
        return Arrays.asList(new OrderLineAggregationPriceProcessor(), new TaxPriceProcessor(new BigDecimal("9.375")));
    }
}
