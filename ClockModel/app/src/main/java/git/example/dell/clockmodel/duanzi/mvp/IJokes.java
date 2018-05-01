package git.example.dell.clockmodel.duanzi.mvp;

import git.example.dell.clockmodel.bean.GetJokeBean;
import git.example.dell.clockmodel.bean.PostJokesBean;

/**
 * Created by ASUS on 2018/4/25.
 */

public interface IJokes {
    public interface IGetJokesModel{
        public void postJokes(String uid,String content,String token,NetWorkCallBack<PostJokesBean> netWorkCallBack);
        public void getJokes(String page,final NetWorkCallBack<GetJokeBean> netWorkCallBack);
    }

    public interface IGetJokesPresenter{
        public void postJokes(String uid,String content,String token);
        public void getJokes(String page);
    }

    public interface IGetJokesView{
        public void postJokesSuccess(PostJokesBean postJokesBean);
        public void getJokesSuccess(GetJokeBean getJokeBean);
        public void error(String err);
    }
}
