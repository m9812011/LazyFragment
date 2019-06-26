package melvinlin.com.lazyfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment {
    //该Fragment是否创建过
    private boolean isCreated = false;
    //该Fragment是否初始过
    private boolean isInit = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isCreated && isVisibleToUser && !isInit) {
            Initialize();
            isInit = true;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isCreated = true;
        if (isCreated && getUserVisibleHint() && !isInit) {
            Initialize();
            isInit = true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isCreated = false;
        isInit = false;
    }

    /**
     * 初始化方法
     */
    protected abstract void Initialize();
}
