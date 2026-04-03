class Solution {
    public int minMeetingRooms(java.util.List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        java.util.Arrays.sort(start);
        java.util.Arrays.sort(end);

        int rooms = 0, endPtr = 0;

        for (int i = 0; i < n; i++) {
            if (start[i] < end[endPtr]) {
                rooms++;
            } else {
                endPtr++;
            }
        }

        return rooms;
    }
}