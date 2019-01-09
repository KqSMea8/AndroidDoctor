package so_test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oceanlong.sotestlib.SoTestLoader;
import com.ocean.doctor.androiddoctor.R;

/**
 * Created by oceanlong on 2019/1/9.
 */

public class SOTestActivity extends Activity{

    Button mBtnTest;
    TextView mTvTest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.so_test_activity_layout);
        SoTestLoader.init();
        mTvTest = findViewById(R.id.textView);
        mBtnTest = findViewById(R.id.button);
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = SoTestLoader.getTestString();
                mTvTest.setText(t);
            }
        });
    }
}
