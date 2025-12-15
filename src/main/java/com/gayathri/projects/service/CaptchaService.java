package com.gayathri.projects.service;

import com.gayathri.projects.util.Base62Encoder;
import org.springframework.stereotype.Service;

@Service
public class CaptchaService
{
    private final Base62Encoder base62Encoder;

    public CaptchaService(Base62Encoder base62Encoder) {
        this.base62Encoder = base62Encoder;
    }

    public String createCaptcha() {
        return base62Encoder.encode();
    }
}