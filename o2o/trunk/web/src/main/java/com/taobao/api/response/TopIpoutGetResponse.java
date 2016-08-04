package com.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * TOP API: taobao.top.ipout.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TopIpoutGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3167187369519322872L;

	/** 
	 * 出口IP段列表
	 */
	@ApiListField("ip_sections")
	@ApiField("string")
	private List<String> ipSections;


	public void setIpSections(List<String> ipSections) {
		this.ipSections = ipSections;
	}
	public List<String> getIpSections( ) {
		return this.ipSections;
	}
	


}
