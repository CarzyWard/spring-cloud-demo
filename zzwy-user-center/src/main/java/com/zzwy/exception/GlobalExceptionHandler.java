package com.zzwy.exception;

import com.zzwy.common.CodeMsg;
import com.zzwy.common.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 全局异常捕获
 *
 * @author zhongsy
 * @date 2018/11/12
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception ex) {

        ex.printStackTrace();

        if (ex instanceof BindException) {
            BindException exception = (BindException) ex;
            List<ObjectError> errors = exception.getAllErrors();

            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();

            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }

        if (ex instanceof GlobalException) {
            GlobalException exception = (GlobalException) ex;

            return Result.error(exception.getCodeMsg());
        }

        return Result.error(CodeMsg.SERVER_ERROR);
    }
}
