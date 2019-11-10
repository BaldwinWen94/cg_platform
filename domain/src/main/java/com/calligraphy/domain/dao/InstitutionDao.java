package com.calligraphy.domain.dao;

import com.calligraphy.domain.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InstitutionDao {
    List<Institution> selectInstitutionByPage(Integer pageStart,
                                              Integer pageSize);

    Institution selectInstitutionById(Integer institutionId);

    List<InstitutionAchievement> selectInstitutionAchievementByPage(Integer institutionId,
                                                                    Integer pageStart,
                                                                    Integer pageSize);

    List<InstitutionEnvironment> selectInstitutionEnvironmentByPage(Integer institutionId,
                                                                    Integer pageStart,
                                                                    Integer pageSize);

    List<InstitutionTeacher> selectInstitutionTeacherByPage(Integer institutionId,
                                                            Integer pageStart,
                                                            Integer pageSize);

    InstitutionPrincipalQuote selectPrincipalQuoteOfInstitution(Integer institutionId);

    List<InstitutionCourse> selectInstitutionCourseByPage(Integer institutionId,
                                                          Integer pageStart,
                                                          Integer pageSize);

    InstitutionCourse selectInstitutionCourseById(Integer institutionCourseId);

    List<InstitutionActivity> selectInstitutionActivityByPage(Integer institutionId,
                                                              Integer pageStart,
                                                              Integer pageSize);

    InstitutionActivity selectInstitutionActivityById(Integer institutionActivityId);
}
