package cn.com.dyninfo.o2o.furniture.sys.service;

import cn.com.dyninfo.o2o.furniture.util.FreeMarkerUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/7/28.
 */
@Service
public class ScheduleTask {

    @Scheduled(fixedRate=300000)
    @Transactional(readOnly = true)
    public void generateIndex() {
        FreeMarkerUtils.genIndex();
    }
}
