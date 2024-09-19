import util.TriFunction;

public class Chapter3Section4 {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> adder = (x, y, z) -> x + y + z;
        int result = adder.apply(1, 2, 3);

        System.out.println(result);
    }
}
