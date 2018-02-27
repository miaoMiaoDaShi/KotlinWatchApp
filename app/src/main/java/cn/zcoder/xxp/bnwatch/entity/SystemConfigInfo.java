package cn.zcoder.xxp.bnwatch.entity;

import cn.zcoder.xxp.base.net.BaseResponse;

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/13
 * Description :
 */


public class SystemConfigInfo extends BaseResponse {

    /**
     * data : {"config":{"company":"广州源佳电子科技有限公司","contact":"400-2938-9980","copyright":"Copyright (C) 2015-2016 源佳电子科技有限公司 版权所有","deposit":"5000","fc_agent":"","fc_shop":"12343","index_background":"http://otvt0lhkm.bkt.clouddn.com/2017/08/01/18/04/04/01.png","login_background":"http://otvt0lhkm.bkt.clouddn.com/2017/08/01/18/18/29/001.png","logo":"http://ou1a5f1xx.bkt.clouddn.com/256_256.png","project":"源佳充电宝"},"version":{"isBug":1,"isForce":0,"version":"1.0.1"}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * config : {"company":"广州源佳电子科技有限公司","contact":"400-2938-9980","copyright":"Copyright (C) 2015-2016 源佳电子科技有限公司 版权所有","deposit":"5000","fc_agent":"","fc_shop":"12343","index_background":"http://otvt0lhkm.bkt.clouddn.com/2017/08/01/18/04/04/01.png","login_background":"http://otvt0lhkm.bkt.clouddn.com/2017/08/01/18/18/29/001.png","logo":"http://ou1a5f1xx.bkt.clouddn.com/256_256.png","project":"源佳充电宝"}
         * version : {"isBug":1,"isForce":0,"version":"1.0.1"}
         */

        private ConfigBean config;
        private VersionBean version;

        public ConfigBean getConfig() {
            return config;
        }

        public void setConfig(ConfigBean config) {
            this.config = config;
        }

        public VersionBean getVersion() {
            return version;
        }

        public void setVersion(VersionBean version) {
            this.version = version;
        }

        public static class ConfigBean {
            /**
             * company : 广州源佳电子科技有限公司
             * contact : 400-2938-9980
             * copyright : Copyright (C) 2015-2016 源佳电子科技有限公司 版权所有
             * deposit : 5000
             * fc_agent :
             * fc_shop : 12343
             * index_background : http://otvt0lhkm.bkt.clouddn.com/2017/08/01/18/04/04/01.png
             * login_background : http://otvt0lhkm.bkt.clouddn.com/2017/08/01/18/18/29/001.png
             * logo : http://ou1a5f1xx.bkt.clouddn.com/256_256.png
             * project : 源佳充电宝
             */

            private String company;
            private String contact;
            private String copyright;
            private String deposit;

            @Override
            public String toString() {
                return "ConfigBean{" +
                        "company='" + company + '\'' +
                        ", contact='" + contact + '\'' +
                        ", copyright='" + copyright + '\'' +
                        ", deposit='" + deposit + '\'' +
                        ", fc_agent='" + fc_agent + '\'' +
                        ", fc_shop='" + fc_shop + '\'' +
                        ", index_background='" + index_background + '\'' +
                        ", login_background='" + login_background + '\'' +
                        ", logo='" + logo + '\'' +
                        ", project='" + project + '\'' +
                        '}';
            }

            private String fc_agent;
            private String fc_shop;
            private String index_background;
            private String login_background;
            private String logo;
            private String project;

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public String getDeposit() {
                return deposit;
            }

            public void setDeposit(String deposit) {
                this.deposit = deposit;
            }

            public String getFc_agent() {
                return fc_agent;
            }

            public void setFc_agent(String fc_agent) {
                this.fc_agent = fc_agent;
            }

            public String getFc_shop() {
                return fc_shop;
            }

            public void setFc_shop(String fc_shop) {
                this.fc_shop = fc_shop;
            }

            public String getIndex_background() {
                return index_background;
            }

            public void setIndex_background(String index_background) {
                this.index_background = index_background;
            }

            public String getLogin_background() {
                return login_background;
            }

            public void setLogin_background(String login_background) {
                this.login_background = login_background;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getProject() {
                return project;
            }

            public void setProject(String project) {
                this.project = project;
            }
        }

        public static class VersionBean {
            /**
             * isBug : 1
             * isForce : 0
             * version : 1.0.1
             */

            private int isBug;
            private int isForce;
            private String version;

            public int getIsBug() {
                return isBug;
            }

            public void setIsBug(int isBug) {
                this.isBug = isBug;
            }

            public int getIsForce() {
                return isForce;
            }

            public void setIsForce(int isForce) {
                this.isForce = isForce;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }
        }
    }
}
