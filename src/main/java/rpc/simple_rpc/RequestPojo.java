package rpc.simple_rpc;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestPojo implements Serializable {


    private String serviceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] parameterTypes;

}
