package com.example.apublic.bean.home;

import com.example.apublic.bean.BaseJHBean;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class NewsBean extends BaseJHBean implements Serializable {

    /**
     * result : {"stat":"1","data":[{"uniquekey":"49f24da6171cc755740f4123a901002a","title":"温州疾控紧急提醒：有宁波市镇海区旅居史的人员请注意！","date":"2021-12-06 14:57:00","category":"头条","author_name":"人民资讯","url":"https://mini.eastday.com/mobile/211206145728237975611.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_3_mwpm_03201609.jpeg","is_content":"1"}],"page":"1","pageSize":"1"}
     */
    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * stat : 1
         * data : [{"uniquekey":"49f24da6171cc755740f4123a901002a","title":"温州疾控紧急提醒：有宁波市镇海区旅居史的人员请注意！","date":"2021-12-06 14:57:00","category":"头条","author_name":"人民资讯","url":"https://mini.eastday.com/mobile/211206145728237975611.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_3_mwpm_03201609.jpeg","is_content":"1"}]
         * page : 1
         * pageSize : 1
         */

        private String stat;
        private String page;
        private String pageSize;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * uniquekey : 49f24da6171cc755740f4123a901002a
             * title : 温州疾控紧急提醒：有宁波市镇海区旅居史的人员请注意！
             * date : 2021-12-06 14:57:00
             * category : 头条
             * author_name : 人民资讯
             * url : https://mini.eastday.com/mobile/211206145728237975611.html
             * thumbnail_pic_s : https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_1_mwpm_03201609.jpeg
             * thumbnail_pic_s02 : https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_2_mwpm_03201609.jpeg
             * thumbnail_pic_s03 : https://dfzximg02.dftoutiao.com/news/20211206/20211206145728_46adecd7b2c0ac749df140ee7180a1ed_3_mwpm_03201609.jpeg
             * is_content : 1
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;
            private String is_content;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }

            public String getIs_content() {
                return is_content;
            }

            public void setIs_content(String is_content) {
                this.is_content = is_content;
            }
        }
    }
}
