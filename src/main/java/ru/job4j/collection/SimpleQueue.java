package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T flag = null;
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                flag = in.pop();
                    out.push(flag);
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}