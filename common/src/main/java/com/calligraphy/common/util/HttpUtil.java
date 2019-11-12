package com.calligraphy.common.util;

import com.calligraphy.common.netbean.ResponseMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

public class HttpUtil {
    public static <T> ResponseEntity<ResponseMsg<T>> successWithData(T data) {
        return ResponseEntity.ok(new ResponseMsg<>(data));
    }

    public static ResponseEntity<ResponseMsg> successWithNoData() {
        return ResponseEntity.ok(new ResponseMsg(1, "成功"));
    }

    public static ResponseEntity<ResponseMsg> successWithHint(String hint) {
        return ResponseEntity.ok(new ResponseMsg(1, hint));
    }

    public static ResponseEntity serviceError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseMsg<>(-101, e.getMessage()));
    }

    public static ResponseEntity authorizationError() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ResponseMsg(-102, "用户身份错误"));
    }

    public static ResponseEntity parameterError(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest()
                .body(new ResponseMsg<>(-103, e.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }

    public static ResponseEntity parameterError(String selfDefinedMsg) {
        return ResponseEntity.badRequest()
                .body(new ResponseMsg<>(-103, selfDefinedMsg));
    }

    public static ResponseEntity resourceNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseMsg<>(-104, "找不到该资源"));
    }

    public static ResponseEntity deleteFailure() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseMsg<>(-105, "存在使用数据，不能删除"));

    }

    public static ResponseEntity databaseError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseMsg(-106, "数据库异常"));
    }

    public static CorsFilter configAllowAllCORS() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin(CorsConfiguration.ALL);
        config.setAllowCredentials(true);
        config.addAllowedMethod(CorsConfiguration.ALL);
        config.addAllowedHeader(CorsConfiguration.ALL);
        //config.addExposedHeader("*");

        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(configSource);
    }
}
