package melvinlin.com.lazyfragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private TabLayout tabLayout;
  private ViewPager viewPager;
  private List<Fragment> fragmentList;
  private int count = 4;
  private List<String> titles;
  private PageAdapter pageAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();
    initData();
  }

  private void initView() {
      tabLayout = findViewById(R.id.tablayout);
      viewPager = findViewById(R.id.viewpager);
  }

  private void initData() {
      getDate();
      pageAdapter = new PageAdapter(getSupportFragmentManager());
      viewPager.setAdapter(pageAdapter);
      // TabLayout綁定ViewPager
      tabLayout.setupWithViewPager(viewPager);
  }

  private void getDate() {
      fragmentList = new ArrayList<>();
      titles = new ArrayList<>();

      for (int i = 0; i < count; i++) {
          titles.add("頁面" + i);
      }

      fragmentList.add(Page0Fragment.newInstance(titles.get(0)));
      fragmentList.add(Page1Fragment.newInstance(titles.get(1)));
      fragmentList.add(Page2Fragment.newInstance(titles.get(2)));
      fragmentList.add(Page3Fragment.newInstance(titles.get(3)));

  }

  private class PageAdapter extends FragmentPagerAdapter {

      public PageAdapter(FragmentManager fm) {
          super(fm);
      }

      @Override
      public Fragment getItem(int i) {
          return fragmentList.get(i);
      }

      @Override
      public int getCount() {
          return fragmentList.size();
      }

      @Nullable
      @Override
      public CharSequence getPageTitle(int position) {
          return titles.get(position);
      }
  }

}
