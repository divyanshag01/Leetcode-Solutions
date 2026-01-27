class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String arr[] =s.split(" ");
        String a = "";
        for(int i = arr.length-1;i >=0;i--){
            if(arr[i].equals(" ") || arr[i].isEmpty()){
                continue;
            }
            a+= arr[i];
            if(i!=0){
            a+=" ";
            }
        }
        return a;
    }
}