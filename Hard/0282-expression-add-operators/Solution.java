class Solution {
    public void generate(List<String> ans,String num,int target,int idx,long last,long sum,String temp){
        if(idx==num.length() && sum==target){
            ans.add(temp);
            return;
        }
        if(idx==num.length()){
            return;
        }
        for(int i = idx;i<num.length();i++){
            if(i>idx && num.charAt(idx)=='0'){
                break;
            }
            long cr = Long.parseLong(num.substring(idx,i+1));
            if(idx==0){
                generate(ans,num,target,i+1,cr,cr,num.substring(idx,i+1));
                continue;
            }
            generate(ans,num,target,i+1,cr,sum+cr,temp + "+" + num.substring(idx,i+1));
            generate(ans,num,target,i+1,last*cr,(sum-last)+(last*cr),temp + "*" + num.substring(idx,i+1));
            generate(ans,num,target,i+1,-cr,sum-cr,temp + "-" + num.substring(idx,i+1));
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        generate(ans,num,target,0,0,0,"");
        return ans;
    }
}