package com.zxw.observerdemo.observer;

import com.zxw.observerdemo.observerInterface.EventSubjectInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zxw on 2015/12/3.
 * email:370820883@qq.com
 * website:www.up9527.com
 */
public class EventSubject implements EventSubjectInterface{

    /**
     * 注册的观察者集合
     */
    private Map<String, ArrayList<EventObserver>> mEventObservers = new HashMap<>();

    /////////////////////////////////////////////////////////////////////
    //使用单例模式，
    private volatile static EventSubject mEventSubject;
    private EventSubject(){}

    public  static EventSubject getInstance(){
        if (mEventSubject == null){
            synchronized (EventSubject.class) {
                if (mEventSubject == null)
                mEventSubject = new EventSubject();

            }
        }
        return mEventSubject;
    }
    /////////////////////////////////////////////////////////////////////

    @Override
    public void registerObserver(String eventType, EventObserver observer) {
        synchronized (mEventObservers){
            ArrayList<EventObserver> eventObservers = mEventObservers.get(eventType);
            if (eventObservers == null){
                eventObservers = new ArrayList<>();
                mEventObservers.put(eventType,eventObservers);
            }
            //存在即不在添加
            if (eventObservers.contains(observer)){
                return;
            }
            eventObservers.add(observer);
        }
    }

    @Override
    public void removeObserver(String eventType, EventObserver observer) {
        synchronized (mEventObservers){
            int index = mEventObservers.get(eventType).indexOf(observer);
            if (index >= 0){
                mEventObservers.remove(index);
            }
        }
    }

    @Override
    public void notifyObserver(String eventType) {
        if (mEventObservers != null && mEventObservers.size()>0 && eventType !=null){
            ArrayList<EventObserver> eventObservers = mEventObservers.get(eventType);
            if (eventObservers != null){
                for (EventObserver observer : eventObservers) {
                    //todo
                    observer.dispatchChange(eventType);
                }
            } else {
                throw new RuntimeException("eventObservers is null, the eventType"+eventType+" may be not register");
            }
        }
    }
}
