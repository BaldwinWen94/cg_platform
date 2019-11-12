package com.calligraphy.cg_user.controller;


import com.calligraphy.service.LetterService;
import com.calligraphy.service.netbean.letter.LetterQueryDto;
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
@RequestMapping("/letter")
@Transactional
@Api(value = "模块：书法字典")
public class LetterController {

    private final LetterService letterService;

    @Autowired
    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    @ApiOperation(value = "根据字体查询书法字典")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = LetterQueryDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity selectLetterSampleByFontType(@RequestParam String letter,
                                                       @RequestParam Integer fontType) {
        return letterService.selectLetterSampleByFontType(letter, fontType);
    }
}
