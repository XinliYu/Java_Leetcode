package UnclassifiedProblems;

public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        int n = s.length();
        char[] rst = new char[n];

        if(numRows>n||numRows<=1) return s;

        int interval = 2*numRows-2;

        int count = 0;

        for(int i = 0; i < numRows; i++){
            int step = interval-2*i;
            for(int j =i; j < n; j+=interval ){
                rst[count] = s.charAt(j);
                count++;

                if(step>0 && step< interval && j+step<n){
                    rst[count]= s.charAt(j+step);
                    count++;
                }
            }
        }
        return new String(rst);
    }

}
