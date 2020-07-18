package MYPRC;
//客户端获取代理对象。


import java.lang.reflect.Proxy;

/**
 * 客户端代理
 * @author Dongguabai
 * @date 2018/11/1 16:18
 */
public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> interfaceClass,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class[]{interfaceClass},new RemoteInvocationHandler(host, port));
    }
}

