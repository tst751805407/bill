package MYPRC.Demo_old;

import java.io.IOException;

public interface Server {
    public void stop();
    public void start()throws IOException;
    public void register(Class serviceInterface,Class impl);
    public boolean isRuning();
    public int getPort();
}
