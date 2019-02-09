import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindDuplicate {
    public boolean sudocu(char [][]board){
        HashSet<Character>set = new HashSet<>();
        int block_index=0;
        int row_up=0;
        int row_down=0;
        int col_left=0;
        int col_right=0;
        while(block_index<9){
            switch(block_index){
                case 0:{
                    row_up=0;
                    row_down=2;
                    col_left=0;
                    col_right=2;
                    break;
                }
                case 1:{
                    row_up=0;
                    row_down=2;
                    col_left=3;
                    col_right=5;
                    break;
                }
                case 2:{
                    row_up=0;
                    row_down=2;
                    col_left=6;
                    col_right=8;
                    break;
                }
                case 3:{
                    row_up=3;
                    row_down=5;
                    col_left=0;
                    col_right=2;
                    break;
                }
                case 4:{
                    row_up=3;
                    row_down=5;
                    col_left=3;
                    col_right=5;
                    break;
                }
                case 5:{
                    row_up=3;
                    row_down=5;
                    col_left=6;
                    col_right=8;
                    break;
                }
                case 6:{
                    row_up=6;
                    row_down=8;
                    col_left=0;
                    col_right=2;
                    break;
                }
                case 7:{
                    row_up=6;
                    row_down=8;
                    col_left=3;
                    col_right=5;
                    break;
                }
                case 8:{
                    row_up=6;
                    row_down=8;
                    col_left=6;
                    col_right=8;
                    break;
                }
            }
            for(int row=row_up;row<=row_down;row++){
                for(int col=col_left;col<=col_right;col++){
                    if(board[row][col]!='.'){
                            if(set.contains(board[row][col])){
                                return false;
                            }
                            else{
                                set.add(board[row][col]);
                            }
                    }
                }
            }
            set.clear();
            block_index++;
        }
        set.clear();
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++) {
                if (board[row][col] != '.') {
                    if(set.contains(board[row][col])){
                        return false;
                    }
                    else{
                        set.add(board[row][col]);
                    }
                }
            }
            set.clear();
        }
        for(int col=0;col<9;col++){
            for(int row=0;row<9;row++) {
                if (board[row][col] != '.') {
                    if(set.contains(board[row][col])){
                        return false;
                    }
                    else{
                        set.add(board[row][col]);
                    }
                }
            }
            set.clear();
        }
        return true;
    }
    public int findNonDuplicate(int []num){
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < num.length; i++){
            if(map.containsKey(num[i])){
                count = map.get(num[i]);
                map.put(num[i], count + 1);
            }
            else{
                map.put(num[i], 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            // if frequency is more than 1
            // print the element
            if(entry.getValue() == 1){
               // System.out.print(entry.getKey()+ " ");
                return entry.getKey();
            }
        }
        return -1;
    }
    public int findstring(String s){
        char []tmp=s.toCharArray();
        Map<Character,Integer> set = new HashMap<>();
        int countA=0;
        int max=0;
        int remain=0;
        int index=0;
        for(int i=0;i<s.length();i++){
            if(set.containsKey(tmp[i])){
                if(countA>max){
                    max=countA;
                }
                index=set.get(tmp[i]);
                remain=i-index-1;
                if(countA>remain){
                    countA=remain+1;
                }
                else{
                    countA++;
                }
                set.put(tmp[i],i);
            }
            else{
                countA++;
                set.put(tmp[i],i);
            }

        }
        if(countA>max){
            return countA;
        }
        else{
            return max;
        }
    }
    public static void main(String[] args){
        //String s= 'abcabcbb';
        String s= "pwwkew";
        FindDuplicate f = new FindDuplicate();
        int num=f.findstring(s);
        //System.out.println(num);

        FindDuplicate ff = new FindDuplicate();
        //char [][]temp={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char [][]temp={{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        boolean bb=ff.sudocu(temp);
        //System.out.println(bb);
        int []AA={4,1,2,2,1};
        int val=ff.findNonDuplicate(AA);
        System.out.println(val);

    }
}
