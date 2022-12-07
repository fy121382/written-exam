package questionandanswer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

//        第四题
public class Four {
    public static String removeRepeat(String jsonString){
        JSONArray array = JSONArray.parseArray(jsonString.trim());
        Map<String,String> map=new HashMap<>();
        for (int i=0;i<array.size();i++){
            JSONObject o = (JSONObject)array.get(i);
            if (map.containsKey(o.getString("serial"))){
                array.remove(i);
                i--;
            }
            else {
                map.put(o.getString("serial"),"1");
            }
        }
        return array.toJSONString();
    }
}
