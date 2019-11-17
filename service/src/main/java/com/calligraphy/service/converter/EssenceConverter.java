package com.calligraphy.service.converter;


import com.calligraphy.domain.entity.Essence;
import com.calligraphy.domain.entity.EssenceType;
import com.calligraphy.domain.result.EssenceResult;
import com.calligraphy.service.netbean.essence.EssenceDto;

public class EssenceConverter {
    public static EssenceDto toDto(final EssenceResult essenceResult) {
        EssenceDto dto = new EssenceDto();
        dto.setEssenceId(essenceResult.getEssenceId());
        dto.setEssenceText(essenceResult.getEssenceText());
        dto.setEssenceType1(essenceResult.getEssenceType1());
        dto.setEssenceType2(essenceResult.getEssenceType2());
        dto.setEssenceDynasty(essenceResult.getEssenceDynasty());
        dto.setEssenceSource(essenceResult.getEssenceSource());
        dto.setWordCount(essenceResult.getWordCount());
        dto.setEssenceDesc(essenceResult.getEssenceDesc());
        return dto;
    }

    public static Essence toEntity(final EssenceDto dto, final EssenceType essenceType) {
        Essence essence = new Essence();
        return toEntity(dto, essenceType, essence);
    }

    public static Essence toEntity(final EssenceDto dto, final EssenceType essenceType, Essence essence) {
        essence.setEssenceText(dto.getEssenceText());
        essence.setEssenceTypeId(essenceType.getId());
        essence.setWordCount(dto.getWordCount());
        essence.setEssenceSource(dto.getEssenceSource());
        essence.setEssenceDesc(dto.getEssenceDesc());
        return essence;
    }
}
