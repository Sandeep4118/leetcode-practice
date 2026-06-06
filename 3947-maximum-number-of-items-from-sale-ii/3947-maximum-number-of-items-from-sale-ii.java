class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int cheapest = Integer.MAX_VALUE;
        int maxFactor = 0;

        for (int[] item : items) {
            cheapest = Math.min(cheapest, item[1]);
            maxFactor = Math.max(maxFactor, item[0]);
        }

        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        for (int i = 1; i <= maxFactor; i++) {
            if (freq[i] > 0) {
                for (int j = 2 * i; j <= maxFactor; j += i) {
                    freq[i] += freq[j];
                }
            }
        }

        TreeMap<Long, Long> costCount = new TreeMap<>();

        for (int[] item : items) {

            long cost = item[1];
            long gain = freq[item[0]] - 1;

            if (gain > 0 && cost <= 2L * cheapest) {
                costCount.put(
                    cost,
                    costCount.getOrDefault(cost, 0L) + gain
                );
            }
        }

        long total = 0;
        long B = budget;

        for (Map.Entry<Long, Long> e : costCount.entrySet()) {

            long cost = e.getKey();
            long gainCount = e.getValue();

            long take = Math.min(gainCount, B / cost);

            total += 2L * take;
            B -= take * cost;
        }

        total += B / cheapest;

        return (int) total;
    }
}