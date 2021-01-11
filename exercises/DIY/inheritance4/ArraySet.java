import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("Value can't be null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size++;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wisPos;

        public ArraySetIterator() {
            wisPos = 0;
        }

        public boolean hasNext() {
            return wisPos < size;
        }

        public T next() {
            T returnItem = items[wisPos];
            wisPos++;
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public String toString() {
//        String returnString = "{";
//
//        // To get rid of the comma
//        for (int i = 0; i < size - 1; i++) {
//            returnString += items[i].toString();
//            returnString += ", ";
//        }
//        returnString += items[size - 1];
//        returnString += "}";

//        for (T item : this) {
//            returnString += item.toString();
//            returnString += ", ";
//        }
//        returnString += "}";

//        return returnString;

//        StringBuilder returnSB = new StringBuilder("{");
//        for (int i = 0; i < size - 1; i++) {
//            returnSB.append(items[i].toString());
//            returnSB.append(", ");
//        }
//        returnSB.append(items[size - 1]);
//        returnSB.append("}");
//        return returnSB.toString();

        // Fancier way
        List<String> listOfItems = new ArrayList<>();
        for (T x : this) {
            listOfItems.add(x.toString());
        }
        return "{" + String.join(", ", listOfItems) + "}";
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
        ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
        for (Glerp x : stuff) {
            returnSet.add(x);
        }
        return returnSet;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> temp = (ArraySet<T>) other;
        if (temp.size != temp.size()) {
            return false;
        }
        for (T item : this) {
            if (!temp.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
//        s.add(null);
//        s.add("horse");
//        s.add("fish");
//        s.add("house");
//        s.add("fish");
//        System.out.println(s.contains("horse"));
//        System.out.println(s.size());

//        Set<Integer> javaset = new HashSet<>();
//        javaset.add(5);
//        javaset.add(23);
//        javaset.add(42);
//        Iterator<Integer> seer = javaset.iterator();
//        while (seer.hasNext()) {
//            int i = seer.next();
//            System.out.println(i);
//        }

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);
//        Iterator<Integer> asser = aset.iterator();
//        while (asser.hasNext()) {
//            int i = asser.next();
//            System.out.println(i);
//        }

//        for (int i : aset) {
//            System.out.println(i);
//        }

        System.out.println(aset);

        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(2);
//        System.out.println(aset.equals(aset2));

        ArraySet<String> asetOfStrings = ArraySet.of("hi", "I'm", "here");
        System.out.println(asetOfStrings);
    }
}
