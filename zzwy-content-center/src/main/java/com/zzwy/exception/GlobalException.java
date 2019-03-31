package com.zzwy.exception;


import com.zzwy.common.CodeMsg;

/**
 * 全局异常类
 *
 * @author zhongsy
 * @date 2018/11/12
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
