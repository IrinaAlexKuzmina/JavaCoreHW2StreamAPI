import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args){
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Supplier<Stream<Integer>> supplier = () -> intList.stream();
        Supplier<Stream<Integer>> positiveSupplier = () -> supplier.get().filter(x -> x>0);
        Supplier<Stream<Integer>> evenPositiveSupplier = () -> positiveSupplier.get().filter(x -> x % 2 == 0);
        Supplier<Stream<Integer>> sortedSupplier = () -> evenPositiveSupplier.get().sorted(Comparator.naturalOrder());

        System.out.print("Исходный массив: ");
        supplier.get().forEach(x ->System.out.print(x + ", "));

        System.out.print("\nПоложительные числа из массива: ");
        positiveSupplier.get().forEach(x ->System.out.print(x + ", "));

        System.out.print("\nПоложительные четные числа из массива: ");
        evenPositiveSupplier.get().forEach(x ->System.out.print(x + ", "));

        System.out.print("\nОтсортированные числа в порядке возрастания: ");
        sortedSupplier.get().forEach(x ->System.out.print(x + ", "));
    }
}
