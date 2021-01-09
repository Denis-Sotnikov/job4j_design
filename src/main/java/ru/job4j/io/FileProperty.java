package ru.job4j.io;

import java.util.Objects;

public class FileProperty {
    private String name;
    private Long size;

    public FileProperty(String name, Long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileProperty that = (FileProperty) o;
        return Objects.equals(name, that.name)
                && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return "FileProperty{"
                + "name='"
                + name
                + '\''
                + ", size="
                + size
                + '}';
    }
}
