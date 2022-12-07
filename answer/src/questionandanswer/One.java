package questionandanswer;

//        第一题
public class One {

    public static String reverse(String s){
        if (s!=null){
            if(s.isEmpty()){
                return s;
            }else{
                return reverse(s.substring(1))+s.charAt(0);
            }
        }
        throw new RuntimeException("请勿传递空对象") ;
    }
}
