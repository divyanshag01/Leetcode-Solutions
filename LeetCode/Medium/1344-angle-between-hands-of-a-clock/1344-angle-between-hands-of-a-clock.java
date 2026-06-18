class Solution {
    public double angleClock(int hour, int minutes) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int angle = 30;
        for(int i = 1;i<12;i++){
            map.put(i,angle);
            angle+=30;
        }
        map.put(12,0);
        double min = minutes*6;
        double minu = (double)minutes; 
        double h = ((double)(minu/60)*30)+(double)map.get(hour);
        // System.out.print(min+" "+h);
        // int ans = (minutes*6)-(map.get(hour)+((minutes/60)*30));
        if(Math.abs(min-h)>180){
            if(min>h){
                return (360-min)+h;
            }else{
                return (360-h)+min;
            }
        }return Math.abs(h-min);
    }
}