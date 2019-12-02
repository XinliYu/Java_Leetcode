package sortingProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class hmm {

    int[][] data = {{36, 44, 52, 56, 49, 44}, {42, 46, 54, 62, 68, 65, 60, 56}, {42, 40, 41, 43, 52, 55, 59, 60, 55, 47}};


    public int[][] baumwelch(){
        int[][] left_boundary = {{1,3}, {2,5}, {2, 5}};




        for (int i = 0; i< 50; i++) {

            Set<Integer> state1 = new HashSet<Integer>();
            Set<Integer> state2 = new HashSet<Integer>();

            Set<Integer> state3 = new HashSet<Integer>();

            // from boundary update state
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < left_boundary[j][0] + 1; k++) {
                    state1.add(data[j][k]);
                }
            }

            for (int j = 0; j < 3; j++) {
                for (int k = left_boundary[j][0] + 1; k < left_boundary[j][1] + 1; k++) {
                    state2.add(data[j][k]);
                }
            }

            for (int j = 0; j < 3; j++) {
                for (int k = left_boundary[j][1] + 1; k < data[j].length; k++) {
                    state3.add(data[j][k]);
                }
            }


            //from state calculate variance
            double[] state1_stat = mean_std(state1);
            double[] state2_stat = mean_std(state2);
            double[] state3_stat = mean_std(state3);

            int[][] new_boundary = update_boundary(left_boundary, state1_stat, state2_stat, state3_stat);

            left_boundary = new_boundary;


        }

        return left_boundary;


    }


    public int[][] update_boundary(int[][] left_boundary, double[] state1_stat, double[] state2_stat, double[] state3_stat){
        //from vairance update boundary
        for(int i = 0; i< 3; i++) {
            while ((data[i][left_boundary[i][0]] - state1_stat[0]) / state1_stat[1] > (data[i][left_boundary[i][0]] - state2_stat[0]) / state2_stat[1] && left_boundary[i][0] > 0) {
                left_boundary[i][0]--;
            }
            while ((data[i][left_boundary[i][0]+1] - state1_stat[0])  / state1_stat[1] < (data[i][left_boundary[i][0]+1] - state2_stat[0]) / state2_stat[1] ){
                left_boundary[i][0]++;
            }
        }

        for(int i = 0; i< 3; i++) {
            while ((data[i][left_boundary[i][1]] - state2_stat[0]) / state2_stat[1] > (data[i][left_boundary[i][0]] - state3_stat[0]) / state3_stat[1] ) {
                left_boundary[i][0]--;
            }
            while ((data[i][left_boundary[i][1]+1] - state2_stat[0])  / state2_stat[1] < (data[i][left_boundary[i][0]+1] - state3_stat[0]) / state3_stat[1] && left_boundary[i][1] < data[i].length-2){
                left_boundary[i][0]++;
            }
        }

        return left_boundary;
    }

    public double[] mean_std(Set<Integer> data) {
        int total_length = data.size();
        double total = 0;
        double total_square = 0;

        for (int i:data) {
            total += i;
            total_square += Math.pow(i, 2);
        }
        double mean = total / total_length;
        double var = total_square / total_length - Math.pow(mean, 2);
        double std = Math.sqrt(var);

        double[] rst = {mean, std};
        return rst;
    }

    public static void main(String[] args){
        hmm sol = new hmm();
        int[][] ans = sol.baumwelch();
        System.out.println(ans);
    }

}
