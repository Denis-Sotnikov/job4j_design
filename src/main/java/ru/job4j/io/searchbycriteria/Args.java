package ru.job4j.io.searchbycriteria;

public class Args {
    private String[] array;

    public Args(String[] array) {
        this.array = array;
    }

    protected String searchArgument(String val) throws Exception {
        return array[searchIndex(val, array)];
    }

    protected static int searchIndex(String val, String[] array) throws Exception {
        Integer y = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(val)) {
                y = i + 1;
            }
        }
        if (y == null) {
            throw new Exception();
        }
        return y;
    }
}
