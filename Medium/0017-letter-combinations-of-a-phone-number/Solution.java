class Solution {
    public void generate(String digits,String arr[],int index,String current,List<String> ans){
        if(index==digits.length()){
            ans.add(new String(current));
            return;
        }
        String word = arr[digits.charAt(index)-'0'];
        for(int i = 0;i<word.length();i++){
            generate(digits,arr,index+1,current+word.charAt(i),ans);        
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 
        generate(digits,arr,0,"",ans);
        return ans;
    }
}