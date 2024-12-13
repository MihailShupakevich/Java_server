package server.demo.controller;


import org.springframework.web.bind.annotation.*;
import server.demo.models.Post.PostModel;
import server.demo.models.User.UserModel;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

//    @GetMapping
//    public String index(@RequestParam("name") String name) {
//        return "Hello World"+name;
//    }
//    @GetMapping("/full")
//    public String full(@RequestParam("name") String name,
//                       @RequestParam("surname") String surname) {
//        return "Hello "+name+" "+surname;
//    }
//    @GetMapping("/{name}")
//    public String name(@PathVariable String name) {
//        return "Hello "+name;
//    }

    private final static List<UserModel> users = new ArrayList<>();
    @PostMapping("")
    public UserModel addUser(@RequestBody UserModel user) {
        users.add(user);
        return user;
    }

    @GetMapping("")
    public List<UserModel> getUsers() {
        return users;
    }

    @GetMapping("/{username}")
    public UserModel getUserByUsername(@PathVariable("username") String username) {
        return users.stream().filter(user -> user.getUsername().equals(username))
                .findFirst().get();
    }

    @PutMapping("/{username}")
    public PostModel update(@PathVariable("username") String username, @RequestBody PostModel post) {
        users.stream().filter(user ->
                        user.getUsername().equals(username))
                .findAny()
                .ifPresent(user -> user.getPosts().add(post));
        return post;
    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        users.stream().filter(user ->
                        user.getUsername().equals(username))
                .findAny()
                .ifPresent(users::remove);
        return "User with username: " + username + " has been deleted";
    }

}

