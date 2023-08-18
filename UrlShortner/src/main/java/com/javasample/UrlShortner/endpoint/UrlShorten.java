package com.javasample.UrlShortner.endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.javasample.UrlShortner.service.UrlShortenService;
import com.javasample.UrlShortner.model.UrlMapping;

@RestController
@Slf4j
public class UrlShorten {
    @Autowired
    private UrlShortenService urlshortenservice;
    @PostMapping("/shorturl")
    @ResponseBody
    public String UrlGenerator(@RequestBody UrlMapping urlmapping){
        log.info("retrieving URL {}",urlmapping);
        try {

//             Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(urlmapping.getOriginalurl().getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            log.info("MD5 generated hash user {}",hashtext );
            urlmapping.setShortenurl(hashtext);
            urlshortenservice.saveUrlMapping( urlmapping);
            return hashtext;
        }
//         For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/getallurl")
    public List<UrlMapping> GetShortUrl(){
        log.info("Getting all the URL shortner url");
        return urlshortenservice.findurls();
    }

    }


