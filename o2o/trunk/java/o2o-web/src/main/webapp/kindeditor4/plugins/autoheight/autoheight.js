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

KindEditor.plugin('autoheight', function(K) {
	var self = this;

	if (!self.autoHeightMode) {
		return;
	}

	var minHeight;

	function hideScroll() {
		var edit = self.edit;
		var body = edit.doc.body;
		edit.iframe[0].scroll = 'no';
		body.style.overflowY = 'hidden';
	}

	function resetHeight() {
		var edit = self.edit;
		var body = edit.doc.body;
		edit.iframe.height(minHeight);
		self.resize(null, Math.max((K.IE ? body.scrollHeight : body.offsetHeight) + 76, minHeight));
	}

	function init() {
		minHeight = K.removeUnit(self.height);

		self.edit.afterChange(resetHeight);
		hideScroll();
		resetHeight();
	}

	if (self.isCreated) {
		init();
	} else {
		self.afterCreate(init);
	}
});

/*
* 如何实现真正的自动高度？
* 修改编辑器高度之后，再次获取body内容高度时，最小值只会是当前iframe的设置高度，这样就导致高度只增不减。
* 所以每次获取body内容高度之前，先将iframe的高度重置为最小高度，这样就能获取body的实际高度。
* 由此就实现了真正的自动高度
* 测试：chrome、firefox、IE9、IE8
* */
