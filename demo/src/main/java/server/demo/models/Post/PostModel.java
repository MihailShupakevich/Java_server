package server.demo.models.Post;

import jakarta.persistence.*;
import server.demo.models.User.UserModel;

@Entity
@Table(name = "posts") // Убедитесь, что имя таблицы совпадает с вашей базой данных
public class PostModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент для postId
   private Integer postId;

   private String description;
   private String imageUrl;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false) // Связь с UserModel
   private UserModel user;

   public PostModel() {
   }

   public PostModel(String description, String imageUrl, UserModel user) {
      this.description = description;
      this.imageUrl = imageUrl;
      this.user = user;
   }

   public Integer getPostId() {
      return postId;
   }

   public void setPostId(Integer postId) {
      this.postId = postId;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public UserModel getUser () {
      return user;
   }

   public void setUser (UserModel user) {
      this.user = user;
   }
}