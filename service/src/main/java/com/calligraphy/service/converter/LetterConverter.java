package com.calligraphy.service.converter;

import com.calligraphy.domain.entity.Letter;
import com.calligraphy.service.netbean.letter.LetterSampleDto;

public class LetterConverter {
    public static LetterSampleDto convertToSampleDto(Letter letter) {
        LetterSampleDto sampleDto = new LetterSampleDto();
        sampleDto.setLetterSampleAuthor(letter.getLetterSampleAuthor());
        sampleDto.setLetterSampleImage(letter.getLetterSampleImage());
        sampleDto.setLetterSampleDynasty(letter.getLetterSampleDynasty());
        return sampleDto;
    }
}
