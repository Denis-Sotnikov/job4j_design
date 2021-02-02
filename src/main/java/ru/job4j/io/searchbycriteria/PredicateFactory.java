package ru.job4j.io.searchbycriteria;

import ru.job4j.io.SearchFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateFactory {
    private Map<String, String> argsMap = new HashMap<>();

    public Map<String, String> getArgsMap() {
        return argsMap;
    }

    public void readArgsToMap(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith("-")) {
                if (!array[i + 1].startsWith("-")) {
                    argsMap.put(array[i], array[i + 1]);
                } else {
                    argsMap.put(array[i], new String());
                }
            }
        }
    }

    public Predicate<Path> createPredicat() throws Exception {
        String val = argsMap.get("-n");
        Predicate<Path> pathPredicate = null;
                switch (caseChoice()) {
            case 1:
                pathPredicate =
                        p -> p.toFile().getName().endsWith(val);
                break;
            case 2:
                pathPredicate =
                        p -> p.toFile().getName().equals(val);
                break;
            case 3:
                pathPredicate =
                        p -> p.toFile().getName().matches(val);
                break;
            default:
                System.out.println("Выберете корректное условие поиска");
        }
    return pathPredicate;
    }

    private int caseChoice() throws Exception {
        int val = 0;
        if (argsMap.containsKey("-m")) {
            return 1;
        } else {
            if (argsMap.containsKey("-f")) {
                return 2;
            } else {
                if (argsMap.containsKey("r")) {
                    return 3;
                }
            }
        }
        return val;
    }
}
