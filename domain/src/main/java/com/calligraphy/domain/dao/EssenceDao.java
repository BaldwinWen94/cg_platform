package com.calligraphy.domain.dao;


import com.calligraphy.domain.entity.Essence;
import com.calligraphy.domain.entity.EssenceType;
import com.calligraphy.domain.result.EssenceResult;

import java.util.List;

public interface EssenceDao {
    List<EssenceType> selectAllEssenceType();

    EssenceType selectEssenceTypeByCondition(String type1,
                                             String type2);

    void createEssenceType(EssenceType essenceType);

    List<EssenceResult> selectEssenceByCondition(String type1,
                                                 String type2,
                                                 String wordCount,
                                                 String dynasty,
                                                 Integer offset,
                                                 Integer size);

    Essence selectEssenceById(Integer essenceId);

    Integer countEssenceByCondition(String type1,
                                    String type2,
                                    String wordCount,
                                    String dynasty);

    void createEssence(Essence essence);

    void updateEssence(Essence essence);

    void deleteEssence(Integer essenceId);
}
