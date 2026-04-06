class TimeMap {
    private java.util.HashMap<String, java.util.List<Pair>> map;

    private static class Pair {
        int time;
        String value;
        Pair(int t, String v) {
            time = t;
            value = v;
        }
    }

    public TimeMap() {
        map = new java.util.HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new java.util.ArrayList<>())
           .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        java.util.List<Pair> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).time <= timestamp) {
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}