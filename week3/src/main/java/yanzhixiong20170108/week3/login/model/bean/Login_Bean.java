package yanzhixiong20170108.week3.login.model.bean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class Login_Bean {

    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":"8157cea74c894b5c","appsecret":"3E075303BFAD6E7521E278B90A455FBF","createtime":"2018-01-13T08:59:31","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","latitude":null,"longitude":null,"mobile":"17301393946","money":null,"nickname":"哈哈哈","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"57C40FDDB9D537A09B46FD83BC088ACC","uid":1600,"userId":null,"username":"17301393946"}
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
         * age : null
         * appkey : 8157cea74c894b5c
         * appsecret : 3E075303BFAD6E7521E278B90A455FBF
         * createtime : 2018-01-13T08:59:31
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg
         * latitude : null
         * longitude : null
         * mobile : 17301393946
         * money : null
         * nickname : 哈哈哈
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * praiseNum : null
         * token : 57C40FDDB9D537A09B46FD83BC088ACC
         * uid : 1600
         * userId : null
         * username : 17301393946
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private String icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
