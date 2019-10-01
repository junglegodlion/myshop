package com.funtl.hello.httpclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonTester {
    public static void main(String[] args) {
//        testPojoJson();
      /*  ObjectMapper objectMapper = new ObjectMapper();
        //JSON转Java对线
        String json = "{\"draw\":1,\"recordsTotal\":19,\"recordsFiltered\":19,\"data\":[{\"id\":9,\"created\":1428373928000,\"updated\":1553215335000,\"username\":\"zhangsan1\",\"phone\":\"13333333333\",\"email\":\"test@test.com\"},{\"id\":10,\"created\":1428374017000,\"updated\":1428374017000,\"username\":\"zhangsan2\",\"phone\":\"13333333334\",\"email\":null},{\"id\":11,\"created\":1428374157000,\"updated\":1428374157000,\"username\":\"zhangsan3\",\"phone\":\"13333333335\",\"email\":null},{\"id\":12,\"created\":1428374779000,\"updated\":1428374779000,\"username\":\"zhangsan5\",\"phone\":\"13333333336\",\"email\":null},{\"id\":14,\"created\":1434679331000,\"updated\":1434679331000,\"username\":\"lisi\",\"phone\":\"12344444444\",\"email\":null},{\"id\":16,\"created\":1434680667000,\"updated\":1434680667000,\"username\":\"lisi1\",\"phone\":\"12344444442\",\"email\":null},{\"id\":17,\"created\":1434680746000,\"updated\":1434680746000,\"username\":\"jd_gogogo\",\"phone\":\"18800888888\",\"email\":null},{\"id\":18,\"created\":1438248385000,\"updated\":1438248385000,\"username\":\"tidy\",\"phone\":\"13600112243\",\"email\":null},{\"id\":22,\"created\":1438249713000,\"updated\":1438249713000,\"username\":\"tidy1\",\"phone\":\"13600112244\",\"email\":null},{\"id\":23,\"created\":1438400922000,\"updated\":1438400922000,\"username\":\"niuniu\",\"phone\":\"15866777744\",\"email\":\"\"}],\"error\":null}";
        try {
            User user = objectMapper.readValue(json, User.class);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }*/



        ObjectMapper objectMapper = new ObjectMapper();
        //JSON转Java对线
        String json = "{\"draw\":1,\"recordsTotal\":19,\"recordsFiltered\":19,\"data\":[{\"id\":9,\"created\":1428373928000,\"updated\":1553215335000,\"username\":\"zhangsan1\",\"phone\":\"13333333333\",\"email\":\"test@test.com\"},{\"id\":10,\"created\":1428374017000,\"updated\":1428374017000,\"username\":\"zhangsan2\",\"phone\":\"13333333334\",\"email\":null},{\"id\":11,\"created\":1428374157000,\"updated\":1428374157000,\"username\":\"zhangsan3\",\"phone\":\"13333333335\",\"email\":null},{\"id\":12,\"created\":1428374779000,\"updated\":1428374779000,\"username\":\"zhangsan5\",\"phone\":\"13333333336\",\"email\":null},{\"id\":14,\"created\":1434679331000,\"updated\":1434679331000,\"username\":\"lisi\",\"phone\":\"12344444444\",\"email\":null},{\"id\":16,\"created\":1434680667000,\"updated\":1434680667000,\"username\":\"lisi1\",\"phone\":\"12344444442\",\"email\":null},{\"id\":17,\"created\":1434680746000,\"updated\":1434680746000,\"username\":\"jd_gogogo\",\"phone\":\"18800888888\",\"email\":null},{\"id\":18,\"created\":1438248385000,\"updated\":1438248385000,\"username\":\"tidy\",\"phone\":\"13600112243\",\"email\":null},{\"id\":22,\"created\":1438249713000,\"updated\":1438249713000,\"username\":\"tidy1\",\"phone\":\"13600112244\",\"email\":null},{\"id\":23,\"created\":1438400922000,\"updated\":1438400922000,\"username\":\"niuniu\",\"phone\":\"15866777744\",\"email\":\"\"}],\"error\":null}";

        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode data = jsonNode.findPath("data");
            System.out.println(data);
//            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class,TbUser.class);
//            List<TbUser> tbUsers=objectMapper.readValue(data.toString(),javaType);
            List<TbUser> tbUsers=objectMapper.readValue(data.toString(), new TypeReference<List<TbUser>>() {});

            for (TbUser tbUser : tbUsers) {
                System.out.println(tbUser);

            }
            System.out.println(objectMapper.writeValueAsString(tbUsers));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void testPojoJson(){
        // 创建 ObjectMapper 对象
        ObjectMapper objectMapper = new ObjectMapper();
        //JSON转Java对线
        String json = "{\"draw\": 1,\"recordsTotal\": 19,\"recordsFiltered\": 19,\"error\": null}";
        try {
            User user = objectMapper.readValue(json, User.class);
            System.out.println(user);
            System.out.println(objectMapper.writeValueAsString(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class User{
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<TbUser> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<TbUser> getData() {
        return data;
    }

    public void setData(List<TbUser> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "User{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
class TbUser{
    private Long id;
    private Date created;
    private Date updated;
    private String username;
    private String phone;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}