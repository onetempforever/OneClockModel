package git.example.dell.clockmodel.duanzi.mvp;

/**
 * Created by ASUS on 2018/4/25.
 */

public interface NetWorkCallBack<T> {
    public void Success(T t);
    public void Error(String err);
}
