package com.javasample.UrlShortner.service;
import com.javasample.UrlShortner.repository.UrlMappingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.javasample.UrlShortner.model.UrlMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UrlShortenService {
    @Autowired
    private UrlMappingRepository  urlmap;


    public UrlMapping saveUrlMapping ( UrlMapping urlmapping){
        urlmap.save(urlmapping);
        log.info("Data has been saved to db" );
        return urlmapping;

    }
    public List<UrlMapping> findurls() {
        var messages=urlmap.findAll();


        return messages;
    }
}
