class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        // Max heap
        left = new PriorityQueue<>(Collections.reverseOrder());

        // Min heap
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Keep sizes within 1
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }

        if (right.size() > left.size() + 1) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {

        if (left.size() == right.size()) {
            return ((double) left.peek() + right.peek()) / 2;
        }

        if (left.size() > right.size()) {
            return left.peek();
        }

        return right.peek();
    }
}