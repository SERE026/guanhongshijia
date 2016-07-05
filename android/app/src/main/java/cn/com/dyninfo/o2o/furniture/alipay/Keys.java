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

package cn.com.dyninfo.o2o.furniture.alipay;

//
// 请参考 Android平台安全支付服务(msp)应用开发接口(4.2 RSA算法签名)部分，并使用压缩包中的openssl RSA密钥生成工具，生成一套RSA公私钥。
// 这里签名时，只需要使用生成的RSA私钥。
// Note: 为安全起见，使用RSA私钥进行签名的操作过程，应该尽量放到商家服务器端去进行。
public final class Keys {

	// 合作身份者id，以2088开头的16位纯数字
	public static final String DEFAULT_PARTNER = "2088311579535283";

	// 收款支付宝账号
	public static final String DEFAULT_SELLER = "xpzc2014@qq.com";

	// 商户私钥，自助生成
	public static final String PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKhr6ae+55BMU1dwIq0Eqh/UzWD5tiWOKt6WH6GizRpe/HnP9IMricV7HWgCL7MFHo6aUV2Qbf5s5VX3EMPmMLuEt0J7heGhZyiF8w6p5M9JulOSMN7QA1IMeVByxTCXt2xPcbILWUY56vPegFtCYE0KjOKY9sHAYa0K5z22FsHZAgMBAAECgYAVRqSau0QXd3zjw9etkbRIFyLmyETZU69YtRBD5AQS+8LbRIj39Q0PdHEPjY8nB1OH4ji7IB61EF6cUHy+spqfMS6cypA/scFw9Bx1GDxmf7JPWeucBjpGH+lmZ6+U+gaKlJXucp+BdNt0G53wf3KBQmYMABNfQm+8Bspi9mfmfQJBANjv36f9fE2DxKd8WF0Bv8A8/zcRtb/NoBTy5EjY+2yXrX2TPw9b/Gl3PGvlZnc75C9KsUZ65JyWU76MYz8R5bMCQQDGv6Ajbti6HGM7xb3K+E/hxtQl2FIZ8NpQWL3TOAm0bkxn6movea76ghih0jWntLrVKFRyAyqauBIB+cRkr8xDAkEAxQvdEzHkHmR508fWW2SjT3IYP2UOuVGE/oJBaQnuFg0PwOhmdwUOmJ19fGO6VsNH2Mz3iRVHYhQJrSLHYxpWkQJAZUe/nm7dSLIwq4QQPL+fTYnaEFMVO5zuU6V1To6u+2B91TKy2/Chh40GamhJ6WWDFB7SMauFaYTFwHX8a+beKwJAB1edNaIMptV1p/VX74n9seR6bkHAQGQMo/w3VRZmSpFDynLh1/Xe896RYEvQBExbY1/KrReRSCAcLkArsmaDcw==";

	public static final String PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoa+mnvueQTFNXcCKtBKof1M1g+bYljirelh+hos0aXvx5z/SDK4nFex1oAi+zBR6OmlFdkG3+bOVV9xDD5jC7hLdCe4XhoWcohfMOqeTPSbpTkjDe0ANSDHlQcsUwl7dsT3GyC1lGOerz3oBbQmBNCozimPbBwGGtCuc9thbB2QIDAQAB";

}
