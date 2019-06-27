package melvinlin.com.lazyfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseLazyFragment extends Fragment {

    protected boolean mLoadDataFinished;     // Fragment內的數據是否已經請求完畢
    protected boolean mViewInflateFinished;  // Fragment的View加載完畢標示, 給控件們設置數據不會報空指針

    protected static final int TIME = 500;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 控件已inflater產生過
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
        if (!mLoadDataFinished && isVisibleToUser) {
            loadDataStart();
        }
    }

    protected abstract void loadDataStart();
    protected abstract View bindView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState);

}
