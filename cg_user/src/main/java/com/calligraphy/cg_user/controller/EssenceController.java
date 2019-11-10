package com.calligraphy.cg_user.controller;



import com.calligraphy.common.netbean.PagingParam;
import com.calligraphy.service.EssenceService;
import com.calligraphy.service.netbean.essence.EssenceDto;
import com.calligraphy.service.netbean.essence.EssenceTypeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/essence")
@Transactional
@Api(value = "Module_Essence", description = "模块：书家必携")
public class EssenceController {

    private EssenceService essenceService;

    @Autowired
    public EssenceController(EssenceService essenceService) {
        this.essenceService = essenceService;
    }

    @ApiOperation(value = "查询所有书家必携类型")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = EssenceTypeDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/type", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectAllEssenceType() {
        return essenceService.selectAllEssenceType();
    }

    @ApiOperation(value = "查询书家必携")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = EssenceDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/condition", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity selectEssenceByCondition(@RequestParam String essenceType1,
                                                   @RequestParam String essenceType2,
                                                   @RequestParam String wordCount,
                                                   @RequestParam(required = false) String dynasty,
                                                   @RequestParam(required = false) Integer pageStart,
                                                   @RequestParam(required = false) Integer pageSize) {
        return essenceService.selectEssenceByCondition(essenceType1, essenceType2, wordCount, dynasty,
                new PagingParam(pageStart, pageSize));
    }
}
