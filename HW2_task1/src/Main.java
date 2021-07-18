import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static String getStringList(List<Integer> intList){
        StringBuilder strB = new StringBuilder();
        for(Integer x:  intList){
            strB.append(x).append(", ");
        }
        if (strB.length() > 0)  strB.delete(strB.length()-2,strB.length());
        return strB.toString();
    }

    private static List<Integer> positiveNumbers(List<Integer> intList){
        List<Integer> positiveList = new ArrayList<>();
        for(Integer x:  intList){
            if (x>0) positiveList.add(x); // положительные = СТРОГО больше 0
        }
        return positiveList;
    }

    private static List<Integer> evenNumbers(List<Integer> intList){
        List<Integer> evenPositiveList = new ArrayList<>();
        for(Integer x:  intList){
            if (x % 2 == 0) evenPositiveList.add(x);
        }
        return evenPositiveList;
    }

    private static List<Integer> sortedNumbers(List<Integer> intList){
        List<Integer> sortedList = new ArrayList<>(List.copyOf(intList));
        sortedList.sort(Comparator.naturalOrder());
        return sortedList;
    }

    public static void main(String[] args){
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> positiveList = positiveNumbers(intList);
        List<Integer> evenPositiveList = evenNumbers(positiveList);
        List<Integer> sortedList = sortedNumbers(evenPositiveList);

        System.out.println("Исходный массив: "+getStringList(intList));
        System.out.println("Положительные числа из массива: "+getStringList(positiveList));
        System.out.println("Положительные четные числа из массива: "+getStringList(evenPositiveList));
        System.out.println("Отсортированные числа в порядке возрастания: "+getStringList(sortedList));
    }
}
