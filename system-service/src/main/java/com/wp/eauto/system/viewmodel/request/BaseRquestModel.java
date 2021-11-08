package com.wp.eauto.system.viewmodel.request;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User:Administrator
 * Date:2021/11/8
 * Time:16:35
 * Description: No Description
 */
@Data
public class BaseRquestModel {
    public BaseRquestModel(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        this.curDate =df.format(new Date());
    }
    public String curUserId;

    public String curDate;
}
