package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.CommentSayModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class CommentSayDomain extends CommentSayModel {
    private HuiyuanInfoDomain huiyuanInfoDomain;
    private CommentInfoDomain commentInfoDomain;

    public HuiyuanInfoDomain getHuiyuanInfoDomain() {
        return huiyuanInfoDomain;
    }

    public void setHuiyuanInfoDomain(HuiyuanInfoDomain huiyuanInfoDomain) {
        this.huiyuanInfoDomain = huiyuanInfoDomain;
    }

    public CommentInfoDomain getCommentInfoDomain() {
        return commentInfoDomain;
    }

    public void setCommentInfoDomain(CommentInfoDomain commentInfoDomain) {
        this.commentInfoDomain = commentInfoDomain;
    }
}
