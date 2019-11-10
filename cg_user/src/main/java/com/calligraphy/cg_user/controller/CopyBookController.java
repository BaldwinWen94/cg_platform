package com.calligraphy.cg_user.controller;


import com.calligraphy.common.netbean.PagingParam;
import com.calligraphy.service.CopyBookService;
import com.calligraphy.service.netbean.CopyBookDetailDto;
import com.calligraphy.service.netbean.CopyBookDto;
import com.calligraphy.service.netbean.CopyBookOverviewDto;
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
@RequestMapping("")
@Transactional
@Api(value = "模块：字帖")
public class CopyBookController {

    private final CopyBookService copyBookService;

    @Autowired
    public CopyBookController(CopyBookService copyBookService) {
        this.copyBookService = copyBookService;
    }

    @ApiOperation(value = "模糊查询字帖列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = CopyBookOverviewDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/copybook/fuzzy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity selectCopyBookFuzzy(@RequestParam String condition,
                                              @RequestParam(required = false) Integer pageStart,
                                              @RequestParam(required = false) Integer pageSize) {
        return copyBookService.selectCopyBookFuzzy(condition, new PagingParam(pageStart, pageSize));
    }

    @ApiOperation(value = "查询字帖详情")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = CopyBookDto.class),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/copybook/{copyBookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity selectCopyBookByIdForUser(@PathVariable Integer copyBookId) {
        return copyBookService.selectCopyBookByIdForUser(copyBookId);
    }

    @ApiOperation(value = "查询字帖图片明细")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = CopyBookDetailDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "/copybook/{copyBookId}/image/{sequenceNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity selectCopyBookById(@PathVariable Integer copyBookId, @PathVariable Integer sequenceNo) {
        return copyBookService.selectCopyBookDetail(copyBookId, sequenceNo);
    }


    @ApiOperation(value = "推荐字帖")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @PostMapping(value = "/copybook/{copyBookId}/commend", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity commendCopyBook(@PathVariable Integer copyBookId) {
        return copyBookService.incrementCountForCopyBookColumn(copyBookId, "commend_times");
    }

    @ApiOperation(value = "下载字帖低分辨率图片")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @PostMapping(value = "/copybook/{copyBookId}/download/low_resolution_image", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity downloadCopyBookLowResolutionImage(@PathVariable Integer copyBookId) {
        return copyBookService.incrementCountForCopyBookColumn(copyBookId, "low_resolution_download_times");
    }

    @ApiOperation(value = "下载字帖高分辨率图片")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @PostMapping(value = "/copybook/{copyBookId}/download/high_resolution_image", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity downloadCopyBookHighResolutionImage(@PathVariable Integer copyBookId) {
        return copyBookService.incrementCountForCopyBookColumn(copyBookId, "high_resolution_download_times");
    }
}
