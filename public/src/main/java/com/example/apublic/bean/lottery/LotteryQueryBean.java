package com.example.apublic.bean.lottery;

import java.util.List;

public class LotteryQueryBean {

    /**
     * reason : 查询成功
     * result : {"lottery_id":"ssq","lottery_name":"双色球","lottery_res":"03,08,11,14,18,23,16","lottery_no":"18028","lottery_date":"2018-03-13","lottery_exdate":"2018-05-11","lottery_sale_amount":"352,015,830","lottery_pool_amount":"578,094,167","lottery_prize":[{"prize_name":"一等奖","prize_num":"7","prize_amount":"7,676,997","prize_require":"6+1"},{"prize_name":"二等奖","prize_num":"220","prize_amount":"106,471","prize_require":"6+0"},{"prize_name":"三等奖","prize_num":"1869","prize_amount":"3,000","prize_require":"5+1"},{"prize_name":"四等奖","prize_num":"82708","prize_amount":"200","prize_require":"5+0,4+1"},{"prize_name":"五等奖","prize_num":"1493643","prize_amount":"10","prize_require":"4+0,3+1"},{"prize_name":"六等奖","prize_num":"8341565","prize_amount":"5","prize_require":"2+1,1+1,0+1"}]}
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
         * lottery_id : ssq
         * lottery_name : 双色球
         * lottery_res : 03,08,11,14,18,23,16
         * lottery_no : 18028
         * lottery_date : 2018-03-13
         * lottery_exdate : 2018-05-11
         * lottery_sale_amount : 352,015,830
         * lottery_pool_amount : 578,094,167
         * lottery_prize : [{"prize_name":"一等奖","prize_num":"7","prize_amount":"7,676,997","prize_require":"6+1"},{"prize_name":"二等奖","prize_num":"220","prize_amount":"106,471","prize_require":"6+0"},{"prize_name":"三等奖","prize_num":"1869","prize_amount":"3,000","prize_require":"5+1"},{"prize_name":"四等奖","prize_num":"82708","prize_amount":"200","prize_require":"5+0,4+1"},{"prize_name":"五等奖","prize_num":"1493643","prize_amount":"10","prize_require":"4+0,3+1"},{"prize_name":"六等奖","prize_num":"8341565","prize_amount":"5","prize_require":"2+1,1+1,0+1"}]
         */

        private String lottery_id;
        private String lottery_name;
        private String lottery_res;
        private String lottery_no;
        private String lottery_date;
        private String lottery_exdate;
        private String lottery_sale_amount;
        private String lottery_pool_amount;
        private List<LotteryPrizeBean> lottery_prize;

        public String getLottery_id() {
            return lottery_id;
        }

        public void setLottery_id(String lottery_id) {
            this.lottery_id = lottery_id;
        }

        public String getLottery_name() {
            return lottery_name;
        }

        public void setLottery_name(String lottery_name) {
            this.lottery_name = lottery_name;
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

        public List<LotteryPrizeBean> getLottery_prize() {
            return lottery_prize;
        }

        public void setLottery_prize(List<LotteryPrizeBean> lottery_prize) {
            this.lottery_prize = lottery_prize;
        }

        public static class LotteryPrizeBean {
            /**
             * prize_name : 一等奖
             * prize_num : 7
             * prize_amount : 7,676,997
             * prize_require : 6+1
             */

            private String prize_name;
            private String prize_num;
            private String prize_amount;
            private String prize_require;

            public String getPrize_name() {
                return prize_name;
            }

            public void setPrize_name(String prize_name) {
                this.prize_name = prize_name;
            }

            public String getPrize_num() {
                return prize_num;
            }

            public void setPrize_num(String prize_num) {
                this.prize_num = prize_num;
            }

            public String getPrize_amount() {
                return prize_amount;
            }

            public void setPrize_amount(String prize_amount) {
                this.prize_amount = prize_amount;
            }

            public String getPrize_require() {
                return prize_require;
            }

            public void setPrize_require(String prize_require) {
                this.prize_require = prize_require;
            }
        }
    }
}
