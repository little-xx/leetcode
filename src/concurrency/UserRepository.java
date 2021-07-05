package concurrency;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static Map<Integer, String> map = new HashMap();

    public String getUserNameByUserId(Integer userId) {
        return map.get(userId);
    }

    public UserRepository() {
        map.put(1, "xiaoweng");
        map.put(2, "xiaotang");
    }
}
