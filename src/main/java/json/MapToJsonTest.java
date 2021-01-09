package json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class MapToJsonTest {

    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<>();
        data.put("test", "<b>123455</b>");
        String s = JSON.toJSONString(data);
        System.out.println(s);

    }

}
