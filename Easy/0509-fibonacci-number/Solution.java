class Solution {
    public int fib(int n) {
        int first = 0;
        int second = 1;
        int next=1;
        while(n>1){
            next = first+second;
            first = second;
            second = next;
            n--;
        }
        return (n>0) ? next:0;
    }
}