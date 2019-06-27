package melvinlin.com.lazyfragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlaceholderFragment1 extends BaseLazyFragment {

    private TextView mTextView;
    private ProgressBar mPb;
    private Handler mHandler = new Handler();
    private String mData;

    public PlaceholderFragment1() {
    }

    public static PlaceholderFragment1 newInstance() {
        PlaceholderFragment1 fragment = new PlaceholderFragment1();
        return fragment;
    }

    @Override
    public void loadDataStart() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mData = "这是加载下来的数据";
                // 一旦获取到数据, 就应该立刻标记数据加载完成
                mLoadDataFinished = true;
                if (mViewInflateFinished) {
                    mTextView.setVisibility(View.VISIBLE);
                    mTextView.setText(mData);
                    mTextView.setText("这是改变后的数据");
                    mPb.setVisibility(View.GONE);
                }
            }
        }, TIME);
    }

    @Override
    protected View bindView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        mTextView = view.findViewById(R.id.section_label);
        mPb = view.findViewById(R.id.pb);
        if (mLoadDataFinished) { // 一般情况下这时候数据请求都还没完成, 所以不会进这个if
            mTextView.setVisibility(View.VISIBLE);
            mTextView.setText(mData);
            mPb.setVisibility(View.GONE);
        }

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("Test", "page1 >> setUserVisibleHint >> " + isVisibleToUser);
    }

    /**
     * 驗證Fragment生命週期
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Test", "page1 >> onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Test", "page1 >> onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Test", "page1 >> onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Test", "page1 >> onActivityCreated()");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("Test", "page1 >> onViewCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Test", "page1 >> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Test", "page1 >> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Test", "page1 >> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Test", "page1 >> onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Test", "page1 >> onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Test", "page1 >> onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Test", "page1 >> onDetach()");
    }
}
