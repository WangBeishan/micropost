package ml.sunmonkey.micropost.controller;

import ml.sunmonkey.micropost.common.Result;
import ml.sunmonkey.micropost.common.ResultGenerator;
import ml.sunmonkey.micropost.common.ServiceResultEnum;
import ml.sunmonkey.micropost.model.User;
import ml.sunmonkey.micropost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        String result = userService.addUser(user);

        if (result.equals(ServiceResultEnum.SUCCESS_MESSAGE.name())) {
            return new ResultGenerator().successResult(result);
        }
        return new ResultGenerator().errorResult(result);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println(user.getEmail() + " - " + user.getPassword());
        String result = userService.login(user.getEmail(), user.getPassword());

        if (result.equals(ServiceResultEnum.SUCCESS_MESSAGE.name())) {
            return new ResultGenerator().successResult();
        }
        return new ResultGenerator().errorResult(result);
    }

    @PostMapping("/logout")
    public Result logout(@RequestParam("id") Long id) {
        String result = userService.logout(id);

        if (result.equals(ServiceResultEnum.SUCCESS_MESSAGE.name())) {
            return new ResultGenerator().successResult();
        }
        return new ResultGenerator().errorResult();
    }

    @GetMapping("/users")
    public Result getUsers() {
        List<User> users = userService.getUsers();
        return new ResultGenerator<List<User>>().successResult(users);
    }
}
