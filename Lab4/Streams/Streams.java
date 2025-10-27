package Lab4.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public  class Streams {
    public static OptionalDouble  average (List<Integer> ints) {

        return  ints.stream()
                .mapToInt(Integer::intValue)
                .average();

    }

    public static List<String> toNewUpperCasa (List<String> strs) {
        return strs.stream()
                .map(s->"_new_" + s.toUpperCase()).collect(Collectors.toList());
   }

    public static List<Integer> squaresOfUnique(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))  //группируем и считаем вхождения
                .entrySet()
                .stream()  // поток ключ-значений
                .filter(entry -> entry.getValue() == 1)  // фильтруем уникальные
                .map(entry -> entry.getKey() * entry.getKey())
                .collect(Collectors.toList());
    }

    public static <T> T lastOfCollection(Collection<T> collection) {
        return collection.stream()
                .reduce((_, second) -> second)// постоянно возвращаем пследний элемент
                .orElseThrow(() -> new NoSuchElementException("Ничего нет"));
    }

    public static int sumEvens(int[] ia){
        return Arrays.stream(ia)
                .filter(s -> s % 2 == 0)
                .sum();
    }

    public static Map<String, String> colToMap(Collection<String> col){
        return col.stream()
                .collect(Collectors.toMap(s->s.substring(0,1), s->s.substring(1)));
    }

}
