/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
 * confidential information, ideas and expressions.    No part of this
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

package cn.com.dyninfo.o2o.furniture.web.member.widget;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.AddressMember;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AddressMemberService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
/*
 * 会员中心的收货地址管理
 * @lxf
 */
@Component("adress")
public class Adress extends AbstractMemberWidget{
	 @Resource
	 private HuiyuanService huiyuanService;
	 @Resource
	 private AddressMemberService addressMemberService;
		@Resource
		private AreaService areaService;
		
	@Override
	public void execute(Map pamtr) {
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		this.putData("huiyuan",huiyuan);
		List addrList=addressMemberService.getListByWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()));
		this.putData("DATA",addrList);
		
		if(pamtr.get("receiveName")!=null){//新增
			String provinceid=(String) pamtr.get("province.id");
			String cityid=(String) pamtr.get("city.id");
			String countyid=(String) pamtr.get("county.id");
			String code=(String) pamtr.get("code");
			String address=(String) pamtr.get("address");
			String receiveName=(String) pamtr.get("receiveName");
			String receivePhone=(String) pamtr.get("receivePhone");
			String receiveTel1=(String) pamtr.get("receiveTel1");
			String receiveTel2=(String) pamtr.get("receiveTel2");
			String receiveTel3=(String) pamtr.get("receiveTel3");
			String isdefault=(String) pamtr.get("isdefault");
			if(isdefault==null||isdefault==""){
				isdefault="0";
			}else if(isdefault.equals("1")){//只能有一个默认
				List defaultList=addressMemberService.getListByWhere(new StringBuffer(" and n.isdefault=1"));
				for(int i=0;i<defaultList.size();i++){
					AddressMember addressMember01 = (AddressMember) defaultList.get(i);
					addressMember01.setIsdefault(0);
					addressMemberService.updateObj(addressMember01);
				
				}
			}
			AreaInfo province=(AreaInfo)areaService.getObjById(provinceid);
			AreaInfo city=(AreaInfo)areaService.getObjById(cityid);
			AreaInfo county=(AreaInfo)areaService.getObjById(countyid);
			
			AddressMember addressMember=new AddressMember();
			addressMember.setProvince(province);
			addressMember.setCity(city);
			addressMember.setCounty(county);
			addressMember.setCode(code);
			addressMember.setAddress(address);
			addressMember.setReceiveName(receiveName);
			addressMember.setReceivePhone(receivePhone);
			addressMember.setReceiveTel(receiveTel1+"-"+receiveTel2+"-"+receiveTel3);
			addressMember.setIsdefault(Integer.parseInt(isdefault));
			addressMember.setMember(huiyuan);
			addressMemberService.addObj(addressMember);
			try {
				this.HttpResponse.sendRedirect(this.HttpRequest.getContextPath()+"/huiyuan_adress.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pamtr.get("adressMemberid")!=null){//删除
			String id=(String) pamtr.get("adressMemberid");
			addressMemberService.delObjById(id);
		}
		
		if(pamtr.get("defaultId")!=null){//设置是否默认
			List defaultList=addressMemberService.getListByWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.isdefault=1"));
			if(defaultList.size()>0){
				for(int i=0;i<defaultList.size();i++){
					AddressMember addressMember01 = (AddressMember) defaultList.get(i);
					addressMember01.setIsdefault(0);
					addressMemberService.updateObj(addressMember01);

				}
			}else {
				String defaultId = (String) pamtr.get("defaultId");
				AddressMember adressinfo = (AddressMember) addressMemberService.getObjById(defaultId);
				adressinfo.setIsdefault(1);
				addressMemberService.updateObj(adressinfo);

			}

		}
			
	}	
}