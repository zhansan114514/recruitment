package com.maven.recruitment.service;

import com.maven.recruitment.pojo.Info.Cdata;
import com.maven.recruitment.pojo.Info.Javadata;
import com.maven.recruitment.pojo.Info.Pythondata;
import com.maven.recruitment.pojo.Info.Websitedata;

import java.util.List;

public interface CorrectingService {

    /**
     * 用于展示cdata表中的数据
     * @return 返回cdata表中的数据
     */
    List<Cdata> CCorrectingService();

    /**
     * 用于修改cdata表中的数据
     * @param cdata 传入的cdata对象
     */
    void CCorrectingService(Cdata cdata);

    /**
     * 用于展示java表中的数据
     * @return 返回java表中的数据
     */
    List<Javadata> JavaCorrectingService();

    /**
     * 用于修改java表中的数据
     * @param javadata 传入的javadata对象
     */
    void JavaCorrectingService(Javadata javadata);

    /**
     * 用于展示机器学习表中的数据
     * @return 返回机器学习表中的数据
     */
    List<Pythondata> PythonCorrectingService();

    /**
     * 用于修改机器学习表中的数据
     * @param pythondata 传入的pythondata对象
     */
    void PythonCorrectingService(Pythondata pythondata);

    /**
     * 用于展示前端表中的数据
     * @return 返回前端表中的数据
     */
    List<Websitedata> WebsiteCorrectingService();

    /**
     * 用于修改前端表中的数据
     * @param websitedata 传入的websitedata对象
     */
    void WebsiteCorrectingService(Websitedata websitedata);
}
