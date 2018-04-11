
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ajaykumar.yadav on 11/04/18.
 */
public class AllPossibleWordsFromPhoneDigits {
    static Map<String, String[]> hashMap = new HashMap<>();

    static void populateHashMap() {
        String[] twoList = {"A", "B", "C"};
        String[] threeList = {"D", "E", "F"};
        String[] fourList = {"G", "H", "I"};
        String[] fiveList = {"J", "K", "L"};
        String[] sixList = {"M", "N", "O"};
        String[] sevenList = {"P", "Q", "R", "S"};
        String[] eightList = {"T", "U", "V"};
        String[] nineList = {"W", "X", "Y", "Z"};


        hashMap.put("2", twoList);
        hashMap.put("3", threeList);
        hashMap.put("4", fourList);
        hashMap.put("5", fiveList);
        hashMap.put("6", sixList);
        hashMap.put("7", sevenList);
        hashMap.put("8", eightList);
        hashMap.put("9", nineList);
    }

    static void printElements(String[] arr, int index, String[] output) {

        if (arr.length == index) {
            System.out.println(Arrays.asList(output));
            return;
        }
        String[] charArray = hashMap.get(arr[index]);
        //System.out.println(charArray);

        Arrays.stream(charArray).forEach(e -> {
            output[index] = e;
            printElements(arr,index+1,output);
        });

    }


    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = bufferedReader.readLine();

        } catch (Exception e) {

        }
        String[] inputArray = s.split(" ");
        populateHashMap();
        String[] output = new String[inputArray.length];
        printElements(inputArray, 0, output);

    }
}

