package lpa;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FileTreeWalkingChallenge {
    public static void main(String[] args) {
        Path startingPath = Path.of(".");
        FileVisitor<Path> statsVisitor = new StatsVisitor(4);
        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class StatsVisitor extends SimpleFileVisitor<Path> {
        private Path initialPath = null;
        private final Map<Path, Long> folderSizes = new LinkedHashMap<>();
        private Map<Path, Long> folderFileNumber =  new LinkedHashMap<>();
        private Map <Path, Long> folderDirectoryNumber = new LinkedHashMap<>();
        private int initialCount;
        private int printLevel;

        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
            folderSizes.merge(file.getParent(), 0L, (oldValue, newValue) -> oldValue += attrs.size());
//            System.out.println(file.getFileName() + " number of names: " + file.getNameCount());
            folderFileNumber.merge(file.getParent(), 0L, (oldValue, newValue) -> oldValue += 1);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);

            if (initialPath == null) {
                initialPath = dir;
                initialCount = dir.getNameCount();
//                System.out.println( "initial Count = " + initialCount);
            } else {
                int relativePath = dir.getNameCount() - initialCount;
//                System.out.println("DepthLevel = " + relativePath);
                if (relativePath == 1) {
                    folderSizes.clear();
                    folderFileNumber.clear();
                    folderDirectoryNumber.clear();
                }
                folderSizes.put(dir, 0L);
                folderFileNumber.put(dir, 0L);
                folderDirectoryNumber.put(dir, 1L);
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Objects.requireNonNull(dir);
//            if (exc != null)
//                throw exc;

            if (dir.equals(initialPath)) {
                return FileVisitResult.TERMINATE;
            }
            int relativeLevel = dir.getNameCount() - initialCount;
            if (relativeLevel == 1) {
                folderSizes.forEach((key, value) -> {
                            int level = key.getNameCount() - initialCount - 1;
                            if (level < printLevel) {
                                System.out.printf("%s[%s] - %,d bytes %d files %d subfolders %n",
                                        "\t".repeat(level), key.getFileName(), value ,
                                        folderFileNumber.get(key), (folderDirectoryNumber.get(key) -1 ));
                            }
                        });
//                folderFileNumber.forEach((key, value) -> {
//                    System.out.println("[" + key.getFileName() + "]" + " number of files: " +  value);
//                });
//                folderDirectoryNumber.forEach((key, value) -> {
//                    System.out.println("[" + key.getFileName() + "]" + " subfolders: " + (value -1));
//                });
            } else {
                long folderSize = folderSizes.get(dir);
                long filesNumber = folderFileNumber.get(dir);
                long directoryNumber = folderDirectoryNumber.get(dir);
                folderSizes.merge(dir.getParent(), 0L, (oldValue, newValue) -> oldValue += folderSize);
                folderFileNumber.merge(dir.getParent(), 0L, (oldValue, newValue) -> oldValue += filesNumber);
                folderDirectoryNumber.merge(dir.getParent(), 0L, (oldValue, newValue) -> oldValue += directoryNumber);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
