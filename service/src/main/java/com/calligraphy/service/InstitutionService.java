package com.calligraphy.service;


import com.calligraphy.common.netbean.PagingParam;
import org.springframework.http.ResponseEntity;

public interface InstitutionService {
    ResponseEntity selectInstitutionOverview(PagingParam pagingParam);

    ResponseEntity selectInstitutionById(Integer institutionId);

    ResponseEntity selectInstitutionAchievementByPage(Integer institutionId, PagingParam pagingParam);

    ResponseEntity selectInstitutionEnvironmentByPage(Integer institutionId, PagingParam pagingParam);

    ResponseEntity selectInstitutionTeacherByPage(Integer institutionId, PagingParam pagingParam);

    ResponseEntity selectInstitutionPrincipalQuote(Integer institutionId);

    ResponseEntity selectInstitutionCourseOverviewByPage(Integer institutionId, PagingParam pagingParam);

    ResponseEntity selectInstitutionCourseById(Integer institutionCourseId);

    ResponseEntity selectInstitutionActivityOverviewByPage(Integer institutionId, PagingParam pagingParam);

    ResponseEntity selectInstitutionActivityById(Integer institutionActivityId);
}
