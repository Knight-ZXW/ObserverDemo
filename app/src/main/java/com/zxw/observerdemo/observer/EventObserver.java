package com.zxw.observerdemo.observer;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.zxw.observerdemo.observerInterface.EventObserverInterface;


/**
 * Created by zxw on 2015/12/3.
 * email:370820883@qq.com
 * website:www.up9527.com
 */
public abstract class EventObserver implements EventObserverInterface{

    private Handler mHandler;

    public EventObserver(){
        mHandler = new Handler(Looper.getMainLooper()) ;
    }

    public abstract void onChange(String eventType);
    @Override
    public void dispatchChange(String eventType) {
        mHandler.post(new NotificationRunnable(eventType));
    }

    private final class NotificationRunnable implements Runnable{

        private String mEventType;

        public NotificationRunnable(String mEventType) {
            this.mEventType = mEventType;
        }

        @Override
        public void run() {
            EventObserver.this.onChange(mEventType);
        }
    }
}
