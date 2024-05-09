package AISS.YouTubeMiner.model.videominer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author Juan C. Alonso
 */
@Entity
@Table(name = "VMUser")
public class User {

    /*
    * In order to avoid making the model unnecessarily complex, we establish a one-to-one relationship between Comment and
    * User (instead of many-to-one). This causes an exception if we try to add a Comment to the DataBase that has been
    * created by a User that already has a Comment in a previously stored Video. To avoid this exception, we automatically
    * assign an id to each new User with AutoIncrement.
     */
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("name")
    @NotEmpty(message = "User name cannot be empty")
    private String name;

    @JsonProperty("user_link")
    @NotEmpty(message = "User link cannot be empty")
    private String user_link;

    @JsonProperty("picture_link")
    @NotEmpty(message = "User picture cannot be empty")
    private String picture_link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_link() {
        return user_link;
    }

    public void setUser_link(String user_link) {
        this.user_link = user_link;
    }

    public String getPicture_link() {
        return picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user_link='" + user_link + '\'' +
                ", picture_link='" + picture_link + '\'' +
                '}';
    }

}