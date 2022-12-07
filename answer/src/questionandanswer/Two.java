package questionandanswer;

import java.util.Collections;
import java.util.Stack;
//        第二题
public class Two {
    public static Double expr(String ... array){
        if(array==null|| array.length==0){
            throw new RuntimeException("请不要传递空对象或空值");
        }
        Stack<Double> stack=new Stack<>();
        for (String s:array){
            if (s!=null&&!s.isEmpty()){
                if (isSign(s)){
                    if (stack.size()>=2){
                        Double secondNum=stack.pop();
                        Double firstNum=stack.pop();
                        stack.push(compute(s,firstNum,secondNum));
                    }
                    else {
                        throw new RuntimeException("请检查表达式是否正确");
                    }
                }
                else {
                    stack.push(Double.parseDouble(s));
                }
            }
        }
        return stack.pop();
    }

    public static boolean isSign(String s){
        return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
    }

    public static Double compute(String sign,Double firstNum,Double secondNum){
        Double result=null;
        if (sign.equals("+")){
            result=firstNum+secondNum;
        }
        else if (sign.equals("-")){
            result=firstNum-secondNum;
        }
        else if (sign.equals("*")){
            result=firstNum*secondNum;
        }
        else if (sign.equals("/")){
            if (secondNum==0){
                throw new RuntimeException("分母不能为0");
            }
            else {
                result=firstNum/secondNum;
            }
        }
        return result;
    }
}
