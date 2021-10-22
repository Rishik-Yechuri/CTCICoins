import java.util.HashMap;
import java.util.HashSet;

public class CTCICoins {
    public static void main(String[] args) {
        try {
            CTCICoins obj = new CTCICoins();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] args) {
        System.out.println(findNumOfRepresentations(100,25,new HashMap<String,Integer>()));
    }

    public int findNumOfRepresentations(int n, int maxVal, HashMap<String, Integer> holdCalculatedVals) {
        int total = 0;
        if (maxVal >= 25) {
            int maxNumOfDimes = n / 25;
            for (int x = 0; x <= maxNumOfDimes; x++) {
                if (holdCalculatedVals.containsKey(n + " " + maxVal)) {
                    System.out.println("Hey");
                    total = holdCalculatedVals.get(n + " " + maxVal);
                } else {
                    total += findNumOfRepresentations(n - (x * 25), 10, holdCalculatedVals);
                }
            }
            return total;
        } else if (maxVal >= 10) {
            int maxNumOfDimes = n / 10;
            for (int x = 0; x <= maxNumOfDimes; x++) {
                if (holdCalculatedVals.containsKey(n + " " + maxVal)) {
                    total = holdCalculatedVals.get(n + " " + maxVal);
                } else {
                    total += findNumOfRepresentations(n - (x * 10), 5, holdCalculatedVals);
                }
            }
        } else if (maxVal >= 5) {
            total = n / 5 + 1;
        }
        holdCalculatedVals.put(n + " " + maxVal, total);
        return total;
    }
}