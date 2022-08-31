package sam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLambdaSam {
  public static void main(String[] args) {

    String[] namesArray = {"Allen", "Fred", "Howard"};

    show(
         "Filter|Count name - (> 3)&&(< 6): " +
         Arrays
              .stream(namesArray)
              .filter((s) -> s.length() > 3)// uses a Predicate-SAM
              .filter((s) -> s.length() < 6)
              .count());// return 'counting' of elements met the criteria

    show("dropWhile: Drop till Howard " +
         Arrays
              .stream(namesArray)
              .dropWhile(s -> ! s.equals("Howard"))// uses a Predicate-SAM
              .collect(Collectors.toList()));// collect and returns items as List

    show("takeWhile: Add till Howard " +
         Arrays
              .stream(namesArray)
              // uses a Predicate to include items till predicate becomes true
              .takeWhile(s -> ! s.equals("Howard"))// uses a Predicate-SAM
              .collect(Collectors.toList()));

    show("Skip first 2 names: " +
         Arrays
              .stream(namesArray)
              .skip(2) // skip first 2 elements
              .collect(Collectors.toList()));

    show("reduce summing 2 numbers: " +
         Stream
              .iterate(5, (t) -> t <= 100, (t) -> t + 5)
              .reduce((a, b) -> (a + b))// BinaryOperator-SAM summing
              .get()); // Supplier-SAM

    final List<Integer> ls = Arrays.asList(3, 4, 6, 9, 2, 5, 7);
    show("MAx number in a List of Integers: " +
         ls.stream()
           .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b));

    final List<Integer> list = Arrays.asList(3, 4, 6, 9, 2, 5, 7);
    show("Optional MAx number in a List of Integers: " +
         list.stream()
           .reduce((a, b) -> a > b ? a : b));

    final List<Integer> list1 = Arrays.asList(3, 4, 6, 9, 2, 5, 7);
    show("Optional Min number in a List of Integers: " +
         list1.stream()
           .max((a, b) -> a > b ? a : b));

    final List<Integer> asList = Arrays.asList(3, 4, 6, 9, 2, 5, 7);
    show("Min number in a List of Integers: " +
         asList.stream()
              .max((a, b) -> a > b ? a : b).get());


  }

  private static int sumMyNumbers(int a, int b) {

    return a + b;
  }

  private static void show(String txt) {

    System.out.println(txt);
  }
}