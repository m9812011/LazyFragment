package melvinlin.com.lazyfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private List<Fragment> fragmentList;
  private List<String> titles;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initData();

    TabLayout tabLayout = findViewById(R.id.tablayout);
    ViewPager viewPager = findViewById(R.id.viewpager);
    viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), fragmentList, titles));
    // TabLayout綁定ViewPager
    tabLayout.setupWithViewPager(viewPager);
  }

  private void initData() {
      fragmentList = new ArrayList<>();
      titles = new ArrayList<>();

      for (int i = 0; i < 4; i++) {
          titles.add("頁面" + i);
      }

      fragmentList.add(PlaceholderFragment0.newInstance());
      fragmentList.add(PlaceholderFragment1.newInstance());
      fragmentList.add(PlaceholderFragment2.newInstance());
      fragmentList.add(PlaceholderFragment3.newInstance());
  }

}
