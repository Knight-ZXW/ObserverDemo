package com.zxw.observerdemo.observer;

/**
 * Created by zxw on 2015/12/3.
 * email:370820883@qq.com
 * website:www.up9527.com
 */
public class Notifier {
    private static volatile Notifier mNotifier;
    private Notifier(){

    }

    public static Notifier getInstance(){
        if(mNotifier==null){
            mNotifier=new Notifier();
        }
        return mNotifier;
    }

    public void NotifyActivity(String eventType){
        EventSubject eventSubject=EventSubject.getInstance();
        EventType eventTypes=EventType.getInstance();
        if(eventTypes.contains(eventType)){
            eventSubject.notifyObserver(eventType);
        }
    }
}
