package com.zxw.observerdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.zxw.observerdemo.observer.EventObserver;
import com.zxw.observerdemo.observer.EventSubject;

import java.lang.ref.WeakReference;

/**
 * Created by zxw on 2015/12/3.
 * email:370820883@qq.com
 * website:www.up9527.com
 */
public abstract class BaseObserverActivity extends AppCompatActivity{

    private ActivityEventObserver mActivityEventObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityEventObserver = new ActivityEventObserver(this);
        registerObserver(mActivityEventObserver);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeObserver(mActivityEventObserver);
    }


    public void registerObserver(EventObserver observer){
        //获得该对象 想要关注的EventType列表
        final String[] observerEventTypes = getObserverEventType();

        if (observerEventTypes !=null && observerEventTypes.length >0){
            final EventSubject eventSubject = EventSubject.getInstance();
            for (String eventType : observerEventTypes) {
                eventSubject.registerObserver(eventType,observer);
            }
        }
    }

    public void removeObserver(EventObserver observer){

    }


    /**
     * 该方法会在具体的观察者对象中调用，可以根据事件的类型来更新对应的UI，这个方法在UI线程中被调用，
     * 所以在该方法中不能进行耗时操作，可以另外开线程
     * @param eventType 事件类型
     */
    protected abstract void onChange(String eventType);

    /**
     * 通过这个方法来告诉具体的观察者需要监听的业务类型
     * @return
     */
    protected abstract String[] getObserverEventType();


    private static class ActivityEventObserver extends EventObserver{

        private final WeakReference<BaseObserverActivity> mActivity;

        public ActivityEventObserver(BaseObserverActivity mActivity) {
            super();
            this.mActivity = new WeakReference<BaseObserverActivity>(mActivity);
        }

        @Override
        public void onChange(String eventType) {
            BaseObserverActivity activity = mActivity.get();
            if (activity != null){
                activity.onChange(eventType);
            }
        }
    }
}

