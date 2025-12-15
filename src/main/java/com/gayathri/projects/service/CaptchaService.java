package com.gayathri.projects.service;

import com.gayathri.projects.util.Base62Encoder;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class CaptchaService
{
    private final Base62Encoder base62Encoder;

    public CaptchaService(Base62Encoder base62Encoder) {
        this.base62Encoder = base62Encoder;

    }

    public String createCaptcha(HttpSession session) {
        String captcha = base62Encoder.encode();
        session.setAttribute("CAPTCHA", captcha);
        return captcha;
    }

    public boolean validateCaptcha(String userCaptcha, HttpSession session) {
        String storedCaptcha = (String) session.getAttribute("CAPTCHA");

        if (storedCaptcha == null) {
            return false;
        }

        // One-time use captcha
        session.removeAttribute("CAPTCHA");

        return storedCaptcha.equals(userCaptcha);
    }
}