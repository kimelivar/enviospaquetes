package com.example.envios;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AfterShipService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_KEY = "asat_100a66300abd4784ad3680f5cf61324a";
    private final String BASE_URL = "https://api.aftership.com/v4";

    public String getTrackingInfo(String carrierSlug, String trackingId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("aftership-api-key", API_KEY);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = BASE_URL + "/trackings/" + carrierSlug + "/" + trackingId;
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}


