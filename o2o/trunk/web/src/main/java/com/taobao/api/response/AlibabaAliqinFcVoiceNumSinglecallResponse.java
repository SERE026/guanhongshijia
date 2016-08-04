package com.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.BizResult;
import com.taobao.api.internal.mapping.ApiField;

/**
 * TOP API: alibaba.aliqin.fc.voice.num.singlecall response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AlibabaAliqinFcVoiceNumSinglecallResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3753118554994457489L;

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
