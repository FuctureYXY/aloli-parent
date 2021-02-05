package com.aloli.security.genericity;

public class GenericityTest {

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);

    }


    static int add(Pair<? super Integer> p) {
        Integer first = (Integer)p.getFirst();
        Integer last = (Integer)p.getLast();

        p.setFirst(new Integer(first.intValue() + 100));
        p.setLast(new Integer(last.intValue() + 100));

        return first.intValue() + last.intValue();
    }
}
