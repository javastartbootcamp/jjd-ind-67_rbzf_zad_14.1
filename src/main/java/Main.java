import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String fileName = "liczby.txt";
        File file = new File(fileName);
        try {
            TreeMap<Integer, Integer> mapNumbers = readFileToMap(file);
            printStatistics(mapNumbers);
        } catch (FileNotFoundException e) {
            System.err.println("Nie udalo sie odczytac pliku.");
        }

    }

    private static TreeMap<Integer, Integer> readFileToMap(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        TreeMap<Integer, Integer> mapNumbers = new TreeMap<>();
        while (scanner.hasNextInt()) {
            Integer number = scanner.nextInt();
            if (!mapNumbers.containsKey(number)) {
                mapNumbers.put(number, 1);
            } else {
                mapNumbers.put(number, mapNumbers.get(number) + 1);
            }
        }
        return mapNumbers;
    }

    private static void printStatistics(TreeMap<Integer, Integer> mapNumbers) {
        for (Integer key : mapNumbers.keySet()) {
            System.out.println(key + " - liczba wystąpień " + mapNumbers.get(key));
        }
    }

}
