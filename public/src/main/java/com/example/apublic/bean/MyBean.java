package com.example.apublic.bean;

import java.util.List;

public class MyBean {
    private String title;
    private List<CommentBean> beanList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CommentBean> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<CommentBean> beanList) {
        this.beanList = beanList;
    }

    public class CommentBean {
        private String tip;
        private String comment;

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
