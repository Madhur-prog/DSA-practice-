class Solution {
    public String[] assignUmbrella(int[] rain) {
        int a=0;
        int b=0;
        int n=rain.length;
        String[] ans = new String[n];
        for (int i=0;i<rain.length-1;i++){
            if (rain[i] ==1&& rain[i + 1] == 1){
               if(a<=b){
                ans[i]="Alice";
                a++;
               }
               else{
                ans[i]="Bob";
                b++;

               }
              }else if (rain[i]==1){
                ans[i]="Bob";
                b++;

              }else{
                ans[i]="None";
              }
        }
           if (rain[n-1]==1){
            ans[n-1]="Bob";
        }else{
             ans[n - 1] = "None";
        }
         return ans;
    }
}