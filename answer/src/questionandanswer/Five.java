package questionandanswer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//        第四题
public class Five {
    public static String organizationTree(String jsonString){
        JSONArray array = JSONArray.parseArray(jsonString);
        Map<String, List<Object>> jsonListMap = array.stream().collect(Collectors.groupingBy(item -> ((JSONObject) item).getString("parent")));
        return create(jsonListMap);
    }

    public static String create(Map<String, List<Object>> jsonListMap){
        List<Object> objects = jsonListMap.get("");
        process(jsonListMap,objects);
        JSONArray jsonArray=new JSONArray();
        objects.stream().forEach(item->jsonArray.add(item));
        return jsonArray.toString();
    }

    public static void process(Map<String, List<Object>> jsonListMap,List<Object> objects){
        if (objects!=null){
            for (Object o:objects){
                JSONObject obj=(JSONObject)o;
                List<Object> children = jsonListMap.get(obj.getString("code"));
                process(jsonListMap,children);
                if (children!=null){
                    obj.put("children",children);
                }
            }
        }
    }
}
