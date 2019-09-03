class MergeInterval {
    // time: nlogn
    // space: O(n)
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> tmp = new ArrayList<>();
        tmp.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= tmp.get(tmp.size() - 1)[1]) {
                tmp.get(tmp.size() - 1)[1] = Math.max(tmp.get(tmp.size() - 1)[1], intervals[i][1]);
            } else {
                tmp.add(intervals[i]);
            }
        }
        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }
        return res;
    }


}