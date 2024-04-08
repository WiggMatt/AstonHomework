package mkonyukhov.aston;
import java.util.Collection;

public class MyLinkedList<E> implements MyCollection<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.data = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    // Конструктор без параметров
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Конструктор с параметром, принимающий коллекцию для инициализации
    public MyLinkedList(Collection<? extends E> collection) {
        this(); // Вызов конструктора без параметров для инициализации пустого списка
        addAll(collection); // Добавление элементов из переданной коллекции в список
    }

    // Добавление элемента в конец списка
    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element, tail, null);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    // Добавление элемента по указанному индексу
    @Override
    public void add(int index, E element) {
        checkIndexBound(index);
        if (index == size) {
            add(element);
        } else {
            Node<E> nodeAtIndex = getNode(index);
            Node<E> newNode = new Node<>(element, nodeAtIndex.prev, nodeAtIndex);
            if (nodeAtIndex.prev != null) {
                nodeAtIndex.prev.next = newNode;
            } else {
                head = newNode;
            }
            nodeAtIndex.prev = newNode;
            size++;
        }
    }

    // Получение элемента по индексу
    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    // Удаление элемента по индексу
    @Override
    public void remove(int index) {
        Node<E> nodeToRemove = getNode(index);
        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            head = nodeToRemove.next;
        }
        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        } else {
            tail = nodeToRemove.prev;
        }
        size--;
    }

    // Получение узла по индексу
    private Node<E> getNode(int index) {
        checkIndexBound(index);
        Node<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // Добавление всех элементов из переданной коллекции в конец списка
    @Override
    public void addAll(Collection<? extends E> collection) {
        for (E element : collection) {
            add(element);
        }
    }

    // Проверка корректности индекса
    private void checkIndexBound(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер массива: " + size);
        }
    }

    // Получение размера списка
    @Override
    public int size() {
        return size;
    }

    // Проверка, пуст ли список
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
