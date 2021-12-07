package com.example.apublic.bean.lottery;

import java.util.List;

public class LotteryHistoryBean {

    /**
     * reason : 查询成功
     * result : {"lotteryResList":[{"lottery_id":"ssq","lottery_res":"03,08,11,14,18,23,16","lottery_no":"18028","lottery_date":"2018-03-13","lottery_exdate":"2018-05-11","lottery_sale_amount":"352,015,830","lottery_pool_amount":"578,094,167"},{"lottery_id":"ssq","lottery_res":"02,07,09,14,18,28,05","lottery_no":"18027","lottery_date":"2018-03-11","lottery_exdate":"2018-05-09","lottery_sale_amount":"386,579,026","lottery_pool_amount":"561,561,972"},{"lottery_id":"ssq","lottery_res":"04,07,12,14,26,32,04","lottery_no":"18026","lottery_date":"2018-03-08","lottery_exdate":"2018-05-06","lottery_sale_amount":"341,958,742","lottery_pool_amount":"537,930,372"},{"lottery_id":"ssq","lottery_res":"04,13,16,19,21,25,14","lottery_no":"18025","lottery_date":"2018-03-06","lottery_exdate":"2018-05-04","lottery_sale_amount":"341,614,936","lottery_pool_amount":"513,258,146"},{"lottery_id":"ssq","lottery_res":"11,19,22,26,31,32,02","lottery_no":"18024","lottery_date":"2018-03-04","lottery_exdate":"2018-05-02","lottery_sale_amount":"373,443,496","lottery_pool_amount":"436,102,047"}],"page":1,"pageSize":5,"totalPage":447}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * lotteryResList : [{"lottery_id":"ssq","lottery_res":"03,08,11,14,18,23,16","lottery_no":"18028","lottery_date":"2018-03-13","lottery_exdate":"2018-05-11","lottery_sale_amount":"352,015,830","lottery_pool_amount":"578,094,167"},{"lottery_id":"ssq","lottery_res":"02,07,09,14,18,28,05","lottery_no":"18027","lottery_date":"2018-03-11","lottery_exdate":"2018-05-09","lottery_sale_amount":"386,579,026","lottery_pool_amount":"561,561,972"},{"lottery_id":"ssq","lottery_res":"04,07,12,14,26,32,04","lottery_no":"18026","lottery_date":"2018-03-08","lottery_exdate":"2018-05-06","lottery_sale_amount":"341,958,742","lottery_pool_amount":"537,930,372"},{"lottery_id":"ssq","lottery_res":"04,13,16,19,21,25,14","lottery_no":"18025","lottery_date":"2018-03-06","lottery_exdate":"2018-05-04","lottery_sale_amount":"341,614,936","lottery_pool_amount":"513,258,146"},{"lottery_id":"ssq","lottery_res":"11,19,22,26,31,32,02","lottery_no":"18024","lottery_date":"2018-03-04","lottery_exdate":"2018-05-02","lottery_sale_amount":"373,443,496","lottery_pool_amount":"436,102,047"}]
         * page : 1
         * pageSize : 5
         * totalPage : 447
         */

        private int page;
        private int pageSize;
        private int totalPage;
        private List<LotteryResListBean> lotteryResList;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<LotteryResListBean> getLotteryResList() {
            return lotteryResList;
        }

        public void setLotteryResList(List<LotteryResListBean> lotteryResList) {
            this.lotteryResList = lotteryResList;
        }

        public static class LotteryResListBean {
            /**
             * lottery_id : ssq
             * lottery_res : 03,08,11,14,18,23,16
             * lottery_no : 18028
             * lottery_date : 2018-03-13
             * lottery_exdate : 2018-05-11
             * lottery_sale_amount : 352,015,830
             * lottery_pool_amount : 578,094,167
             */

            private String lottery_id;
            private String lottery_res;
            private String lottery_no;
            private String lottery_date;
            private String lottery_exdate;
            private String lottery_sale_amount;
            private String lottery_pool_amount;

            public String getLottery_id() {
                return lottery_id;
            }

            public void setLottery_id(String lottery_id) {
                this.lottery_id = lottery_id;
            }

            public String getLottery_res() {
                return lottery_res;
            }

            public void setLottery_res(String lottery_res) {
                this.lottery_res = lottery_res;
            }

            public String getLottery_no() {
                return lottery_no;
            }

            public void setLottery_no(String lottery_no) {
                this.lottery_no = lottery_no;
            }

            public String getLottery_date() {
                return lottery_date;
            }

            public void setLottery_date(String lottery_date) {
                this.lottery_date = lottery_date;
            }

            public String getLottery_exdate() {
                return lottery_exdate;
            }

            public void setLottery_exdate(String lottery_exdate) {
                this.lottery_exdate = lottery_exdate;
            }

            public String getLottery_sale_amount() {
                return lottery_sale_amount;
            }

            public void setLottery_sale_amount(String lottery_sale_amount) {
                this.lottery_sale_amount = lottery_sale_amount;
            }

            public String getLottery_pool_amount() {
                return lottery_pool_amount;
            }

            public void setLottery_pool_amount(String lottery_pool_amount) {
                this.lottery_pool_amount = lottery_pool_amount;
            }
        }
    }
}
