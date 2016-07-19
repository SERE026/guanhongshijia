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

package cn.com.dyninfo.o2o.old.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 * 游戏参数表
 * @author 王敏
 *
 */
@Entity
@Table(name="T_GAME_PARAM")
public class GameParam {

	@Id
	@AccessType(value = "property")
	@Column(name="GAME_PARAM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int game_param_id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GAME_ID")
	private Game game;
	
	@AccessType(value = "property")
	@Column(name="OBJECT")
	private String obj;
	
	@AccessType(value = "property")
	@Column(name="OBJECT_ID")
	private int objId;
	
	@AccessType(value = "property")
	@Column(name="PARAM_1")
	private String param1;
	
	@AccessType(value = "property")
	@Column(name="PARAM_2")
	private String param2;
	@AccessType(value = "property")
	@Column(name="PARAM_3")
	private String param3;
	
	@AccessType(value = "property")
	@Column(name="PARAM_4")
	private String param4;
	@AccessType(value = "property")
	@Column(name="PARAM_5")
	private String param5;
	@AccessType(value = "property")
	@Column(name="PARAM_6")
	private String param6;
	@AccessType(value = "property")
	@Column(name="PARAM_7")
	private String param7;
	@AccessType(value = "property")
	@Column(name="PARAM_8")
	private String param8;
	@AccessType(value = "property")
	@Column(name="PARAM_9")
	private String param9;
	@AccessType(value = "property")
	@Column(name="PARAM_10")
	private String param10;
	
	
	@AccessType(value = "property")
	@Column(name="PARAM_11")
	private String param11;
	
	@AccessType(value = "property")
	@Column(name="PARAM_12")
	private String param12;
	@AccessType(value = "property")
	@Column(name="PARAM_13")
	private String param13;
	
	@AccessType(value = "property")
	@Column(name="PARAM_14")
	private String param14;
	@AccessType(value = "property")
	@Column(name="PARAM_15")
	private String param15;
	@AccessType(value = "property")
	@Column(name="PARAM_16")
	private String param16;
	@AccessType(value = "property")
	@Column(name="PARAM_17")
	private String param17;
	@AccessType(value = "property")
	@Column(name="PARAM_18")
	private String param18;
	@AccessType(value = "property")
	@Column(name="PARAM_19")
	private String param19;
	@AccessType(value = "property")
	@Column(name="PARAM_20")
	private String param20;
	
	@AccessType(value = "property")
	@Column(name="PARAM_21")
	private String param21;
	
	@AccessType(value = "property")
	@Column(name="PARAM_22")
	private String param22;
	@AccessType(value = "property")
	@Column(name="PARAM_23")
	private String param23;
	
	@AccessType(value = "property")
	@Column(name="PARAM_24")
	private String param24;
	@AccessType(value = "property")
	@Column(name="PARAM_25")
	private String param25;
	@AccessType(value = "property")
	@Column(name="PARAM_26")
	private String param26;
	@AccessType(value = "property")
	@Column(name="PARAM_27")
	private String param27;
	@AccessType(value = "property")
	@Column(name="PARAM_28")
	private String param28;
	@AccessType(value = "property")
	@Column(name="PARAM_29")
	private String param29;
	@AccessType(value = "property")
	@Column(name="PARAM_30")
	private String param30;
	
	@AccessType(value = "property")
	@Column(name="PARAM_31")
	private String param31;
	
	@AccessType(value = "property")
	@Column(name="PARAM_32")
	private String param32;
	@AccessType(value = "property")
	@Column(name="PARAM_33")
	private String param33;
	
	@AccessType(value = "property")
	@Column(name="PARAM_34")
	private String param34;
	@AccessType(value = "property")
	@Column(name="PARAM_35")
	private String param35;
	@AccessType(value = "property")
	@Column(name="PARAM_36")
	private String param36;
	@AccessType(value = "property")
	@Column(name="PARAM_37")
	private String param37;
	@AccessType(value = "property")
	@Column(name="PARAM_38")
	private String param38;
	@AccessType(value = "property")
	@Column(name="PARAM_39")
	private String param39;
	@AccessType(value = "property")
	@Column(name="PARAM_40")
	private String param40;
	
