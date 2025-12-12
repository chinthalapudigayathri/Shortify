package com.gayathri.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
public class ShortnerResponseDTO
{
    /* here we give all fields as in entity layer */
    private Long id;
    private String shortUrl;
    private String originalUrl;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}