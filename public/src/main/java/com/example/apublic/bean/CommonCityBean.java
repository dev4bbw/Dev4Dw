package com.example.apublic.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

public class CommonCityBean implements Serializable {

    /**
     * "provinceName":"广东","city":[{"cityName":"广州","district":["天河","花都"]}]
     */
    private String provinceName;
    private List<CityBean> city;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<CityBean> getCity() {
        return city;
    }

    public void setCity(List<CityBean> city) {
        this.city = city;
    }

    public static class CityBean implements Serializable {
        private String cityName;
        private List<DistrictBean> district;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public List<DistrictBean> getDistrict() {
            return district;
        }

        public void setDistrict(List<DistrictBean> district) {
            this.district = district;
        }

        public static class DistrictBean implements Serializable {
            String districtName;

            public String getDistrictName() {
                return districtName;
            }

            public void setDistrictName(String districtName) {
                this.districtName = districtName;
            }
        }
    }
}
