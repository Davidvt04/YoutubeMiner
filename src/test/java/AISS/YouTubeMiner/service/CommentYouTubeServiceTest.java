package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.exception.MaxValueException;
import AISS.YouTubeMiner.model.youtube.comment.CommentYouTube;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommentYouTubeServiceTest {

    @Autowired
    CommentService service;
    @Test
    @DisplayName("Get comments from a video id")
    void findCommentsFromVideoId() {
        String prueba =  "_VB39Jo8mAQ";
        List<CommentYouTube> commentYouTubes = service.findCommentsFromVideoId(prueba, 5);
        System.out.println("Funciono + " + commentYouTubes.toString() + " :)");
    }
}