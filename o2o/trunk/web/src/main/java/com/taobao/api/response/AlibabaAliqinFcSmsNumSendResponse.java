package com.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.BizResult;
import com.taobao.api.internal.mapping.ApiField;

/**
 * TOP API: alibaba.aliqin.fc.sms.num.send response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AlibabaAliqinFcSmsNumSendResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3521399519463773494L;

	/** 
	 * 返回值
	 */
	@ApiField("result")
	private BizResult result;


	public void setResult(BizResult result) {
		this.result = result;
	}
	public BizResult getResult( ) {
		return this.result;
	}
	


}
