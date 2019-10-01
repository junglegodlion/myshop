package com.jungle.handle;

import com.jungle.domain.Result;
import com.jungle.exception.BoyException;
import com.jungle.utils.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Created by jungle on 2019/2/23.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BoyException) {
            BoyException boyException = (BoyException) e;
            return ResultUtil.error(boyException.getCode(), boyException.getMessage());
        } else {
            logger.error("【异常错误】{}",e);
            return ResultUtil.error(-1, "未知错误");
        }

    }
}