package ExamRY;
import java.util.*;
public class Main1 {
    public static HashSet<String> set = new HashSet<>();
    public static HashSet<Character> set1 = new HashSet<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        set.add("AND");
        set.add("OR");
        for (int i = 97;i<=122;i++){
            set1.add((char)i);
        }
        while (reader.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = reader.nextLine();
            String[] arr = s.split(" ");
            int tag = 0;
            if (arr.length == 2) {
                if (! arr[0].equals("NOT")){
                    tag = 1;
                }
                else {
                    if (arr[1].length()>1){
                        tag = 1;
                    }
                    else {
                        if (arr[1].charAt(0)<'a' || arr[1].charAt(0)>'z'){
                            tag = 1;
                        }
                    }

                }
            }
            else if (arr.length==1){
                if (arr[0].length()==1 && set1.contains(arr[0].charAt(0))){

                }
                else {
                    tag = 1;
                }
            }
            else {
                for (int i = 0;i<arr.length-1;i++) {
                    if (arr[i].length()==1 || arr[i].length()==3 || arr[i].length()==2){
                        if (i==0 && (arr[i].length()!=1 && arr[i].length()!=3)){
                            tag = 1;
//                            System.out.println("x");
                            break;
                        }
                        if (arr[i].length()==1&&set1.contains(arr[i].charAt(0))&&set.contains(arr[i+1])){

                        }
//                        else if (arr[i].length()!=1&&set1.contains(arr[i+1].charAt(0))){
//
//                        }
                        else if (set.contains(arr[i])&&arr[i+1].equals("NOT")){

                        }
                        else if (set.contains(arr[i])&&arr[i+1].length()==1&&set1.contains(arr[i+1].charAt(0))){

                        }
                        else if (arr[i].equals("NOT")&&arr[i+1].length()==1&&set1.contains(arr[i+1].charAt(0))){

                        }
                        else {
                            tag = 1;
                            break;
                        }
                    }
                    else {
                        tag = 1;
                        break;
                    }
                }
            }
            if (tag==0){
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }

        }
    }
}
