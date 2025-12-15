package com.gayathri.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
public class ShortnerResponseDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /* here we give all fields as in entity layer */
    private Long id;
    private String shortUrl;
    private String originalUrl;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}