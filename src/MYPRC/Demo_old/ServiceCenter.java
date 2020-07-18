package MYPRC.Demo_old;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceCenter implements Server{
    private static final HashMap<String,Class>serviceRegistry =new HashMap<>();
    private static ExecutorService executor= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static boolean isRuning=false;
    private static int port;


    public ServiceCenter(int port){
        this.port=port;
    }

    public void stop() {
        isRuning=false;
        executor.shutdown();
    }


    public void start() throws IOException {
        ServerSocket serverSocket=new ServerSocket(port);
        System.out.println("start server");
        try {
            while (true){
                Socket socket=serverSocket.accept();
                executor.execute(new ServiceTask(socket));
            }
        }finally {
            serverSocket.close();
        }
    }


    public void register(Class serviceInterface, Class impl) {
        serviceRegistry.put(serviceInterface.getName(),impl);

    }


    public boolean isRuning() {
        return isRuning;
    }


    public int getPort() {
        return port;
    }
    private static class ServiceTask implements Runnable {
        Socket clent = null;

        public ServiceTask(Socket client) {
            this.clent = client;
        }

        public void run() {
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                // 2.将客户端发送的码流反序列化成对象，反射调用服务实现者，获取执行结果
                input = new ObjectInputStream(clent.getInputStream());
                String serviceName = input.readUTF();
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] arguments = (Object[]) input.readObject();
                Class serviceClass = serviceRegistry.get(serviceName);
                if (serviceClass == null) {
                    throw new ClassNotFoundException(serviceName + " not found");
                }
                Method method = serviceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguments);

                // 3.将执行结果反序列化，通过socket发送给客户端
                output = new ObjectOutputStream(clent.getOutputStream());
                output.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (clent != null) {
                    try {
                        clent.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
