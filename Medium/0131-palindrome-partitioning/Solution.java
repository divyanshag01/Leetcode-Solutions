class Solution {
    public boolean isPalendrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public void generate(List<List<String>> ans,String s,int index,List<String> temp){
        if(index==s.length()){
            ans.add(new ArrayList(temp));
            return;
        }
        for(int i = index;i<s.length();i++){
            if(isPalendrome(s.substring(index,i+1))){
                temp.add(s.substring(index,i+1));
                generate(ans,s,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        generate(ans,s,0,temp);
        return ans;
    }
}