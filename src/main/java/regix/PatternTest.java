package regix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    private final static Pattern codePattern = Pattern.compile("code.*:(\\d+)");
    private final static Pattern dataPattern = Pattern.compile("data\\\\\":\\\\\"([\\s\\S]*)\\\\\"}");

    public static void main(String[] args) {

        String message = "status 503 reading AnnouncementClient#getAnnouncements(long,int); content:\n" +
                "{\"timestamp\":1608641096190,\"status\":503,\"error\":\"Service Unavailable\"," +
                "\"exception\":\"cn.*.common.starter.core.ErrorCodeException\"," +
                "\"message\":\"{\\\"code\\\":1007,\\\"data\\\":\\\"tetsffnr123\\\\nssdd\\\"}\"," +
                "\"path\":\"/inner/affair/announcements\"}";

        Matcher codeMather = codePattern.matcher(message);
        if (codeMather.find()) {
            System.out.println(codeMather.group(0));
            System.out.println(codeMather.group(1));
        }
        Matcher dataMatcher = dataPattern.matcher(message);
        if (dataMatcher.find()) {
            System.out.println(dataMatcher.group(0));
            System.out.println(dataMatcher.group(1));
        }
    }

}
