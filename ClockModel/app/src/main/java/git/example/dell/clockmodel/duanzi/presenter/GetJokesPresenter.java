package git.example.dell.clockmodel.duanzi.presenter;

import git.example.dell.clockmodel.bean.GetJokeBean;
import git.example.dell.clockmodel.bean.PostJokesBean;
import git.example.dell.clockmodel.duanzi.mvp.IJokes;
import git.example.dell.clockmodel.duanzi.mvp.NetWorkCallBack;
import git.example.dell.clockmodel.duanzi.model.JokesModel;

/**
 * Created by ASUS on 2018/4/25.
 */

public class GetJokesPresenter implements IJokes.IGetJokesPresenter {
    private JokesModel jokesModel;
    private IJokes.IGetJokesView iGetJokesView;

    public GetJokesPresenter(IJokes.IGetJokesView iGetJokesView){
        jokesModel = new JokesModel();
        this.iGetJokesView = iGetJokesView;
    }

    @Override
    public void postJokes(String uid,String content,String token) {
        jokesModel.postJokes(uid,content,token,new NetWorkCallBack<PostJokesBean>() {
            @Override
            public void Success(PostJokesBean postJokesBean) {
                iGetJokesView.postJokesSuccess(postJokesBean);

            }

            @Override
            public void Error(String err) {

            }
        });
    }

    @Override
    public void getJokes(String page) {
        jokesModel.getJokes(page, new NetWorkCallBack<GetJokeBean>() {
            @Override
            public void Success(GetJokeBean getJokeBean) {
                iGetJokesView.getJokesSuccess(getJokeBean);

            }

            @Override
            public void Error(String err) {
                iGetJokesView.error(err);
            }
        });
    }
}
