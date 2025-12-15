package com.gayathri.projects.util;


import org.springframework.stereotype.Component;


import java.net.MalformedURLException;
import java.net.URL;

@Component
public class URLGenerator
{


public String shorten(String longUrl)

{

    if (longUrl == null || longUrl.isBlank()) {
        throw new IllegalArgumentException("Invalid URL format");
    }
    try{
        URL url=new URL(longUrl);
        //checking if the url has http/https if not we will throw an error to avoid having invalid urls
        String protocol =url.getProtocol();
        if (!(protocol.equals("http") || protocol.equals("https"))) {
            throw new IllegalArgumentException("Only http/https URLs are allowed: " + longUrl);
        }
        //checking if the host is empty or not , if it is empty we throw an error to avoid invalid urls
        String host = url.getHost();
        if (host == null || host.isEmpty()) {
            throw new IllegalArgumentException("Invalid host in URL: " + longUrl);
        }

        //splits host whever it finds . and returns an array of different strings
        String[] parts=host.split("\\.");
        // we return the first of our subdomain
        return parts[0];

    }
    //if still something is missed in our validation we can catch invalid urls here in catch statement
    catch (MalformedURLException e) {
    throw new IllegalArgumentException("Invalid URL format: " + longUrl, e);
}

}
}