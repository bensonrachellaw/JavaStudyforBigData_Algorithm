package ZJCampus;

import java.util.ArrayList;
import java.util.List;

public class DayFifteen2 {
    List<String> res = new ArrayList<String>();
    int n ;
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        generate("",0,0);
        return res;
    }
    public void generate(String ans,int t1,int t2){
        if(t1 > n || t2 > n) return;
        if(t1==n&&t2==n) res.add(ans);
        if(t1>=t2){ //左括号数量大于右括号数量，下一个可以用左括号也可以用右括号
            //左括号数量大于右括号数量,下一个可以用左括号,但是不能用右括号，用了也没用，止步于下一层递归。
            generate(ans+'(',t1+1,t2);
            generate(ans+')',t1,t2+1);
        }

    }

}
