import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.RandomAccess;

public class Main {
    private static final Map<Integer, Long> indexedRecords = new LinkedHashMap<>();
    static {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("employees.dat", "r")) {
            loadIndexMap(randomAccessFile, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        indexedRecords.keySet().forEach(s -> System.out.println("Key: " + s));
        System.out.println("-".repeat(50));

//        long startingPosition = 4 + ((4L + 16L) +25);
        try(RandomAccessFile ra = new RandomAccessFile("employees.dat", "rw")) {

//            changeSalary(ra, 908, 9999.00);
//            printRecordById(ra, 908);
            for (var key : indexedRecords.keySet()) {
                printRecordById(ra, key);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    private static void loadIndexMap(RandomAccessFile ra, int startingPosition) {
        try {
            ra.seek(startingPosition);
            int totalCount = ra.readInt();
            System.out.println("Number of records: " + totalCount);
            for (int i = 0; i < totalCount; i++) {
                indexedRecords.put(ra.readInt(), ra.readLong());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void  printRecordById(RandomAccessFile ra, int id) {
        try {
            ra.seek(indexedRecords.get(id));
            int EmployeeID = ra.readInt();
            double salary = ra.readDouble();
            String FirstName = ra.readUTF();
            String LastName = ra.readUTF();
            System.out.printf("ID: %d - %s %s - Salary: $%.2f%n", EmployeeID, FirstName, LastName, salary);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void changeSalary(RandomAccessFile ra, int id, double newSalary) {
        try {
            ra.seek(indexedRecords.get(id));
            ra.skipBytes(4);
            ra.writeDouble(newSalary);
            String FirstName = ra.readUTF();
            String LastName = ra.readUTF();
            System.out.println("Salary of" + FirstName + " " + LastName + " was changed to: " + newSalary);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
