package com.example.apublic.bean;

public class LifeIndexBean extends BaseJHBean{
    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean{
        private String city;
        private LifeBean life;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public static class LifeBean{
            private Kongtiao kongtiao;
            public static class Kongtiao{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Guomin guomin;
            public static class Guomin{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Shushidu shushidu;
            public static class Shushidu{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Chuanyi chuanyi;
            public static class Chuanyi{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Diaoyu diaoyu;
            public static class Diaoyu{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Ganmao ganmao;
            public static class Ganmao{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Ziwaixian ziwaixian;
            public static class Ziwaixian{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Xiche xiche;
            public static class Xiche{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Yundong yundong;
            public static class Yundong{
                private String v;
                private String des;
                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
            private Daisan daisan;
            public static class Daisan{
                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public Kongtiao getKongtiao() {
                return kongtiao;
            }

            public void setKongtiao(Kongtiao kongtiao) {
                this.kongtiao = kongtiao;
            }

            public Guomin getGuomin() {
                return guomin;
            }

            public void setGuomin(Guomin guomin) {
                this.guomin = guomin;
            }

            public Shushidu getShushidu() {
                return shushidu;
            }

            public void setShushidu(Shushidu shushidu) {
                this.shushidu = shushidu;
            }

            public Chuanyi getChuanyi() {
                return chuanyi;
            }

            public void setChuanyi(Chuanyi chuanyi) {
                this.chuanyi = chuanyi;
            }

            public Diaoyu getDiaoyu() {
                return diaoyu;
            }

            public void setDiaoyu(Diaoyu diaoyu) {
                this.diaoyu = diaoyu;
            }

            public Ganmao getGanmao() {
                return ganmao;
            }

            public void setGanmao(Ganmao ganmao) {
                this.ganmao = ganmao;
            }

            public Ziwaixian getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(Ziwaixian ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public Xiche getXiche() {
                return xiche;
            }

            public void setXiche(Xiche xiche) {
                this.xiche = xiche;
            }

            public Yundong getYundong() {
                return yundong;
            }

            public void setYundong(Yundong yundong) {
                this.yundong = yundong;
            }

            public Daisan getDaisan() {
                return daisan;
            }

            public void setDaisan(Daisan daisan) {
                this.daisan = daisan;
            }
        }
    }
}
