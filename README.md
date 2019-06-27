### Fragment 懶(延遲)加載機制
1.了解Fragment生命週期變化<br>
2.使用 TabLayout + ViewPager，ViewPager內的 setOffscreenPageLimit(int limit) 方法，源碼內有判斷至少會預加載左右兩側相鄰的1個頁面。<br>
3.使用Fragment中的 setUserVisibleHint(boolean isVisibleToUser) 方法，可得知使用的Fragment是否顯示在當前頁面<br>
4.延遲加載,就是等到該Fragment頁面展示給用戶時,再加載該頁面的數據(從網絡、數據庫等)

### 參考文件
Fragment生命周期及懒加载<br>
https://www.jianshu.com/p/19a6df7792bb<br>
ViewPager+Fragment组合的预加载和懒加载<br>
https://www.jianshu.com/p/7a47907f49c2<br>
Fragment结合ViewPager之懒加载<br>
https://www.jianshu.com/p/eaf4302a1864<br>
Fragment懒加载其实很简单<br>
https://www.jianshu.com/p/5c5c778d862e
