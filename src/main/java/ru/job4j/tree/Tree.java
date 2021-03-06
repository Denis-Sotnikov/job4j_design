package ru.job4j.tree;


import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> point = findBy(parent);
        if (findBy(child).isEmpty()) {
            if (!point.isEmpty()) {
                rsl = true;
                point.get().getChildren().add(new Node(child));
                return rsl;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return find(x -> x.getValue().equals(value));
    }

    public boolean isBinary() {
        return !find(x -> x.getChildren().size() > 2).isPresent();
    }

    public Optional<Node<E>> find(Predicate<Node<E>> point) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (point.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}