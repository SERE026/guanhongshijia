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

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.AddressMember;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.AddressMemberService;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
/*
 * 会员中心的收货地址修改
 * @lxf
 */
@Component("adressModify")
public class AdressModify extends AbstractMemberWidget{
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
		if(pamtr.get("adresModifyid")!=null){
			String adresModifyid=(String) pamtr.get("adresModifyid");
			AddressMember addressMember =(AddressMember) addressMemberService.getObjById(adresModifyid);
			this.putData("modifyInfo",addressMember);
			String tels= addressMember.getReceiveTel();
			String tel[]=new String[3];
			tel[0]=tels.substring(0, tels.indexOf("-"));
			tel[1]=tels.substring( tels.indexOf("-")+1, tels.lastIndexOf("-"));
			tel[2]=tels.substring( tels.lastIndexOf("-")+1);
			this.putData("receiveTel1", tel[0]);
			this.putData("receiveTel2", tel[1]);
			this.putData("receiveTel3", tel[2]);
		}
		if(pamtr.get("modifyAdId")!=null){
			String modifyAdId=(String) pamtr.get("modifyAdId");
			AddressMember addressMember =(AddressMember) addressMemberService.getObjById(modifyAdId);

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
				if(defaultList.size()>0){
					AddressMember addressMember01 = (AddressMember) defaultList.get(0);
					addressMember01.setIsdefault(0);
					addressMemberService.updateObj(addressMember01);
				}
			}
			AreaInfo province=(AreaInfo)areaService.getObjById(provinceid);
			AreaInfo city=(AreaInfo)areaService.getObjById(cityid);
			AreaInfo county=(AreaInfo)areaService.getObjById(countyid);
			
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
			addressMemberService.updateObj(addressMember);
			this.putData("modifyInfo",addressMember);
			try {
				this.HttpResponse.sendRedirect(this.HttpRequest.getContextPath()+"/"+"huiyuan_adress.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}