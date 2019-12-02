package UnclassifiedProblems;

public class ReverseInteger7 {
    public int reverse(int x){
        int rst = 0;

        while (x!=0){

            int tmp = rst * 10 + x%10;
            if(tmp/10 != rst) return 0;
            rst = tmp;
            x/=10;

        }

        return rst;
    }
}
