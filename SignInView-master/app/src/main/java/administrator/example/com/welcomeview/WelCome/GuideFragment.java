package administrator.example.com.welcomeview.WelCome;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import administrator.example.com.welcomeview.R;
import administrator.example.com.welcomeview.WelCome.CustomVideoView;

public class GuideFragment extends Fragment {

    private CustomVideoView customVideoView;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customVideoView = new CustomVideoView(getContext());
        /**获取参数，根据不同的参数播放不同的视频**/
        int index = getArguments().getInt("index");
        Uri uri;
        if (index == 1) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);
        } else if (index == 2) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);
        } else {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
        }
        /**播放视频**/
        customVideoView.playVideo(uri);
        return customVideoView;
    }
    /**
     * 记得在销毁的时候让播放的视频终止
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (customVideoView != null) {
            customVideoView.stopPlayback();
        }
    }
}
