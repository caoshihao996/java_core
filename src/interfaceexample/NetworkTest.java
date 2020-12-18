package interfaceexample;

public class NetworkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface Network{

    public void browse();
}

class Server implements Network{
    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}

class ProxyServer implements Network{

    private Network work;

    public ProxyServer(Network work){
        this.work=work;
    }
    public void check(){
        System.out.println("联网之前的检查工作");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}
