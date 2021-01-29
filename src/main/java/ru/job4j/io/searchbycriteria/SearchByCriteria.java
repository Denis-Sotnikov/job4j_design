package ru.job4j.io.searchbycriteria;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ru.job4j.io.searchbycriteria.Args.searchIndex;

public class SearchByCriteria {

    public SearchByCriteria() {
    }

    public static void main(String[] args) throws Exception {
            Args argsArgum = new Args(args);
            PredicateFactory factory = new PredicateFactory();
            ResultWriter resultWriter = new ResultWriter();
            List<Path> list = new ArrayList<>();
            Path start = Paths.get(argsArgum.searchArgument("-d"));
            String val = argsArgum.searchArgument("-n");
            switch (caseChoice(args)) {
                case 1:
                    list = factory.search(
                            start,
                            val,
                            p -> p.toFile().getName().endsWith(val));
                    break;
                case 2:
                    list = factory.search(
                            start,
                            val,
                            p -> p.toFile().getName().equals(val));
                    break;
                case 3:
                    list = factory.search(
                            start,
                            val,
                            p -> p.toFile().getName().matches(val));
                    break;
                default:
                    System.out.println("Error");
            }
            ResultWriter.writeToFile(argsArgum.searchArgument("-o"), list);
        }

        private static int caseChoice(String[] array) throws Exception {
            try {
                if (searchIndex("-m", array) != 0) {
                    return 1;
                }
            } catch (Exception e) {
                //e.printStackTrace(); Печатаем в log
            }
            try {
                if (searchIndex("-f", array) != 0) {
                    return 2;
                }
            } catch (Exception e) {
                //e.printStackTrace(); Печатаем в log
            }
            try {
                if (searchIndex("-r", array) != 0) {
                    return 3;
                }
            } catch (Exception e) {
                //e.printStackTrace(); Печатаем в log
            }
            throw new Exception();
        }
}
