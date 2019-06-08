package json;

import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.convert.impl.Jdk8DateConverter;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.util.List;

public class JSONArrayNull {

    public static void main(String[] args) {

        String jsonArray = "[{\"routionId\":8,\"id\":3,\"tenantId\":1,\"processId\":9,\"processName\":null," +
                "\"createTime\":\"2019-05-30 08:55:42\",\"extInfo\":null}," +
                "{\"routionId\":8,\"id\":4,\"tenantId\":1,\"processId\":10,\"processName\":null," +
                "\"createTime\":\"2019-05-30 08:55:42\",\"extInfo\":null}," +
                "{\"routionId\":8,\"id\":7,\"tenantId\":1,\"processId\":17,\"processName\":\"外圈-精车2\"," +
                "\"createTime\":\"2019-06-07 22:09:09\",\"extInfo\":null},{\"processId\":15}]";
        try {
            ConverterRegistry.getInstance().putCustom(LocalDateTime.class, new Jdk8DateConverter(LocalDateTime.class, "yyyy-MM-dd HH:mm:ss"));
            List<RoutionProcessDto> routionProcessDtos = JSONUtil.parseArray(jsonArray).toList(RoutionProcessDto.class);
            System.out.println(routionProcessDtos);
        } catch (Exception e) {
            e.printStackTrace();
        }



        List<RoutionProcessDto> routionProcessDtos1 = JSON.parseArray(jsonArray, RoutionProcessDto.class);
        System.out.println(routionProcessDtos1);

    }

}
