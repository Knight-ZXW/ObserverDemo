package com.zxw.observerdemo.observerInterface;

/**
 * Created by zxw on 2015/12/3.
 * email:370820883@qq.com
 * website:www.up9527.com
 */
public interface EventObserverInterface {
    /**
     * 根据事件进行数据或者UI的跟新
     * @param eventType
     */
    void dispatchChange(String eventType);
}
