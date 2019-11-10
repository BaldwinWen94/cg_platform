package com.calligraphy.service.converter;

import com.calligraphy.domain.entity.*;
import com.calligraphy.service.netbean.institution.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class InstitutionConverter {
    public static InstitutionDto toDto(Institution institution,
                                       List<InstitutionAchievement> achievementList,
                                       List<InstitutionEnvironment> environmentList,
                                       List<InstitutionTeacher> teacherList,
                                       InstitutionPrincipalQuote principalQuote,
                                       List<InstitutionCourse> courseList,
                                       List<InstitutionActivity> activityList) {
        InstitutionDto dto = new InstitutionDto();
        dto.setInstitutionId(institution.getId());
        dto.setInstitutionName(institution.getInstitutionName());
        dto.setInstitutionLocation(institution.getInstitutionLocation());
        dto.setInstitutionIcon(institution.getInstitutionIcon());
        dto.setInstitutionDescription(institution.getInstitutionDescription());
        dto.setInstitutionImage(institution.getInstitutionImage());
        dto.setFollowCount(institution.getFollowCount());

        dto.setAchievementDtoList(achievementList.stream().map(InstitutionConverter::toAchievementDto)
                .collect(Collectors.toList()));

        dto.setEnvironmentDtoList(environmentList.stream().map(InstitutionConverter::toEnvironmentDto)
                .collect(Collectors.toList()));

        dto.setTeacherDtoList(teacherList.stream().map(InstitutionConverter::toTeacherDto)
                .collect(Collectors.toList()));

        dto.setPrincipalQuoteDto(InstitutionConverter.toPrincipalQuoteDto(principalQuote));

        dto.setCourseDtoList(courseList.stream().map(InstitutionConverter::toCourseDto)
                .collect(Collectors.toList()));

        dto.setActivityDtoList(activityList.stream().map(InstitutionConverter::toActivityDto)
                .collect(Collectors.toList()));
        return dto;
    }

    public static InstitutionOverviewDto toOverviewDto(Institution institution, List<String> environmentList) {
        InstitutionOverviewDto overviewDto = new InstitutionOverviewDto();
        overviewDto.setInstitutionId(institution.getId());
        overviewDto.setInstitutionName(institution.getInstitutionName());
        overviewDto.setInstitutionLocation(institution.getInstitutionLocation());
        overviewDto.setInstitutionIcon(institution.getInstitutionIcon());
        overviewDto.setInstitutionDescription(institution.getInstitutionDescription());
        overviewDto.setInstitutionEnvironmentBriefList(environmentList);
        return overviewDto;
    }

    public static InstitutionAchievementDto toAchievementDto(InstitutionAchievement achievement) {
        InstitutionAchievementDto achievementDto = new InstitutionAchievementDto();
        achievementDto.setInstitutionAchievementId(achievement.getId());
        achievementDto.setAchievementYear(achievement.getAchievementYear());
        achievementDto.setAchievementImage(achievement.getAchievementImage());
        achievementDto.setAchievementContent(achievement.getAchievementContent());
        return achievementDto;
    }

    public static InstitutionEnvironmentDto toEnvironmentDto(InstitutionEnvironment environment) {
        InstitutionEnvironmentDto environmentDto = new InstitutionEnvironmentDto();
        environmentDto.setInstitutionEnvironmentId(environment.getId());
        environmentDto.setEnvironmentImage(environment.getEnvironmentImage());
        return environmentDto;
    }

    public static InstitutionTeacherDto toTeacherDto(InstitutionTeacher institutionTeacher) {
        InstitutionTeacherDto teacherDto = new InstitutionTeacherDto();
        teacherDto.setInstitutionTeacherId(institutionTeacher.getId());
        teacherDto.setTeacherName(institutionTeacher.getTeacherName());
        teacherDto.setTeacherImage(institutionTeacher.getTeacherImage());
        teacherDto.setTeacherDescription(institutionTeacher.getTeacherDescription());
        return teacherDto;
    }

    public static InstitutionPrincipalQuoteDto toPrincipalQuoteDto(InstitutionPrincipalQuote principalQuote) {
        InstitutionPrincipalQuoteDto principalQuoteDto = new InstitutionPrincipalQuoteDto();
        principalQuoteDto.setInstitutionPrincipalQuoteId(principalQuote.getId());
        principalQuoteDto.setPrincipalName(principalQuote.getPrincipalName());
        principalQuoteDto.setPrincipalQuote(principalQuote.getPrincipalQuote());
        principalQuoteDto.setQuoteImage(principalQuote.getQuoteImage());
        principalQuoteDto.setQuoteDescription(principalQuote.getQuoteDescription());
        return principalQuoteDto;
    }

    public static InstitutionCourseDto toCourseDto(InstitutionCourse institutionCourse) {
        InstitutionCourseDto courseDto = new InstitutionCourseDto();
        courseDto.setInstitutionCourseId(institutionCourse.getId());
        courseDto.setCourseName(institutionCourse.getCourseName());
        courseDto.setCourseType(institutionCourse.getCourseType());
        courseDto.setCoursePurpose(institutionCourse.getCoursePurpose());
        courseDto.setCourseContent(institutionCourse.getCourseContent());
        courseDto.setCourseDescription(institutionCourse.getCourseDescription());
        courseDto.setCourseFee(institutionCourse.getCourseFee());
        return courseDto;
    }

    public static InstitutionCourseOverviewDto toCourseOverviewDto(InstitutionCourse institutionCourse) {
        InstitutionCourseOverviewDto courseOverviewDto = new InstitutionCourseOverviewDto();
        courseOverviewDto.setInstitutionCourseId(institutionCourse.getId());
        courseOverviewDto.setCourseName(institutionCourse.getCourseName());
        courseOverviewDto.setCoursePurpose(institutionCourse.getCoursePurpose());
        courseOverviewDto.setCourseFee(institutionCourse.getCourseFee());
        return courseOverviewDto;
    }

    public static InstitutionActivityDto toActivityDto(InstitutionActivity institutionActivity) {
        InstitutionActivityDto activityDto = new InstitutionActivityDto();
        activityDto.setInstitutionActivityId(institutionActivity.getId());
        activityDto.setActivityName(institutionActivity.getActivityName());
        activityDto.setActivityAddress(institutionActivity.getActivityAddress());
        activityDto.setActivityImage(institutionActivity.getActivityImage());
        activityDto.setActivityDescription(institutionActivity.getActivityDescription());
        activityDto.setActivityStartTime(institutionActivity.getActivityStartTime());
        activityDto.setActivityEndTime(institutionActivity.getActivityEndTime());
        return activityDto;
    }


    public static InstitutionActivityOverviewDto toActivityOverviewDto(InstitutionActivity institutionActivity) {
        InstitutionActivityOverviewDto activityOverviewDto = new InstitutionActivityOverviewDto();
        activityOverviewDto.setInstitutionActivityId(institutionActivity.getId());
        activityOverviewDto.setActivityImage(institutionActivity.getActivityImage());
        Date now = new Date();
        if (now.before(institutionActivity.getActivityStartTime())) {
            activityOverviewDto.setActivityStatus(InstitutionActivityOverviewDto.ActivityStatus.NOT_STARTED);
        } else if (now.after(institutionActivity.getActivityEndTime())) {
            activityOverviewDto.setActivityStatus(InstitutionActivityOverviewDto.ActivityStatus.ENDED);
        } else {
            activityOverviewDto.setActivityStatus(InstitutionActivityOverviewDto.ActivityStatus.ONGOING);
        }
        return activityOverviewDto;
    }
}
