package server.demo.models.User;

import java.util.ArrayList;
import java.util.List;

import server.demo.models.Post.PostModel;

public class UserModel {

    private String username;
    private List<PostModel> posts;

    public UserModel(){
        posts = new ArrayList<>();

    }
    public UserModel(String username,List<PostModel> posts){
        this.username = username;
        this.posts = (posts == null) ? new ArrayList<>() : posts;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }

    public void setPosts(List<PostModel> posts){
        this.posts = posts;
    }
    public List<PostModel> getPosts(){
        return posts;
    }



}

