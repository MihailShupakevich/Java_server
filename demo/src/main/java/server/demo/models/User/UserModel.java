package server.demo.models.User;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import server.demo.models.Post.PostModel;

@Entity
@Table(name = "users") // Убедитесь, что имя таблицы совпадает с вашей базой данных
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент для userId
    private Integer userId;

    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostModel> posts;

    public UserModel() {
        posts = new ArrayList<>();
    }

    public UserModel(String username, Integer userId) {
        this.username = username;
        this.userId = userId;
        this.posts = new ArrayList<>();
    }

    public Integer getUserById() {
        return userId;
    }

    public void setUserById(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PostModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }
}