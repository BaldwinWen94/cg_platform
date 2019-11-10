package com.calligraphy.cg_user.controller;

import com.calligraphy.service.InstitutionService;
import com.calligraphy.service.netbean.institution.*;
import com.calligraphy.common.netbean.PagingParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institution")
@Transactional
@Api(value = "Module_Institution", description = "模块：机构")
public class InstitutionController {

    private final InstitutionService institutionService;

    @Autowired
    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @ApiOperation(value = "查询机构列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionOverviewDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionByPage(@RequestParam(required = false) Integer pageStart,
                                                  @RequestParam(required = false) Integer pageSize) {
        return institutionService.selectInstitutionOverview(new PagingParam(pageStart, pageSize));
    }

    @ApiOperation(value = "查询机构详情")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionDto.class),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/{institutionId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionById(@PathVariable Integer institutionId) {
        return institutionService.selectInstitutionById(institutionId);
    }

    @ApiOperation(value = "查询机构历年成绩列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionAchievementDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/{institutionId}/achievement", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionAchievementByPage(@PathVariable Integer institutionId,
                                                             @RequestParam(required = false) Integer pageStart,
                                                             @RequestParam(required = false) Integer pageSize) {
        return institutionService.selectInstitutionAchievementByPage(institutionId,
                new PagingParam(pageStart, pageSize));
    }

    @ApiOperation(value = "查询机构环境列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionEnvironmentDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/{institutionId}/environment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionEnvironmentByPage(@PathVariable Integer institutionId,
                                                             @RequestParam(required = false) Integer pageStart,
                                                             @RequestParam(required = false) Integer pageSize) {
        return institutionService.selectInstitutionEnvironmentByPage(institutionId,
                new PagingParam(pageStart, pageSize));
    }

    @ApiOperation(value = "查询机构教师列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionTeacherDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/{institutionId}/teacher", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionTeacherByPage(@PathVariable Integer institutionId,
                                                         @RequestParam(required = false) Integer pageStart,
                                                         @RequestParam(required = false) Integer pageSize) {
        return institutionService.selectInstitutionTeacherByPage(institutionId,
                new PagingParam(pageStart, pageSize));
    }

    @ApiOperation(value = "查询机构校长寄语")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionPrincipalQuoteDto.class),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/{institutionId}/principal_quote", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionPrincipalQuote(@PathVariable Integer institutionId) {
        return institutionService.selectInstitutionPrincipalQuote(institutionId);
    }

    @ApiOperation(value = "查询机构课程列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionCourseOverviewDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/{institutionId}/course", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionCourseByPage(@PathVariable Integer institutionId,
                                                        @RequestParam(required = false) Integer pageStart,
                                                        @RequestParam(required = false) Integer pageSize) {
        return institutionService.selectInstitutionCourseOverviewByPage(institutionId,
                new PagingParam(pageStart, pageSize));
    }

    @ApiOperation(value = "查询机构课程详情")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionCourseDto.class),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/course/{courseId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionCourseById(@PathVariable Integer courseId) {
        return institutionService.selectInstitutionCourseById(courseId);
    }

    @ApiOperation(value = "查询机构活动列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionActivityOverviewDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/{institutionId}/activity", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionActivityByPage(@PathVariable Integer institutionId,
                                                          @RequestParam(required = false) Integer pageStart,
                                                          @RequestParam(required = false) Integer pageSize) {
        return institutionService.selectInstitutionActivityOverviewByPage(institutionId,
                new PagingParam(pageStart, pageSize));
    }

    @ApiOperation(value = "查询机构活动详情")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = InstitutionActivityDto.class),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/activity/{activityId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectInstitutionActivityById(@PathVariable Integer activityId) {
        return institutionService.selectInstitutionActivityById(activityId);
    }
}
