package com.ex.ex1.Repository;

import com.ex.ex1.Entity.User;
import com.ex.ex1.Ex1ApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends Ex1ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setName("user01");
        user.setEmail("user01@example.com");
        user.setPhoneNumber("010-0000-0000");
        user.setRegDt(LocalDateTime.now());
        user.setRegUser("pjh5993");

        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);
        });
    }

    @Test
    @Transactional // update와 delete 시 RollBack 되는것을 확인할 수 있다.
    public void update() {
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser -> {
            selectUser.setName("modUser01");
            selectUser.setEmail("modUser01@example.com");
            selectUser.setModDt(LocalDateTime.now());
            selectUser.setModUser("pjh5993");

            User newUser = userRepository.save(selectUser);
            System.out.println("******************************************");
            System.out.println("user: " + newUser);
        });
    }

    @Test
    @Transactional // update와 delete 시 RollBack 되는것을 확인할 수 있다.
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);
        System.out.println(deleteUser.isPresent());
    }

}
