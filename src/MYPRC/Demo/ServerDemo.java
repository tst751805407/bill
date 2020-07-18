package MYPRC.Demo;

import MYPRC.RpcServer;

/**
 * @author Dongguabai
 * @date 2018/11/1 18:07
 */
public class ServerDemo {

    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        rpcServer.publisher(new HelloServiceImpl(),12345);
    }
}

