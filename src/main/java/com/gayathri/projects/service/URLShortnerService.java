package com.gayathri.projects.service;

import com.gayathri.projects.dto.ShortnerResponseDTO;
import com.gayathri.projects.dto.ShortnerRequestDTO;

/* We create a public interface so that any class can access this interface for testing
*but since interfaces only has abstract methods, we create another class for implementation of this interface
* We provide blueprint here for unit testing without giving code logic
* and we implement the logic in another class
* every method created in an interface is an abstract method unless defined against it
 */
public interface URLShortnerService
{
ShortnerResponseDTO URLShortner (ShortnerRequestDTO shortnerrequestdto);
String getOriginalURL(String shorturl);
}