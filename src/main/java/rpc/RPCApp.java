package rpc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import rpc.simple_rpc.RequestPojo;

public class RPCApp {

    public static void main(String[] args) {

        RequestPojo requestPojo=new RequestPojo();

        requestPojo.setParameterTypes(new Class[]{String.class});

        String string=JSONObject.toJSONString(requestPojo);

        System.out.println(string);

    }
}
