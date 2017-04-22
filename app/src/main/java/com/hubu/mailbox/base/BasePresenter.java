package com.hubu.mailbox.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

//基础present类
public abstract class BasePresenter<T> {
    //View接口的弱引用
    protected Reference<T> mVieWRef ;

    //获取关联
    protected T getView(){
        return mVieWRef.get();
    }

    //解除关联
    public void detachView(){
        if (mVieWRef != null){
            mVieWRef.clear();
            mVieWRef = null;
        }
    }

    //建立关联
    public void attachView(T view){
        mVieWRef = new WeakReference<T>(view) ;
    }

    //判断是否已经与 View 关联
    public boolean isViewAttached(){
        return mVieWRef != null && mVieWRef.get() != null;
    }
}
