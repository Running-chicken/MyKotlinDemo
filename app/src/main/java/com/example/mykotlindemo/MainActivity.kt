package com.example.mykotlindemo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.IBinder.FIRST_CALL_TRANSACTION
import android.os.Parcel
import android.os.RemoteException
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.cc.skillapp.IAidlInterface
import com.example.mykotlindemo.activity.ContentProviderActivity
import com.example.mykotlindemo.activity.LambdaActivity
import com.example.mykotlindemo.activity.ListActivity
import com.example.mykotlindemo.databinding.ActivityMainBinding
import com.example.mykotlindemo.utils.RouterPath
import com.example.mykotlindemo.utils.Utils


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        mBinding.tvParams.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_PARAMS).navigation()
        }

        mBinding.tvCondition.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_CONDITION).navigation()
        }

        mBinding.tvCharacter.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_CHARACTER).navigation()
        }

        mBinding.tvFunction.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_FUNCTION).navigation()
        }

        mBinding.tvClass.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_CLASS).navigation()
        }

        mBinding.tvLambda.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                var intent = Intent()
                intent.setClass(this@MainActivity,LambdaActivity::class.java)
                startActivity(intent)
            }
        })

        mBinding.tvList.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                var intent = Intent();
                intent.setClass(this@MainActivity,ListActivity::class.java)
                startActivity(intent)
            }
        })

        mBinding.tvVp.setOnClickListener{
            ARouter.getInstance().build(RouterPath.Technology.TECH_VP).navigation()
        }

        mBinding.tvBroadcastReceiver.setOnClickListener{
            val intent = Intent("com.cc.me.broadcast")
            intent.putExtra("params", "im kt demo")
            intent.component = ComponentName("com.cc.skillapp", "com.cc.skillapp.receive.MyBroadReceive")
            sendBroadcast(intent)
        }

        mBinding.tvContentProvider.setOnClickListener {
            var intent = Intent(this,ContentProviderActivity::class.java)
            startActivity(intent)
        }

        mBinding.tvBinder.setOnClickListener {
            var intent = Intent()
            intent.component = ComponentName("com.cc.skillapp","com.cc.skillapp.test.binder.BinderService");
            bindService(intent,conn, BIND_AUTO_CREATE)
        }

        mBinding.tvBinderAidl.setOnClickListener {
            var intent = Intent()
//            intent.setAction("com.cc.skillapp.test.aidl.IMyAidlInterface");
            intent.component = ComponentName("com.cc.skillapp","com.cc.skillapp.test.aidl.AidlService")
            bindService(intent,connAidl, BIND_AUTO_CREATE)
        }
    }


    lateinit var myAidlInterface : IAidlInterface


    var connAidl = object:ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            myAidlInterface = IAidlInterface.Stub.asInterface(service)
            Utils.print("结果是 ${myAidlInterface.add(100,200)}")

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }

    }



    var conn = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            var data = Parcel.obtain()
            var reply = Parcel.obtain()
            var result = 0

            data.writeInt(1111)
            data.writeInt(2223)

            data.writeInterfaceToken("com.cc.skill.addbinder")

            try {
                service?.transact(FIRST_CALL_TRANSACTION, data, reply, 0)
                result = reply.readInt()
            } catch (e: RemoteException) {
                e.printStackTrace()
            } finally {
                data.recycle()
                reply.recycle()
            }
            Utils.print("得到了：$result")



        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }

    }

}

