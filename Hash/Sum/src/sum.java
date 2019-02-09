import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sum {
    public List<List<Integer>> findsum(int []num,int target){
       List<List<Integer>> list = new ArrayList<List<Integer>>();
       List<Integer> list_1d= new ArrayList<Integer>();
       HashMap<Integer,Pair> set = new HashMap<Integer,Pair>();
       int tmp_sum=0;
       Pair obj;
       for(int i=0; i<num.length-1;i++){
           for(int j=i+1;j<num.length;j++){
               tmp_sum = num[i]+num[j];
               set.put(tmp_sum,new obj(i,j));
           }
       }

    }
}
class Pair{
    int p1,p2;
    Pair (int a,int b){
        p1=a;
        p2=b;
    }
}


