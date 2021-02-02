package ru.job4j.io.searchbycriteria;

import ru.job4j.io.SearchFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class SearchByCriteria {

    public SearchByCriteria() {
    }

    public static void main(String[] args) throws Exception {
            SearchByCriteria criteria = new SearchByCriteria();
            PredicateFactory factory = new PredicateFactory();
            factory.readArgsToMap(args);
            Path start = Paths.get(factory.getArgsMap().get("-d"));
            List<Path> list = criteria
                    .search(start, factory.createPredicat());
            ResultWriter.writeToFile(factory.getArgsMap().get("-o"), list);
        }

    public List<Path> search(Path root, Predicate<Path> predicate) throws IOException {
        SearchFiles searcher = new SearchFiles(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}

