package git.example.dell.clockmodel.myvideo.model;

import java.util.List;

/**
 * Created by dell on 2018/4/26.
 */

public class VideoDetailBean {

    /**
     * msg : 获取详情成功
     * code : 0
     * data : {"commentNum":5,"comments":[{"cid":256,"content":"大苏打实打实","createTime":"2018-01-27T17:46:41","jid":null,"mvp":null,"nickname":"全村人的希望","praiseNum":0,"uid":2944,"wid":255},{"cid":259,"content":"12212","createTime":"2018-01-28T15:24:33","jid":null,"mvp":null,"nickname":"全村人的希望","praiseNum":0,"uid":2944,"wid":255},{"cid":271,"content":"11111111111","createTime":"2018-03-21T15:33:59","jid":null,"mvp":null,"nickname":"我的脚脖子啊","praiseNum":0,"uid":12248,"wid":255},{"cid":295,"content":"666","createTime":"2018-03-23T19:21:00","jid":null,"mvp":null,"nickname":"给大哥点点关注","praiseNum":0,"uid":12472,"wid":255},{"cid":317,"content":"啥都会","createTime":"2018-03-31T11:00:31","jid":null,"mvp":null,"nickname":"日出东方","praiseNum":0,"uid":12400,"wid":255}],"cover":"https://www.zhaoapi.cn/images/quarter/1516884385549s5.jpg","createTime":"2018-01-25T20:46:25","favoriteNum":8,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":346,"praiseNum":7,"uid":1758,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15168843855498b9d38e2416441b4d34e6be3229ff777.mp4","wid":255,"workDesc":null}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 5
         * comments : [{"cid":256,"content":"大苏打实打实","createTime":"2018-01-27T17:46:41","jid":null,"mvp":null,"nickname":"全村人的希望","praiseNum":0,"uid":2944,"wid":255},{"cid":259,"content":"12212","createTime":"2018-01-28T15:24:33","jid":null,"mvp":null,"nickname":"全村人的希望","praiseNum":0,"uid":2944,"wid":255},{"cid":271,"content":"11111111111","createTime":"2018-03-21T15:33:59","jid":null,"mvp":null,"nickname":"我的脚脖子啊","praiseNum":0,"uid":12248,"wid":255},{"cid":295,"content":"666","createTime":"2018-03-23T19:21:00","jid":null,"mvp":null,"nickname":"给大哥点点关注","praiseNum":0,"uid":12472,"wid":255},{"cid":317,"content":"啥都会","createTime":"2018-03-31T11:00:31","jid":null,"mvp":null,"nickname":"日出东方","praiseNum":0,"uid":12400,"wid":255}]
         * cover : https://www.zhaoapi.cn/images/quarter/1516884385549s5.jpg
         * createTime : 2018-01-25T20:46:25
         * favoriteNum : 8
         * latitude : 39.95
         * localUri : null
         * longitude : 116.30
         * playNum : 346
         * praiseNum : 7
         * uid : 1758
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/15168843855498b9d38e2416441b4d34e6be3229ff777.mp4
         * wid : 255
         * workDesc : null
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private Object workDesc;
        private List<CommentsBean> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public Object getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(Object workDesc) {
            this.workDesc = workDesc;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1516841991537timg.jpg
             * nickname : 熊猫
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }

            @Override
            public String toString() {
                return "UserBean{" +
                        "age=" + age +
                        ", fans='" + fans + '\'' +
                        ", follow=" + follow +
                        ", icon='" + icon + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", praiseNum='" + praiseNum + '\'' +
                        '}';
            }
        }

        public static class CommentsBean {
            /**
             * cid : 256
             * content : 大苏打实打实
             * createTime : 2018-01-27T17:46:41
             * jid : null
             * mvp : null
             * nickname : 全村人的希望
             * praiseNum : 0
             * uid : 2944
             * wid : 255
             */

            private int cid;
            private String content;
            private String createTime;
            private Object jid;
            private Object mvp;
            private String nickname;
            private int praiseNum;
            private int uid;
            private int wid;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getJid() {
                return jid;
            }

            public void setJid(Object jid) {
                this.jid = jid;
            }

            public Object getMvp() {
                return mvp;
            }

            public void setMvp(Object mvp) {
                this.mvp = mvp;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }

            @Override
            public String toString() {
                return "CommentsBean{" +
                        "cid=" + cid +
                        ", content='" + content + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", jid=" + jid +
                        ", mvp=" + mvp +
                        ", nickname='" + nickname + '\'' +
                        ", praiseNum=" + praiseNum +
                        ", uid=" + uid +
                        ", wid=" + wid +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "VideoDetailBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
