package com.zxw.observerdemo.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zxw on 2015/12/3.
 * email:370820883@qq.com
 * website:www.up9527.com
 */
public class EventType {

    private static volatile EventType mEventType;
    private final static Set<String> eventsTypes = new HashSet<String>();


    ////可以添加更多的Event
    public final static String UPDATE_TEXT="UPDATE_TEXT";
    private EventType(){
        eventsTypes.add(UPDATE_TEXT);
    }

    public static EventType getInstance(){
        if(mEventType==null){
            mEventType=new EventType();
        }
        return mEventType;
    }

    public boolean contains(String eventType){
        return eventsTypes.contains(eventType);
    }

}
