package com.gayathri.projects.service;

import com.gayathri.projects.dto.ShortnerRequestDTO;
import com.gayathri.projects.dto.ShortnerResponseDTO;

public interface URLShortnerServiceTest
{
    ShortnerResponseDTO shortenUrl(ShortnerRequestDTO shortenRequestDto);
    String getOriginalUrl(String shortUrl);
}