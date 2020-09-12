package administrator.example.com.welcomeview.WelCome2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import administrator.example.com.welcomeview.R;
import administrator.example.com.welcomeview.ce_la_menu.MenuListFragment;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    private FlowingDrawer mDrawer;
    private ImageView menuImageView;
    private ImageView photoImageView;
    private ImageView meImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        ButterKnife.bind(this);
        mDrawer = (FlowingDrawer)findViewById(R.id.drawerlayout);

        menuImageView = (ImageView) findViewById(R.id.menu_image);
        photoImageView = (ImageView) findViewById(R.id.photo_image);
        meImageView = (ImageView) findViewById(R.id.me_image);

        menuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"Hello",Toast.LENGTH_SHORT).show();
            }
        });

        photoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"Hello",Toast.LENGTH_SHORT).show();
            }
        });

        meImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"Hello",Toast.LENGTH_SHORT).show();
            }
        });

        setMenu();
    }

    private void setMenu() {

        FragmentManager fm = getSupportFragmentManager();
        MenuListFragment menuListFragment = (MenuListFragment)fm.findFragmentById(R.id.id_container_menu);
        if(menuListFragment == null){
            menuListFragment = new MenuListFragment();
            fm.beginTransaction().add(R.id.id_container_menu,menuListFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(mDrawer.isMenuVisible()){
            mDrawer.closeMenu();
        }else{
            super.onBackPressed();
        }
    }

}
