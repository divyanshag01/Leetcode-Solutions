class SegmentTreeMax {
    int[] tree;
    int n;

    SegmentTreeMax(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        build(0, 0, n - 1, nums);
    }

    void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid, nums);
        build(2 * node + 2, mid + 1, end, nums);

        tree[node] = Math.max(
            tree[2 * node + 1],
            tree[2 * node + 2]
        );
    }

    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return Integer.MIN_VALUE;
        }

        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(
            query(2 * node + 1, start, mid, l, r),
            query(2 * node + 2, mid + 1, end, l, r)
        );
    }

    int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }
}

class SegmentTreeMin {
    int[] tree;
    int n;

    SegmentTreeMin(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        build(0, 0, n - 1, nums);
    }

    void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid, nums);
        build(2 * node + 2, mid + 1, end, nums);

        tree[node] = Math.min(
            tree[2 * node + 1],
            tree[2 * node + 2]
        );
    }

    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return Integer.MAX_VALUE;
        }

        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(
            query(2 * node + 1, start, mid, l, r),
            query(2 * node + 2, mid + 1, end, l, r)
        );
    }

    int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }
}

class Solution {

    static class Node {
        long value;
        int l;
        int r;

        Node(long value, int l, int r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        SegmentTreeMax maxTree = new SegmentTreeMax(nums);
        SegmentTreeMin minTree = new SegmentTreeMin(nums);

        PriorityQueue<Node> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(b.value, a.value)
            );

        for (int l = 0; l < n; l++) {

            long value =
                (long) maxTree.query(l, n - 1)
                - minTree.query(l, n - 1);

            pq.offer(new Node(value, l, n - 1));
        }

        long ans = 0;

        for (int cnt = 0; cnt < k; cnt++) {

            Node cur = pq.poll();

            ans += cur.value;

            if (cur.r > cur.l) {

                int nextR = cur.r - 1;

                long nextValue =
                    (long) maxTree.query(cur.l, nextR)
                    - minTree.query(cur.l, nextR);

                pq.offer(
                    new Node(
                        nextValue,
                        cur.l,
                        nextR
                    )
                );
            }
        }

        return ans;
    }
}