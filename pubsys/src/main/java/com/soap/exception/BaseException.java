package com.soap.exception;

/**
 * BaseException.java <br/>
 * <b>功能描述：<b><br/>
 *
 * TODO(这里描述类功能 –必选 ).<br/>
 *
 * @author qiangl@shanghe-china.com
 * @since 1.0 2018-2-13
 * @lastmodified 2018-2-13
 */
public class BaseException extends Exception
{



    private static final long serialVersionUID = 7176159905851492439L;

    /**
     * errCode:错误码
     */
    private String errCode;

    /**
     * errMsg:错误信息
     */
    private String errMsg;

    /**
     * cause:真正错误信息
     */
    private Throwable cause;

    @Override
    public String toString()
    {
        return "BaseException [errCode=" + errCode + ", errMsg=" + errMsg + ", cause=" + cause
                + "]";
    }

    /**
     * 得到异常对象的异常信息。
     * @return String 异常信息
     */
    public String getMessage()
    {
        String msg = super.getMessage();
        if (this.errCode != null)
        {
            if (msg != null)
                msg = "[error_code:" + this.errCode + "] " + msg;
            else
                msg = "[error_code:" + this.errCode + "]";
        }

        String causeMsg = null;
        if (cause != null) causeMsg = cause.getMessage();

        if (msg != null)
        {
            if (causeMsg != null)
                return msg + " caused by: " + causeMsg;
            else
                return msg;
        }
        else
        {
            return causeMsg;
        }
    }

    public BaseException()
    {

    }
    public BaseException(String errCode, String errMsg, Throwable cause)
    {
        super(errMsg,cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.cause = cause;
    }

    public BaseException(String errCode, String errMsg)
    {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BaseException(String errMsg, Throwable cause)
    {
        super(errMsg,cause);
        this.errMsg = errMsg;
        this.cause = cause;
    }

    public BaseException(Throwable cause)
    {
        super(cause);
        this.cause = cause;
    }

    public String getErrCode()
    {
        return errCode;
    }

    public void setErrCode(String errCode)
    {
        this.errCode = errCode;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }

    public Throwable getCause()
    {
        return cause;
    }

    public void setCause(Throwable cause)
    {
        this.cause = cause;
    }

}
