package com.soap.exception;
/**
 * BizFailException.java <br/>
 * <b>功能描述：<b><br/>
 * <p>
 * TODO(这里描述类功能 –必选 ).<br/>
 *
 * @author qiangl@shanghe-china.com
 * @lastmodified 2018-2-13
 * @since 1.0 2018-2-13
 */
public class BizFailException extends BaseException {

    private static final long serialVersionUID = -8414768033251477781L;

    public BizFailException() {

        super();
        // TODO Auto-generated constructor stub

    }

    public BizFailException(String errCode, String errMsg, Throwable cause) {

        super(errCode, errMsg, cause);
        // TODO Auto-generated constructor stub

    }

    public BizFailException(String errCode, String errMsg) {

        super(errCode, errMsg);
        // TODO Auto-generated constructor stub

    }

    public BizFailException(String errMsg, Throwable cause) {

        super(errMsg, cause);
        // TODO Auto-generated constructor stub

    }

    public BizFailException(Throwable cause) {

        super(cause);
        // TODO Auto-generated constructor stub

    }


}

