import java.util.function.BiFunction;

public class Chapter3Section3 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        int result = add.apply(3, 6);

        System.out.println(result);
    }
}
