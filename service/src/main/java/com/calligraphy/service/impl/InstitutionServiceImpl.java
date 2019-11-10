package com.calligraphy.service.impl;

import com.calligraphy.common.netbean.PagingParam;
import com.calligraphy.common.util.HttpUtil;
import com.calligraphy.domain.dao.InstitutionDao;
import com.calligraphy.domain.entity.*;
import com.calligraphy.service.InstitutionService;
import com.calligraphy.service.converter.InstitutionConverter;
import com.calligraphy.service.netbean.institution.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionDao institutionDao;

    @Autowired
    public InstitutionServiceImpl(InstitutionDao institutionDao) {
        this.institutionDao = institutionDao;
    }

    @Override
    public ResponseEntity selectInstitutionOverview(PagingParam pagingParam) {
        List<Institution> institutionList = institutionDao.selectInstitutionByPage(
                pagingParam.getOffset(), pagingParam.getSize());

        List<InstitutionOverviewDto> overviewDtoList = institutionList.stream().map(institution -> {
            List<InstitutionEnvironment> environmentList = institutionDao.selectInstitutionEnvironmentByPage(
                    institution.getId(), 0, 3);
            List<String> imageList = environmentList.stream().filter(Objects::nonNull)
                    .map(InstitutionEnvironment::getEnvironmentImage).collect(Collectors.toList());
            return InstitutionConverter.toOverviewDto(institution, imageList);
        }).collect(Collectors.toList());
        return HttpUtil.successWithData(overviewDtoList);
    }

    @Override
    public ResponseEntity selectInstitutionById(Integer institutionId) {
        Institution institution = institutionDao.selectInstitutionById(institutionId);
        if (institution == null) {
            return HttpUtil.resourceNotFound();
        }

        InstitutionDto dto = InstitutionConverter.toDto(institution,
                institutionDao.selectInstitutionAchievementByPage(institutionId, 0, 1),
                institutionDao.selectInstitutionEnvironmentByPage(institutionId, 0, 3),
                institutionDao.selectInstitutionTeacherByPage(institutionId, 0, 3),
                institutionDao.selectPrincipalQuoteOfInstitution(institutionId),
                institutionDao.selectInstitutionCourseByPage(institutionId, 0, 1),
                institutionDao.selectInstitutionActivityByPage(institutionId, 0, 2));

        return HttpUtil.successWithData(dto);
    }

    @Override
    public ResponseEntity selectInstitutionAchievementByPage(Integer institutionId, PagingParam pagingParam) {
        List<InstitutionAchievement> achievementList = institutionDao.selectInstitutionAchievementByPage(
                institutionId, pagingParam.getOffset(), pagingParam.getSize());

        List<InstitutionAchievementDto> achievementDtoList = achievementList.stream()
                .map(InstitutionConverter::toAchievementDto).collect(Collectors.toList());
        return HttpUtil.successWithData(achievementDtoList);
    }

    @Override
    public ResponseEntity selectInstitutionEnvironmentByPage(Integer institutionId, PagingParam pagingParam) {
        List<InstitutionEnvironment> environmentList = institutionDao.selectInstitutionEnvironmentByPage(institutionId,
                pagingParam.getOffset(), pagingParam.getSize());

        List<InstitutionEnvironmentDto> environmentDtoList = environmentList.stream()
                .map(InstitutionConverter::toEnvironmentDto).collect(Collectors.toList());
        return HttpUtil.successWithData(environmentDtoList);
    }

    @Override
    public ResponseEntity selectInstitutionTeacherByPage(Integer institutionId, PagingParam pagingParam) {
        List<InstitutionTeacher> teacherList = institutionDao.selectInstitutionTeacherByPage(institutionId,
                pagingParam.getOffset(), pagingParam.getSize());

        List<InstitutionTeacherDto> teacherDtoList = teacherList.stream().map(InstitutionConverter::toTeacherDto)
                .collect(Collectors.toList());
        return HttpUtil.successWithData(teacherDtoList);
    }

    @Override
    public ResponseEntity selectInstitutionPrincipalQuote(Integer institutionId) {
        InstitutionPrincipalQuote principalQuote = institutionDao.selectPrincipalQuoteOfInstitution(
                institutionId);
        if (principalQuote == null) {
            return HttpUtil.successWithNoData();
        } else {
            InstitutionPrincipalQuoteDto quoteDto = InstitutionConverter.toPrincipalQuoteDto(principalQuote);
            return HttpUtil.successWithData(quoteDto);
        }
    }

    @Override
    public ResponseEntity selectInstitutionCourseOverviewByPage(Integer institutionId, PagingParam pagingParam) {
        List<InstitutionCourse> courseList = institutionDao.selectInstitutionCourseByPage(institutionId,
                pagingParam.getOffset(), pagingParam.getSize());

        List<InstitutionCourseOverviewDto> overviewDtoList = courseList.stream()
                .map(InstitutionConverter::toCourseOverviewDto).collect(Collectors.toList());
        return HttpUtil.successWithData(overviewDtoList);
    }

    @Override
    public ResponseEntity selectInstitutionCourseById(Integer institutionCourseId) {
        InstitutionCourse institutionCourse = institutionDao.selectInstitutionCourseById(institutionCourseId);
        if (institutionCourse == null) {
            return HttpUtil.resourceNotFound();
        }

        InstitutionCourseDto courseDto = InstitutionConverter.toCourseDto(institutionCourse);
        return HttpUtil.successWithData(courseDto);
    }

    @Override
    public ResponseEntity selectInstitutionActivityOverviewByPage(Integer institutionId, PagingParam pagingParam) {
        List<InstitutionActivity> activityList = institutionDao.selectInstitutionActivityByPage(institutionId,
                pagingParam.getOffset(), pagingParam.getSize());

        List<InstitutionActivityOverviewDto> overviewDtoList = activityList.stream()
                .map(InstitutionConverter::toActivityOverviewDto).collect(Collectors.toList());
        return HttpUtil.successWithData(overviewDtoList);
    }

    @Override
    public ResponseEntity selectInstitutionActivityById(Integer institutionActivityId) {
        InstitutionActivity institutionActivity = institutionDao.selectInstitutionActivityById(institutionActivityId);
        if (institutionActivity == null) {
            return HttpUtil.resourceNotFound();
        }

        InstitutionActivityDto dto = InstitutionConverter.toActivityDto(institutionActivity);
        return HttpUtil.successWithData(dto);
    }
}
