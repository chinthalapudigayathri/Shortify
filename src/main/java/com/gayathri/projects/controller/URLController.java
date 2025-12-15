package com.gayathri.projects.controller;

import com.gayathri.projects.dto.ShortnerRequestDTO;
import com.gayathri.projects.dto.ShortnerResponseDTO;
import com.gayathri.projects.exception.ErrorMessages;
import com.gayathri.projects.exception.InvalidUrlFormatException;
import com.gayathri.projects.service.URLShortnerService;
import com.gayathri.projects.util.URLValidator;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/url")
public class URLController {

    /*We are defining this so that it logs everything related to this defined class using log4j
     *instead of using system.out.println
     */
    private static final Logger logger = LogManager.getLogger(URLController.class);




    @Autowired
    private URLShortnerService urlservice;



    /* ResponseEntity is a spring wrapper HTTP response, we are sending data from ShortnerResponseDTO as a response here
    *  entire ResponseEntity<ShortnerResponseDTO> is actually a return type which means this method returns ResposneDTO
    * shortenurl is the method name
    * @RequestBody binds the entered input in json to ShortnerRequestDTO
    * and @Valid validated if the entered fields are valid according to ShortnerRequestDTO fields
     */
    @PostMapping("/shorten")
    public ResponseEntity<ShortnerResponseDTO> shortenurl(@Valid @RequestBody ShortnerRequestDTO shortnerRequestDto)
    {
    logger.info("Recieved request to shorten url:", shortnerRequestDto.getOriginalurl());

    //Verifying if the request is valid or not
        if(!URLValidator.isValid(shortnerRequestDto.getOriginalurl()))
        {
            throw new InvalidUrlFormatException(ErrorMessages.URL_FORMAT_INVALID);

        }
       //if it is  valid we assign shortneded url and then return it as response
        ShortnerResponseDTO shortnerResponseDto = urlservice.URLShortner(shortnerRequestDto);
        logger.info("shortned url is ", shortnerResponseDto.getShortUrl());


        return ResponseEntity.ok(shortnerResponseDto);

    }
/* @GetMapping gets the required details , in our case original url
* @PathVariable just takes the string from given url and then matches with the shorturl
 */
    @GetMapping("/{shorturl}")
    public ResponseEntity<Void> getOriginalURL(@PathVariable String shorturl)
    {

        String originalurl= urlservice.getOriginalURL(shorturl);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", originalurl);
        /*HTTP status code 302 (Found) means the resource you requested has been
        *temporarily moved to another URL. The server tells the client where to go next using
        *
         */
return ResponseEntity.status(302).headers(headers).build();
    }


}