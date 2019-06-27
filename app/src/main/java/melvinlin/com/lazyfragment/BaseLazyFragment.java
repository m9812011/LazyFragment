package melvinlin.com.lazyfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseLazyFragment extends Fragment {

    protected boolean mLoadDataFinished;     // 表示数据是否已经请求完毕
    protected boolean mViewInflateFinished;  // 表示找控件完成, 给控件们设置数据不会报空指针
    protected static final int TIME = 500;
    private boolean mHaveLoadData;           // 表示是否已经请求过数据
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 控件已加載過
        if (mRootView != null) {
            return mRootView;
        }

        // 第一次進入加載控件，並標示已找控件完成
        mRootView = bindView(inflater, container, savedInstanceState);
        mViewInflateFinished = true;
        return mRootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // 如果还没有加载过数据 && 用户切换到了这个fragment
        // 那就开始加载数据
        if (!mHaveLoadData && isVisibleToUser) {
            loadDataStart();
            mHaveLoadData = true;
        }
    }

    protected abstract void loadDataStart();
    protected abstract View bindView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState);

}
