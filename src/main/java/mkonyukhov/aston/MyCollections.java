package mkonyukhov.aston;

import java.util.Collection;
import java.util.List;

public class MyCollections {
    public static <T extends Comparable<? super T>> void bubbleSort(Collection<T> collection) {
        if (collection instanceof List<T> list) {
            int n = list.size();
            boolean swapped;
            do {
                swapped = false;
                for (int i = 1; i < n; i++) {
                    if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                        swap(list, i - 1, i);
                        swapped = true;
                    }
                }
                n--;
            } while (swapped);
        } else {
            throw new UnsupportedOperationException("Сортировка пузырьком поддерживается только для коллекций.");
        }
    }

    private static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
