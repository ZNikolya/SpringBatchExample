package com.example.springbatchexample.batch;

import com.example.springbatchexample.model.User;
import com.example.springbatchexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DBWriter implements ItemWriter<User> {

    private final UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception{

        System.out.println("Data Saved for Users" + users);
        userRepository.saveAll(users);
    }
}
