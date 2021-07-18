import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long numberOfMinors = persons.stream().filter(x -> x.getAge() < 18).count();
        List<String> listOfSurname = persons.stream().filter(x -> x.getAge() >= 18 && x.getAge() <= 27).
                map(Person::getFamily).collect(Collectors.toList());
        List<Person> listOfWorkers = persons.stream().filter(x -> x.getEducation() == Education.HIGHER).
                filter(x -> x.getAge() >= 18).
                filter(x -> (x.getSex() == Sex.MAN && x.getAge() <= 65) ||
                        (x.getSex() == Sex.WOMAN && x.getAge() <= 65)).
                collect(Collectors.toList());

        System.out.println("Количество несовершеннолетних = " + new DecimalFormat("###,###,###.##").
                format(numberOfMinors));
        System.out.println("Количество призывников = " + new DecimalFormat("###,###,###.##").
                format(listOfSurname.size()));
        System.out.println("Количество рабочих с высшим образованием = " + new DecimalFormat("###,###,###.##").
                format(listOfWorkers.size()));
    }
}
