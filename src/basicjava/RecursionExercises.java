package basicjava;

import java.util.ArrayList;

public class RecursionExercises {
    
    public int countDigits(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            i = -i;
        }
        if (i < 10) {
            return 1;
        }
        return 1 + countDigits(i / 10);
    }
    
    public int addDigits(int i) {
        if (i < 10) {
            return i;
        }
        return (i % 10) + addDigits(i / 10);
    }
    
    public int sum(int sumFrom, int sumTo) {
        if (sumFrom < 0 || sumTo < 0 || sumFrom > sumTo) {
            return 0;
        }
        if (sumFrom == sumTo) {
            return sumFrom;
        }
        return sumFrom + sum(sumFrom + 1, sumTo);
    }
    
    public int sumEvenNumbers(int i) {
        if (i < 0) {
            return 0; 
        } else {
            int sum = sumEvenNumbers(i - 1); 
            if (i % 2 == 0) {
                sum += i; 
            }
            return sum;
        }
    }
    
    public int countVowels(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char c = Character.toLowerCase(s.charAt(0));
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return 1 + countVowels(s.substring(1));
        }
        return countVowels(s.substring(1));
    }
    
    public String removeVowels(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return s;
        }
        char c = Character.toLowerCase(s.charAt(0));
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return removeVowels(s.substring(1));
        }
        return s.charAt(0) + removeVowels(s.substring(1));
    }
    
    public int sumOfMultiple(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i = list.get(0);
        list.remove(0);
        if (i % 5 == 0) {
            return i + sumOfMultiple(list);
        }
        return sumOfMultiple(list);
    }
}