	@AccessType(value = "property")
	@Column(name="PARAM_41")
	private String param41;
	
	@AccessType(value = "property")
	@Column(name="PARAM_42")
	private String param42;
	@AccessType(value = "property")
	@Column(name="PARAM_43")
	private String param43;
	
	@AccessType(value = "property")
	@Column(name="PARAM_44")
	private String param44;
	@AccessType(value = "property")
	@Column(name="PARAM_45")
	private String param45;
	@AccessType(value = "property")
	@Column(name="PARAM_46")
	private String param46;
	@AccessType(value = "property")
	@Column(name="PARAM_47")
	private String param47;
	@AccessType(value = "property")
	@Column(name="PARAM_48")
	private String param48;
	@AccessType(value = "property")
	@Column(name="PARAM_49")
	private String param49;
	@AccessType(value = "property")
	@Column(name="PARAM_50")
	private String param50;
	/**
	 * @return the game_param_id
	 */
	public int getGame_param_id() {
		return game_param_id;
	}
	/**
	 * @param game_param_id the game_param_id to set
	 */
	public void setGame_param_id(int game_param_id) {
		this.game_param_id = game_param_id;
	}
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	/**
	 * @return the object
	 */
	public String getObj() {
		return obj;
	}
	/**
	 * @param object the object to set
	 */
	public void setObj(String obj) {
		this.obj = obj;
	}
	/**
	 * @return the objId
	 */
	public int getObjId() {
		return objId;
	}
	/**
	 * @param objId the objId to set
	 */
	public void setObjId(int objId) {
		this.objId = objId;
	}
	/**
	 * @return the param1
	 */
	public String getParam1() {
		return param1;
	}
	/**
	 * @param param1 the param1 to set
	 */
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	/**
	 * @return the param2
	 */
	public String getParam2() {
		return param2;
	}
	/**
	 * @param param2 the param2 to set
	 */
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	/**
	 * @return the param3
	 */
	public String getParam3() {
		return param3;
	}
	/**
	 * @param param3 the param3 to set
	 */
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	/**
	 * @return the param4
	 */
	public String getParam4() {
		return param4;
	}
	/**
	 * @param param4 the param4 to set
	 */
	public void setParam4(String param4) {
		this.param4 = param4;
	}
	/**
	 * @return the param5
	 */
	public String getParam5() {
		return param5;
	}
	/**
	 * @param param5 the param5 to set
	 */
	public void setParam5(String param5) {
		this.param5 = param5;
	}
	/**
	 * @return the param6
	 */
	public String getParam6() {
		return param6;
	}
	/**
	 * @param param6 the param6 to set
	 */
	public void setParam6(String param6) {
		this.param6 = param6;
	}
	/**
	 * @return the param7
	 */
	public String getParam7() {
		return param7;
	}
	/**
	 * @param param7 the param7 to set
	 */
	public void setParam7(String param7) {
		this.param7 = param7;
	}
	/**
	 * @return the param8
	 */
	public String getParam8() {
		return param8;
	}
	/**
	 * @param param8 the param8 to set
	 */
	public void setParam8(String param8) {
		this.param8 = param8;
	}
	/**
	 * @return the param9
	 */
	public String getParam9() {
		return param9;
	}
	/**
	 * @param param9 the param9 to set
	 */
	public void setParam9(String param9) {
		this.param9 = param9;
	}
	/**
	 * @return the param10
	 */
	public String getParam10() {
		return param10;
	}
	/**
	 * @param param10 the param10 to set
	 */
	public void setParam10(String param10) {
		this.param10 = param10;
	}
	/**
	 * @return the param11
	 */
	public String getParam11() {
		return param11;
	}
	/**
	 * @param param11 the param11 to set
	 */
	public void setParam11(String param11) {
		this.param11 = param11;
	}
	/**
	 * @return the param12
	 */
	public String getParam12() {
		return param12;
	}
	/**
	 * @param param12 the param12 to set
	 */
	public void setParam12(String param12) {
		this.param12 = param12;
	}
	/**
	 * @return the param13
	 */
	public String getParam13() {
		return param13;
	}
	/**
	 * @param param13 the param13 to set
	 */
	public void setParam13(String param13) {
		this.param13 = param13;
	}
	/**
	 * @return the param14
	 */
	public String getParam14() {
		return param14;
	}
	/**
	 * @param param14 the param14 to set
	 */
	public void setParam14(String param14) {
		this.param14 = param14;
	}
	/**
	 * @return the param15
	 */
	public String getParam15() {
		return param15;
	}
	/**
	 * @param param15 the param15 to set
	 */
	public void setParam15(String param15) {
		this.param15 = param15;
	}
	/**
	 * @return the param16
	 */
	public String getParam16() {
		return param16;
	}
	/**
	 * @param param16 the param16 to set
	 */
	public void setParam16(String param16) {
		this.param16 = param16;
	}
	/**
	 * @return the param17
	 */
	public String getParam17() {
		return param17;
	}
	/**
	 * @param param17 the param17 to set
	 */
	public void setParam17(String param17) {
		this.param17 = param17;
	}
	/**
	 * @return the param18
	 */
	public String getParam18() {
		return param18;
	}
	/**
	 * @param param18 the param18 to set
	 */
	public void setParam18(String param18) {
		this.param18 = param18;
	}
	/**
	 * @return the param19
	 */
	public String getParam19() {
		return param19;
	}
	/**
	 * @param param19 the param19 to set
	 */
	public void setParam19(String param19) {
		this.param19 = param19;
	}
	/**
	 * @return the param20
	 */
	public String getParam20() {
		return param20;
	}
	/**
	 * @param param20 the param20 to set
	 */
	public void setParam20(String param20) {
		this.param20 = param20;
	}
	/**
	 * @return the param21
	 */
	public String getParam21() {
		return param21;
	}
	/**
	 * @param param21 the param21 to set
	 */
	public void setParam21(String param21) {
		this.param21 = param21;
	}
	/**
	 * @return the param22
	 */
	public String getParam22() {
		return param22;
	}
	/**
	 * @param param22 the param22 to set
	 */
	public void setParam22(String param22) {
		this.param22 = param22;
	}
	/**
	 * @return the param23
	 */
	public String getParam23() {
		return param23;
	}
	/**
	 * @param param23 the param23 to set
	 */
	public void setParam23(String param23) {
		this.param23 = param23;
	}
	/**
	 * @return the param24
	 */
	public String getParam24() {
		return param24;
	}
	/**
	 * @param param24 the param24 to set
	 */
	public void setParam24(String param24) {
		this.param24 = param24;
	}
	/**
	 * @return the param25
	 */
	public String getParam25() {
		return param25;
	}
	/**
	 * @param param25 the param25 to set
	 */
	public void setParam25(String param25) {
		this.param25 = param25;
	}
	/**
	 * @return the param26
	 */
	public String getParam26() {
		return param26;
	}
	/**
	 * @param param26 the param26 to set
	 */
	public void setParam26(String param26) {
		this.param26 = param26;
	}
	/**
	 * @return the param27
	 */
	public String getParam27() {
		return param27;
	}
	/**
	 * @param param27 the param27 to set
	 */
	public void setParam27(String param27) {
		this.param27 = param27;
	}
	/**
	 * @return the param28
	 */
	public String getParam28() {
		return param28;
	}
	/**
	 * @param param28 the param28 to set
	 */
	public void setParam28(String param28) {
		this.param28 = param28;
	}
	/**
	 * @return the param29
	 */
	public String getParam29() {
		return param29;
	}
	/**
	 * @param param29 the param29 to set
	 */
	public void setParam29(String param29) {
		this.param29 = param29;
	}
	/**
	 * @return the param30
	 */
	public String getParam30() {
		return param30;
	}
	/**
	 * @param param30 the param30 to set
	 */
	public void setParam30(String param30) {
		this.param30 = param30;
	}
	/**
	 * @return the param31
	 */
	public String getParam31() {
		return param31;
	}
	/**
	 * @param param31 the param31 to set
	 */
	public void setParam31(String param31) {
		this.param31 = param31;
	}
	/**
	 * @return the param32
	 */
	public String getParam32() {
		return param32;
	}
	/**
	 * @param param32 the param32 to set
	 */
	public void setParam32(String param32) {
		this.param32 = param32;
	}
	/**
	 * @return the param33
	 */
	public String getParam33() {
		return param33;
	}
	/**
	 * @param param33 the param33 to set
	 */
	public void setParam33(String param33) {
		this.param33 = param33;
	}
	/**
	 * @return the param34
	 */
	public String getParam34() {
		return param34;
	}
	/**
	 * @param param34 the param34 to set
	 */
	public void setParam34(String param34) {
		this.param34 = param34;
	}
	/**
	 * @return the param35
	 */
	public String getParam35() {
		return param35;
	}
	/**
	 * @param param35 the param35 to set
	 */
	public void setParam35(String param35) {
		this.param35 = param35;
	}
	/**
	 * @return the param36
	 */
	public String getParam36() {
		return param36;
	}
	/**
	 * @param param36 the param36 to set
	 */
	public void setParam36(String param36) {
		this.param36 = param36;
	}
	/**
	 * @return the param37
	 */
	public String getParam37() {
		return param37;
	}
	/**
	 * @param param37 the param37 to set
	 */
	public void setParam37(String param37) {
		this.param37 = param37;
	}
	/**
	 * @return the param38
	 */
	public String getParam38() {
		return param38;
	}
	/**
	 * @param param38 the param38 to set
	 */
	public void setParam38(String param38) {
		this.param38 = param38;
	}
	/**
	 * @return the param39
	 */
	public String getParam39() {
		return param39;
	}
	/**
	 * @param param39 the param39 to set
	 */
	public void setParam39(String param39) {
		this.param39 = param39;
	}
	/**
	 * @return the param40
	 */
	public String getParam40() {
		return param40;
	}
	/**
	 * @param param40 the param40 to set
	 */
	public void setParam40(String param40) {
		this.param40 = param40;
	}
	/**
	 * @return the param41
	 */
	public String getParam41() {
		return param41;
	}
	/**
	 * @param param41 the param41 to set
	 */
	public void setParam41(String param41) {
		this.param41 = param41;
	}
	/**
	 * @return the param42
	 */
	public String getParam42() {
		return param42;
	}
	/**
	 * @param param42 the param42 to set
	 */
	public void setParam42(String param42) {
		this.param42 = param42;
	}
	/**
	 * @return the param43
	 */
	public String getParam43() {
		return param43;
	}
	/**
	 * @param param43 the param43 to set
	 */
	public void setParam43(String param43) {
		this.param43 = param43;
	}
	/**
	 * @return the param44
	 */
	public String getParam44() {
		return param44;
	}
	/**
	 * @param param44 the param44 to set
	 */
	public void setParam44(String param44) {
		this.param44 = param44;
	}
	/**
	 * @return the param45
	 */
	public String getParam45() {
		return param45;
	}
	/**
	 * @param param45 the param45 to set
	 */
	public void setParam45(String param45) {
		this.param45 = param45;
	}
	/**
	 * @return the param46
	 */
	public String getParam46() {
		return param46;
	}
	/**
	 * @param param46 the param46 to set
	 */
	public void setParam46(String param46) {
		this.param46 = param46;
	}
	/**
	 * @return the param47
	 */
	public String getParam47() {
		return param47;
	}
	/**
	 * @param param47 the param47 to set
	 */
	public void setParam47(String param47) {
		this.param47 = param47;
	}
	/**
	 * @return the param48
	 */
	public String getParam48() {
		return param48;
	}
	/**
	 * @param param48 the param48 to set
	 */
	public void setParam48(String param48) {
		this.param48 = param48;
	}
	/**
	 * @return the param49
	 */
	public String getParam49() {
		return param49;
	}
	/**
	 * @param param49 the param49 to set
	 */
	public void setParam49(String param49) {
		this.param49 = param49;
	}
	/**
	 * @return the param50
	 */
	public String getParam50() {
		return param50;
	}
	/**
	 * @param param50 the param50 to set
	 */
	public void setParam50(String param50) {
		this.param50 = param50;
	}
	
	
	
}
