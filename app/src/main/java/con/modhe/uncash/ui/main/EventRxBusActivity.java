package con.modhe.uncash.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import con.modhe.uncash.R;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * author Created by harrishuang on 2020-09-09.
 * email : huangjinping1000@163.com
 */
public class EventRxBusActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventrxbus);
        initView();
        EventRxBus3.getInstance().register("usc").subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                View view = (View) o;
                Log.d("===", view.getTag().toString());
                Toast.makeText(EventRxBusActivity.this, "usc111", Toast.LENGTH_SHORT).show();
            }
        });
        EventRxBus3.getInstance().register("usc").subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Toast.makeText(EventRxBusActivity.this, "usc222", Toast.LENGTH_SHORT).show();
            }
        });
        EventRxBus3.getInstance().register("usc").subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Toast.makeText(EventRxBusActivity.this, "usc333", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onClickView(View view) {
        Log.d("===", "onClickView");
        view.setTag("usc");
        EventRxBus3.getInstance().post("usc", view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_action:
                onClickView(view);
                break;
        }
    }

    private void initView() {
        btn_action = (Button) findViewById(R.id.btn_action);
        btn_action.setOnClickListener(this);
    }
}
