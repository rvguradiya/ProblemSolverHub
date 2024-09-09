import java.util.HashMap;
import java.util.Map;

class WordCircleChain {
    public static void main(String[] args) {
        String strArr[] = { "chair", "height", "racket", "touch", "tunic" };

        System.err.println(isWordCricleChain(strArr));
    }

    static boolean isWordCricleChain(String strArr[]) {
        Map<Character, Integer> map = new HashMap<>();

        for (String str : strArr) {
            updateMap(str.charAt(0), map, true);
            updateMap(str.charAt(str.length() - 1), map, false);
        }

        boolean isChain = true;

        for (Integer i : map.values()) {
            if (i != 0)
                return false;
        }
        return true;
    }

    static private void updateMap(Character key, Map<Character, Integer> map, boolean flag) {
        int val = flag ? 1 : -1;
        if (map.containsKey(key))
            val = map.get(key) + val;
        map.put(key, val);
    }
}