package Lab4;

import Lab4.Streams.Streams;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        List<Integer> x = Arrays.asList(1,2,3,4);

        OptionalDouble xs = Streams.average(x);
        if(xs.isPresent()){
            System.out.println(xs.getAsDouble()); //2.5
        }

        List<String> s = Arrays.asList("a", "b");
        List<String> ls = Streams.toNewUpperCasa(s);
        System.out.println(Arrays.toString(ls.toArray())); //[_new_A, _new_B]

        List<Integer> ns = Arrays.asList(5, 2, 5, 3, 4, 4, 6); //уникальные 2 3 6

        List<Integer> squares = Streams.squaresOfUnique(ns);
        System.out.println(Arrays.toString(squares.toArray())); //[4, 9, 36]

        try {
            List<String> iCol = Arrays.asList("abc", "efg");
            String iColLast = Streams.lastOfCollection(iCol);
            System.out.println(iColLast); //efg
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }


        System.out.println(Streams.sumEvens(new int[]{1,2,3,4})); // 1,3->0 ... 1,2,3,4->6

        List<String> l = Arrays.asList("a1..", "b2,,");
        System.out.println(Streams.colToMap(l)); // {a=1.., b=2,,}


    }
}
