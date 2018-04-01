import tree.RBTree;

import java.util.Arrays;

public class Runner {

    public static void run(){
        int[] values = new int[]{5, 15, 96, 12, 14, 36, 28, 12548, 0, -128, 146, 1254};

        System.out.println("Inserted values: " + Arrays.toString(values));

        RBTree<Integer> tree = new RBTree<>();
        for (int i : values) {
            tree.insert(i);
        }

        System.out.println("Inserted values: ");
        for (int i : tree) {
            System.out.print(i + " ");
        }

        RBTree<Integer> sortTree = new RBTree<>();
        Arrays.sort(values);
        for (int i : values) {
            sortTree.insert(i);
        }

        System.out.println("\n\nInserted values from sorted array:");
        for (int i : sortTree) {
            System.out.print(i + " ");
        }
    }

}
