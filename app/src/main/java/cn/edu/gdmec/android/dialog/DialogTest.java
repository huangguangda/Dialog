package cn.edu.gdmec.android.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class DialogTest extends AppCompatActivity {
    ProgressDialog mydialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_dialog_test );

        Dialog dialog=new AlertDialog.Builder ( DialogTest.this ).setTitle ( "登录提示" ).setMessage ( "这里需要登录" ).setPositiveButton ( "确定", new DialogInterface.OnClickListener (){
            @Override
            public void onClick(DialogInterface dialog, int which){
                LayoutInflater factory=LayoutInflater.from ( DialogTest.this );
                final View DialogView=factory.inflate ( R.layout.activity_dialog_test, null );
                android.app.AlertDialog dlg=new AlertDialog.Builder ( DialogTest.this ).setTitle ( "登录框" ).setView ( DialogView ).setPositiveButton ( "确定", new DialogInterface.OnClickListener (){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        mydialog=ProgressDialog.show ( DialogTest.this, "请稍等...", "正在登录...",true );
                        new Thread (  )
                        {
                            public void run()
                            {
                                try
                                {
                                    sleep ( 3000 );
                                }catch (Exception e)
                                {
                                    e.printStackTrace ();
                                }finally {
                                    mydialog.dismiss ();
                                }
                            }
                        }.start ();
                    }
                } ).setNegativeButton ( "取消", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                            DialogTest.this.finish ();
                    }
                } ).create ();
                dlg.show ();
            }
        } ).setNegativeButton ( "退出", new DialogInterface.OnClickListener (){
            @Override
            public void onClick(DialogInterface dialog, int which){
                DialogTest.this.finish ();
            }
        } ).create ();
        dialog.show ();
    }
}
