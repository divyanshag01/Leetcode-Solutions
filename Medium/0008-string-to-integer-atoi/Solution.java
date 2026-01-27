class Solution {
    public int atoi(String s,int i, int sign,long nums){
        if(i>=s.length() || !Character.isDigit(s.charAt(i))){
            nums = nums*sign;
            if(nums>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(nums<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return (int)nums;
        }
        
        nums = nums*10 + (s.charAt(i)-'0');
        if(sign == 1 && nums>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(sign == -1 && -nums<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return atoi(s,i+1,sign,nums);
        // return nums*sign;


    }
    public int myAtoi(String s) {
        int i = 0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        int sign = 1;
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if(s.charAt(i)=='+'){
                sign = 1;
            }else sign = -1;
            i++;
        }
        return atoi(s,i,sign,0);
    }
}