package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.UserInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class UserInfoDomain extends UserInfoModel {
    private List<OgnzInfoDomain> ognzs;
    private List<RoleInfoDomain> roles;
    private ShangJiaInfoDomain shanfJiaInfo;
    private  UserInfoDomain daili;
    private  List<LogDomain> log;
    private  AgentGradeDomain agentGrade;

    public List<OgnzInfoDomain> getOgnzs() {
        return ognzs;
    }

    public void setOgnzs(List<OgnzInfoDomain> ognzs) {
        this.ognzs = ognzs;
    }

    public List<RoleInfoDomain> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfoDomain> roles) {
        this.roles = roles;
    }

    public ShangJiaInfoDomain getShanfJiaInfo() {
        return shanfJiaInfo;
    }

    public void setShanfJiaInfo(ShangJiaInfoDomain shanfJiaInfo) {
        this.shanfJiaInfo = shanfJiaInfo;
    }

    public UserInfoDomain getDaili() {
        return daili;
    }

    public void setDaili(UserInfoDomain daili) {
        this.daili = daili;
    }

    public AgentGradeDomain getAgentGrade() {
        return agentGrade;
    }

    public void setAgentGrade(AgentGradeDomain agentGrade) {
        this.agentGrade = agentGrade;
    }

    public List<LogDomain> getLog() {
        return log;
    }

    public void setLog(List<LogDomain> log) {
        this.log = log;
    }
}
