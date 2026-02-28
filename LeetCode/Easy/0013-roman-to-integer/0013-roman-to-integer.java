class Solution {
    public int romanToInt(String s) {
        int num = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                if(i<s.length()-1 && s.charAt(i+1)=='V'){
                    num--;
                }
                else if(i<s.length()-1 && s.charAt(i+1)=='X'){
                    num--;
                }else num++;
            }
            if(s.charAt(i)=='V') num+=5;
            if(s.charAt(i)=='L') num+=50;
            if(s.charAt(i)=='D') num+=500;
            if(s.charAt(i)=='M') num+=1000;
            if(s.charAt(i)=='X'){
                if(i<s.length()-1 && s.charAt(i+1)=='L'){
                    num-=10;
                }
                else if(i<s.length()-1 && s.charAt(i+1)=='C'){
                    num-=10;
                }else num+=10;
            }if(s.charAt(i)=='C'){
                if(i<s.length()-1 && s.charAt(i+1)=='D'){
                    num-=100;
                }
                else if(i<s.length()-1 && s.charAt(i+1)=='M'){
                    num-=100;
                }else num+=100;
            }
        }
        return num;
    }
}