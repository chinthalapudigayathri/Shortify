package com.gayathri.projects.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/* Added Lombok annotation to avoid boilerplate code because
@Date can generate automatic getters and setters and induce them at copiletime
 */
@Data
/* DTO (Data Transfer Object) is a simple object used to carry data between layers of your application.
It does not contain logic
 */
@Getter
@Builder
public class ShortnerRequestDTO{

/* @NotBlank is a Jakarta Bean Validation annotation which can send a message when a user passes null
in data
 */
    @NotBlank(message="url is still required")
    private String originalurl;
    private String captcha;
}