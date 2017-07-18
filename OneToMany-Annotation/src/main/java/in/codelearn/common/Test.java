package in.codelearn.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    /*
     * Complete the function below.
     */
    
    static void fancySort(String[] exps) {
        Map<Integer, List<String>> map = new TreeMap<Integer, List<String>>();
        int lineCount = exps.length;
        
        Set<String> allowedOperations = new HashSet<String>();
        allowedOperations.add("MAX");
        allowedOperations.add("MIN");
        allowedOperations.add("ADD");
        allowedOperations.add("SUBTRACT");
        allowedOperations.add("MULTIPLY");
        allowedOperations.add("DIVIDE");
        
        for (int i = 0; i < lineCount; i++) {
            String line = exps[i];
            try {
                int value = getValue(line, allowedOperations);
                List<String> list = map.get(value);
                if (list == null) {
                    list = new ArrayList<String>();
                    list.add(line);
                } else {
                    list = map.get(value);
                    list.add(line);
                }
                map.put(value, list);
            } catch (Exception e) {
            }
        }
        
        for (Integer i : map.keySet()) {
            List<String> list = map.get(i);
            Collections.sort(list);
            for (String line : list) {
                System.out.println(line);
            }
        }
        
    }
    
    static int getValue(String line, Set allowedOperations) throws Exception {
        if (line != null && line.length() > 0) {
            String text[] = line.split(",");
            if (!allowedOperations.contains(text[0])) {
                throw new Exception("Error");
            }
            int[] values = new int[text.length - 1];
            String operation = text[0];
            for (int i = 1; i < text.length; i++) {
                try {
                    int value = Integer.parseInt(text[i]);
                    values[i - 1] = value;
                } catch (Exception e) {
                    throw new Exception("Error");
                }
            }
            
            int exprValue = 0;
            if (operation.equals("ADD")) {
                int sum = 0;
                for (int i = 0; i < values.length; i++) {
                    sum = sum + values[i];
                }
                return sum;
            } else if (operation.equals("SUBTRACT")) {
                int sum = values[0];
                for (int i = 1; i < values.length; i++) {
                    sum = sum - values[i];
                }
                return sum;
            } else if (operation.equals("DIVIDE")) {
                int sum = values[0];
                for (int i = 1; i < values.length; i++) {
                    sum = sum / values[i];
                }
                return sum;
            } else if (operation.equals("MULTIPLY")) {
                int sum = values[0];
                for (int i = 1; i < values.length; i++) {
                    sum = sum * values[i];
                }
                return sum;
            } else if (operation.equals("MAX")) {
                int sum = values[0];
                for (int i = 1; i < values.length; i++) {
                    if (values[i] > sum) {
                        sum = values[i];
                    }
                }
                return sum;
            } else if (operation.equals("MIN")) {
                int sum = values[0];
                for (int i = 1; i < values.length; i++) {
                    if (values[i] < sum) {
                        sum = values[i];
                    }
                }
                return sum;
            }
            return exprValue;
        }
        throw new Exception("Error");
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int _exps_size = 0;
        _exps_size = Integer.parseInt(in.nextLine().trim());
        String[] _exps = new String[_exps_size];
        String _exps_item;
        for (int _exps_i = 0; _exps_i < _exps_size; _exps_i++) {
            try {
                _exps_item = in.nextLine();
            } catch (Exception e) {
                _exps_item = null;
            }
            _exps[_exps_i] = _exps_item;
        }
        
        fancySort(_exps);
        
    }
    
}
