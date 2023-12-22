package lpa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DirectoryAndFileManipulationChallenge {
    public static void main(String[] args) {
        Path first = Path.of("public");
        Path second = Path.of("public/assets");
        Path third = Path.of("public/assets/icons");
        List<Path> paths = new ArrayList<>(List.of(
                first,
                second,
                third
        ));
        for (int i = 0; i < paths.size(); i++) {
            try {
                Files.createDirectories(paths.get(i));
                Path index = Path.of(paths.get(i) + "/index.txt");
                String date = "%s %n".formatted(paths.get(i).getFileName());
                Files.writeString(index, date);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            recurseIndexInfo(first);
            recurseIndexUpdate(third);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void recurseIndexInfo(Path currentPath) throws IOException {
        if (Files.isDirectory(currentPath)) {
            try {
                var currentContent = Files.list(currentPath).map(Path::toAbsolutePath).map(Path::toString).toList().toString();
                BasicFileAttributes attributes = Files.readAttributes(currentPath, BasicFileAttributes.class);
                String time = attributes.creationTime().toString();
                var timeStamps = Files.list(currentPath).map(p -> {
                            try {
                                return Files.readAttributes(p, BasicFileAttributes.class).creationTime().toString();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .collect(Collectors.joining(", "));
                ;
                List<String> data = List.of(timeStamps, currentContent);
                Files.write(Path.of(currentPath + "/index.txt"), data, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (var paths = Files.list(currentPath)) {
                paths.toList().forEach(p -> {
                    try {
                            DirectoryAndFileManipulationChallenge.recurseIndexInfo(p);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

    }

    public static void recurseIndexUpdate(Path current) throws FileNotFoundException {
        if (Files.isDirectory(current) && current.getParent() != null) {
            try(BufferedReader reader =new BufferedReader(new FileReader(current + "/index.txt"));
            FileWriter writer = new FileWriter(current.getParent() + "/index.txt" )) {
                reader.transferTo(writer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (var paths = Files.list(current)) {
                paths.toList().forEach(p -> {
                    try {
                            DirectoryAndFileManipulationChallenge.recurseIndexUpdate(p);

                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

