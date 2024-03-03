// Note this model implentation was taken from Stack Overflow https://stackoverflow.com/questions/6409652/random-weighted-selection-in-java


package game;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class WeightedProbModel<E> {
    private final NavigableMap<Double, E> map = new TreeMap<Double, E>();
    private final Random random;
    private double total = 0;

    public WeightedProbModel() {
        this(new Random());
    }

    public WeightedProbModel(Random random) {
        this.random = random;
    }

    public WeightedProbModel<E> add(double weight, E result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }
    public E next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }
}




