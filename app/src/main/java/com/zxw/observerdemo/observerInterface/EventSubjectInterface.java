package com.zxw.observerdemo.observerInterface;

import com.zxw.observerdemo.observer.EventObserver;

/**
 * Created by zxw on 2015/12/3.
 * email:370820883@qq.com
 * website:www.up9527.com
 */
public interface EventSubjectInterface {

    /**
     * 注册观察者
     * @param eventType 事件类型
     * @param observer 观察者
     */
    void registerObserver(String eventType,EventObserver observer);

    /**
     * 移除观察者
     * @param eventType 事件类型
     * @param observer 观察者
     */
    void removeObserver(String eventType, EventObserver observer);

    /**
     * 通知观察者事件的发生
     * @param eventType 事件类型
     */
    void notifyObserver(String eventType);
}
