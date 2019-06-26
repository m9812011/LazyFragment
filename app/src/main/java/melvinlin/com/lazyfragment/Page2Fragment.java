package melvinlin.com.lazyfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Page2Fragment extends Fragment {

    private static final String params = "params2";
    private String title;
    private TextView textView;

    public static Page2Fragment newInstance(String title) {
        Page2Fragment pageFragment = new Page2Fragment();
        Bundle bundle = new Bundle();
        bundle.putString(params, title);
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public void setInitialSavedState(@Nullable SavedState state) {
        super.setInitialSavedState(state);
        Log.d("Test", "page2 >> setInitialSavedState >> " + state.toString());
    }

    // 判斷當前的Fragment是否正在顯示
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("Test", "page2 >> setUserVisibleHint >> " + isVisibleToUser);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        Log.d("Test","page2 >> onHiddenChanged >> "+ hidden);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Test", "page2 >> onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(params);
        }

        Log.d("Test", "page2 >> onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        textView = view.findViewById(R.id.tv_page_test);
        Log.d("Test", "page2 >> onCreateView()");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Test", "page2 >> onActivityCreated()");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("Test", "page2 >> onViewCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Test", "page2 >> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Test", "page2 >> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Test", "page2 >> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Test", "page2 >> onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Test", "page2 >> onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Test", "page2 >> onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Test", "page2 >> onDetach()");
    }
}
