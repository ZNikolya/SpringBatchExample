package com.example.springbatchexample.batch;

import com.example.springbatchexample.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPT_NAME =
            new HashMap<>();

    public Processor() {
        DEPT_NAME.put("001", "Technology");
        DEPT_NAME.put("002", "Operations");
        DEPT_NAME.put("003", "Accounts");
    }

    @Override
    public User process(User user) throws Exception {

        String deptCode=user.getDept();
        String dept = DEPT_NAME.get(deptCode);
        user.setDept(dept);
        user.setTime(new Date());
        System.out.println(String.format("Converted from [%s] to [%s}", deptCode,dept));
        return user;
    }
}
