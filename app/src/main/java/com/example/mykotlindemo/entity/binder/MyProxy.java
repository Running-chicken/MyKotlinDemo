package com.example.mykotlindemo.entity.binder;


import static com.example.mykotlindemo.entity.binder.MyBinder.ADD;
import static com.example.mykotlindemo.entity.binder.MyBinder.DESCRIPTOR;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class MyProxy implements MyInterface{
    private IBinder iBinder;

    public MyProxy(IBinder iBinder){
        this.iBinder = iBinder;
    }

    @Override
    public int add(int arg0, int arg1) {

        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        int result = 0;

        data.writeInterfaceToken(DESCRIPTOR);
        data.writeInt(arg0);
        data.writeInt(arg1);
        try {
            iBinder.transact(ADD,data,reply,0);
            result = reply.readInt();
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            data.recycle();
            reply.recycle();
        }
        return result;
    }

    @Override
    public IBinder asBinder() {
        return iBinder;
    }
}
