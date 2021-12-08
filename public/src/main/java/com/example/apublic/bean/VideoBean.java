package com.example.apublic.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

public class VideoBean extends BaseJHBean implements Serializable {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * nickname : 陈三废gg 今晚8点直播
         * follower_count : 26994316
         * effect_value : 12932086
         * avatar : https://p3.douyinpic.com/aweme/100x100/1722f00039b6483f26311.jpeg?from=2956013662
         * video_list : [{"item_cover":"https://p6.douyinpic.com/img/tos-cn-p-0015/9aba2f1f4d1a42bab5969cb4c717d783~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6961307612562427167/?region=CN&mid=6961307645462514471&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"这婆婆太偏向儿子了\u2026\u2026"},{"item_cover":"https://p6.douyinpic.com/img/tos-cn-p-0015/a60500fc33bc401ca16da8d587b2ea9a~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6960982098987519239/?region=CN&mid=6960982134035516168&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"今天带着公公婆婆妈妈弟弟妹妹出来旅行，两家人都超级开心，幸福就是全家人和和睦睦的在一起❤️"},{"item_cover":"https://p6.douyinpic.com/img/tos-cn-p-0015/324bb8fdc7104360bab61afac3ff5b1e~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6960954027999759646/?region=CN&mid=6960954064251210510&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"感谢公公婆婆的配合 让我成为新一代的套圈王??"},{"item_cover":"https://p6.douyinpic.com/img/tos-cn-p-0015/306e572db816420d9570c0c2af07042c~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6960941891860909348/?region=CN&mid=6960941930909879054&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"看在口红的面上 我就帮我公公一次吧\u2026\u2026"},{"item_cover":"https://p9.douyinpic.com/img/tos-cn-p-0015/f544f56ef5834c7a8107cc0a1270b7ec~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6960608939402693924/?region=CN&mid=6960608973196102431&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"今晚就不直播了，明天晚上8点见～"},{"title":"今天是母亲节 祝所有妈妈节日快乐 你们辛苦了～","item_cover":"https://p6.douyinpic.com/img/tos-cn-p-0015/6373e26c47af485a8c2e74d7cfe47e64~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6960198264104684830/?region=CN&mid=6960198290466212615&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1"},{"item_cover":"https://p3.douyinpic.com/img/tos-cn-p-0015/e551276fe77f41638136355255ca3a6f~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6959827173784046885/?region=CN&mid=6959827130800753441&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"这儿媳妇 太厉害了\u2026\u2026"},{"item_cover":"https://p3.douyinpic.com/img/tos-cn-p-0015/767b7e5c01cc4b608b17717b379c29df~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6959468650822782216/?region=CN&mid=6959468699436354335&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"听说90%的人 做这个动作都站不起来？#快来试试"},{"item_cover":"https://p3.douyinpic.com/img/tos-cn-p-0015/658a9aa5e1fe47f6935c8604715a01c3~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6958780422629248293/?region=CN&mid=6943465516287690789&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"怀孕马上7个月了，最近每天工作量大，缺氧了，还好公公婆婆是医生，不用再去医院吸氧了！"},{"item_cover":"https://p29.douyinpic.com/img/tos-cn-p-0015/bce3614fe7ad4a6cb58769adb2b77337~c5_300x400.jpeg?from=2563711402_large","share_url":"https://www.iesdouyin.com/share/video/6958738718555376910/?region=CN&mid=6958738742140717860&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1","title":"套路老婆的正确方式?"}]
         */

        private String nickname;
        private int follower_count;
        private int effect_value;
        private String avatar;
        private List<VideoListBean> video_list;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(int follower_count) {
            this.follower_count = follower_count;
        }

        public int getEffect_value() {
            return effect_value;
        }

        public void setEffect_value(int effect_value) {
            this.effect_value = effect_value;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public List<VideoListBean> getVideo_list() {
            return video_list;
        }

        public void setVideo_list(List<VideoListBean> video_list) {
            this.video_list = video_list;
        }

        public static class VideoListBean implements Serializable {
            /**
             * item_cover : https://p6.douyinpic.com/img/tos-cn-p-0015/9aba2f1f4d1a42bab5969cb4c717d783~c5_300x400.jpeg?from=2563711402_large
             * share_url : https://www.iesdouyin.com/share/video/6961307612562427167/?region=CN&mid=6961307645462514471&u_code=0&titleType=title&did=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&iid=MS4wLjABAAAANwkJuWIRFOzg5uCpDRpMj4OX-QryoDgn-yYlXQnRwQQ&with_sec_did=1
             * title : 这婆婆太偏向儿子了……
             */

            private String item_cover;
            private String share_url;
            private String title;

            public String getItem_cover() {
                return item_cover;
            }

            public void setItem_cover(String item_cover) {
                this.item_cover = item_cover;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
