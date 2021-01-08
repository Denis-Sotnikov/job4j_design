package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        System.out.println("Here");
        System.out.println("Size = " + sources.size());
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (int i = 0; i < sources.size(); i++) {
                zip.putNextEntry(new ZipEntry(sources.get(i).toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(sources.get(i).toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        Search search = new Search();
        Path start = Paths.get(argZip.directory());
        Zip zip = new Zip();
        System.out.println("argZip.directory() = " + argZip.directory());
        System.out.println("argZip.exclude() = " + argZip.exclude());
        System.out.println("argZip.output() = " + argZip.output());
        zip.packFiles(Search.search(start, argZip.exclude()), new File(argZip.output()));
    }
}