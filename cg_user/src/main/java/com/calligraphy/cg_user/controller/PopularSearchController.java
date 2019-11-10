package com.calligraphy.cg_user.controller;


import com.calligraphy.common.netbean.PagingParam;
import com.calligraphy.service.PopularSearchService;
import com.calligraphy.service.netbean.popular_search.PopularSearchDto;
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
@RequestMapping("/popular_search")
@Transactional
@Api(value = "Module_PopularSearch", description = "模块：热门搜索")
public class PopularSearchController {

    private final PopularSearchService popularSearchService;

    @Autowired
    public PopularSearchController(PopularSearchService popularSearchService) {
        this.popularSearchService = popularSearchService;
    }

    @ApiOperation(value = "查询热门搜索列表")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "查询成功", response = PopularSearchDto.class, responseContainer = "list"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 403, message = "身份错误")
    })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity selectPopularSearchByPage(@RequestParam(required = false) Integer pageStart,
                                                    @RequestParam(required = false) Integer pageSize) {
        return popularSearchService.selectPopularSearch(new PagingParam(pageStart, pageSize));
    }
}
