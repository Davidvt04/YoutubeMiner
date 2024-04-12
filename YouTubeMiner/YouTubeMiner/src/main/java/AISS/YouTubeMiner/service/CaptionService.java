package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.caption.Caption;
import AISS.YouTubeMiner.model.youtube.caption.CaptionSearch;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;

    private final static String token = "AIzaSyDXPg4TzNK6g0cl3c3MWC5_k5Sq1JynN94";
    public List<Caption> findCaptionsFromVideo(String videoId){
        String uri = "https://youtube.googleapis.com/youtube/v3/captions?part=snippet&videoId=" + videoId +"&key=" + token;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-goog-api-key", token);

        HttpEntity<CaptionSearch> request = new HttpEntity<>(null,headers);
        ResponseEntity<CaptionSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionSearch.class);

        assert response.getBody() != null;
        return response.getBody().getItems();
    }

}
