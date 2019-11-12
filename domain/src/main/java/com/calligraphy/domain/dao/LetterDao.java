package com.calligraphy.domain.dao;

import com.calligraphy.domain.entity.Letter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LetterDao {
    List<Letter> selectLetterSampleByFontType(String singleLetter, Integer fontType);
}
