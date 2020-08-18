package com.example.dev4dw.bean.lottery;

import java.util.List;

public class LotteryBonusBean {


    /**
     * reason : 执行成功
     * result : {"lottery_id":"ssq","lottery_name":"双色球","lottery_no":"18029","lottery_date":"2018-03-15","real_lottery_res":"01,02,09,14,22,25,05","lottery_res":"01,11,02,09,14,22,25|05,03","in_money":"28","buy_red_ball_num":"7","buy_blue_ball_num":"2","hit_red_ball_num":"6","hit_blue_ball_num":"1","is_prize":"1","prize_msg":"恭喜您中奖了","lottery_prize":[{"prize_name":"一等奖","prize_require":"6+1","prize_num":"1","prize_money":"8,926,329"},{"prize_name":"二等奖","prize_require":"6+0","prize_num":"1","prize_money":"288,700"},{"prize_name":"三等奖","prize_require":"5+1","prize_num":"6","prize_money":"3,000"},{"prize_name":"四等奖","prize_require":"4+1,5+0","prize_num":"6","prize_money":"200"}]}
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
         * lottery_no : 18029
         * lottery_date : 2018-03-15
         * real_lottery_res : 01,02,09,14,22,25,05
         * lottery_res : 01,11,02,09,14,22,25|05,03
         * in_money : 28
         * buy_red_ball_num : 7
         * buy_blue_ball_num : 2
         * hit_red_ball_num : 6
         * hit_blue_ball_num : 1
         * is_prize : 1
         * prize_msg : 恭喜您中奖了
         * lottery_prize : [{"prize_name":"一等奖","prize_require":"6+1","prize_num":"1","prize_money":"8,926,329"},{"prize_name":"二等奖","prize_require":"6+0","prize_num":"1","prize_money":"288,700"},{"prize_name":"三等奖","prize_require":"5+1","prize_num":"6","prize_money":"3,000"},{"prize_name":"四等奖","prize_require":"4+1,5+0","prize_num":"6","prize_money":"200"}]
         */

        private String lottery_id;
        private String lottery_name;
        private String lottery_no;
        private String lottery_date;
        private String real_lottery_res;
        private String lottery_res;
        private String in_money;
        private String buy_red_ball_num;
        private String buy_blue_ball_num;
        private String hit_red_ball_num;
        private String hit_blue_ball_num;
        private String is_prize;
        private String prize_msg;
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

        public String getReal_lottery_res() {
            return real_lottery_res;
        }

        public void setReal_lottery_res(String real_lottery_res) {
            this.real_lottery_res = real_lottery_res;
        }

        public String getLottery_res() {
            return lottery_res;
        }

        public void setLottery_res(String lottery_res) {
            this.lottery_res = lottery_res;
        }

        public String getIn_money() {
            return in_money;
        }

        public void setIn_money(String in_money) {
            this.in_money = in_money;
        }

        public String getBuy_red_ball_num() {
            return buy_red_ball_num;
        }

        public void setBuy_red_ball_num(String buy_red_ball_num) {
            this.buy_red_ball_num = buy_red_ball_num;
        }

        public String getBuy_blue_ball_num() {
            return buy_blue_ball_num;
        }

        public void setBuy_blue_ball_num(String buy_blue_ball_num) {
            this.buy_blue_ball_num = buy_blue_ball_num;
        }

        public String getHit_red_ball_num() {
            return hit_red_ball_num;
        }

        public void setHit_red_ball_num(String hit_red_ball_num) {
            this.hit_red_ball_num = hit_red_ball_num;
        }

        public String getHit_blue_ball_num() {
            return hit_blue_ball_num;
        }

        public void setHit_blue_ball_num(String hit_blue_ball_num) {
            this.hit_blue_ball_num = hit_blue_ball_num;
        }

        public String getIs_prize() {
            return is_prize;
        }

        public void setIs_prize(String is_prize) {
            this.is_prize = is_prize;
        }

        public String getPrize_msg() {
            return prize_msg;
        }

        public void setPrize_msg(String prize_msg) {
            this.prize_msg = prize_msg;
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
             * prize_require : 6+1
             * prize_num : 1
             * prize_money : 8,926,329
             */

            private String prize_name;
            private String prize_require;
            private String prize_num;
            private String prize_money;

            public String getPrize_name() {
                return prize_name;
            }

            public void setPrize_name(String prize_name) {
                this.prize_name = prize_name;
            }

            public String getPrize_require() {
                return prize_require;
            }

            public void setPrize_require(String prize_require) {
                this.prize_require = prize_require;
            }

            public String getPrize_num() {
                return prize_num;
            }

            public void setPrize_num(String prize_num) {
                this.prize_num = prize_num;
            }

            public String getPrize_money() {
                return prize_money;
            }

            public void setPrize_money(String prize_money) {
                this.prize_money = prize_money;
            }
        }
    }
}
