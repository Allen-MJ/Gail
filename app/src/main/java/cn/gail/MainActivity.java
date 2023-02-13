package cn.gail;

import androidx.appcompat.app.AppCompatActivity;
import cn.gail.frame.GailConfig;
import cn.gail.frame.tools.GLog;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GailConfig.init(getApplicationContext());
        GailConfig.setDebug(true);

        GailConfig.with().getStoragePreference()
                .edit()
                .putString("title","ceshi")
                .putInt("sort",1)
                .apply();
        boolean isnew = GailConfig.with().isNewVersion("1,0.1123.124");
        GLog.d("是否新版本："+isnew);
    }
}