package com.calligraphy.service;

import org.springframework.http.ResponseEntity;

public interface LetterService {
    ResponseEntity selectLetterSampleByFontType(String letter, Integer fontType);
}
