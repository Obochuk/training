package warehouse;

import java.util.*;

/**
 * Data storage class for storage elements of type ${@code E} and it`s amount. Made with HashMap
 *
 * @param <E> element type
 */
public class Warehouse<E> implements Iterable<Map.Entry<E, Double>> {
    private Map<E, Double> elementAmountMap = new HashMap<>();

    public Warehouse() {
    }

    public Warehouse(Map<E, Double> elementAmountMap) {
        this.elementAmountMap = elementAmountMap;
    }

    public double get(E elem) {
        return elementAmountMap.get(elem);
    }


    /**
     * Adds to this storage desired amount of specified element, such ass:
     * <ul><li>if elem exists, its amount increases on specified amount</li>
     * <li>if it doesn`t - creates element with specified amount</li> </ul>
     *
     * @param elem   not null
     * @param amount >= 0
     */
    public void refillWith(E elem, double amount) {
        if (elementAmountMap.containsKey(elem)) {
            double oldAmount = elementAmountMap.get(elem);
            elementAmountMap.put(elem, oldAmount + amount);
        } else {
            elementAmountMap.put(elem, amount);
        }
    }

    /**
     * adds all elements of specified param as describes ${@link Warehouse#refillWith(Object, double)}
     *
     * @param warehouse not null
     */
    public void refillWith(Warehouse<E> warehouse) {
        for (Map.Entry<E, Double> elementAmount : warehouse) {
            refillWith(elementAmount.getKey(), elementAmount.getValue());
        }
    }

    /**
     * removes specified amount of desired element.
     *
     * @param elem           not null
     * @param requiredAmount >= 0
     * @return amount of element that were really removed
     */
    public double remove(E elem, double requiredAmount) {
        if (elementAmountMap.containsKey(elem)) {
            double exist = elementAmountMap.get(elem);
            if (requiredAmount >= exist) {
                elementAmountMap.remove(elem);
                return exist;
            } else {
                elementAmountMap.put(elem, exist - requiredAmount);
                return requiredAmount;
            }
        } else
            return 0;
    }


    /**
     * moves elements from this storage to one specified as ${@code to} in amount specified as param ${@code amount}
     * return luck of elements
     *
     * @param to     not null. Storage in which moved elements
     * @param amount amount of all elements that need to move
     * @return lack of each element
     */
    public Warehouse<E> moveTo(Warehouse<E> to, Warehouse<E> amount) {
        Map<E, Double> lack = new HashMap<E, Double>();
        for (Map.Entry<E, Double> requiredAmount : amount) {
            final E MOVED_ELEMENT = requiredAmount.getKey();
            final double MOVED_AMOUNT = requiredAmount.getValue();

            double reallyMoved = remove(MOVED_ELEMENT, MOVED_AMOUNT);
            if (reallyMoved != MOVED_AMOUNT)
                lack.put(MOVED_ELEMENT, MOVED_AMOUNT - reallyMoved);

            to.refillWith(requiredAmount.getKey(), reallyMoved);
        }
        return new Warehouse<E>(lack);
    }

    @Override
    public Iterator<Map.Entry<E, Double>> iterator() {
        return elementAmountMap.entrySet().iterator();
    }

    @Override
    public String toString() {
        return elementAmountMap.toString();
    }
}
