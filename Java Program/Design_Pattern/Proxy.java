package Design_Pattern;

public class Proxy {
    public static void main(String[] args) {
        Client client = new Client("Admin");
        client.connect("google.com");
    }
}

class Client {
    private String client = null;
    private String website = null;
    private ProxyServer proxyServer = ProxyServer.INSTANCE;

    public Client(String client) {
        this.client = client;
    }

    public void connect(String website) {
        this.website = website;
        proxyServer.connect(this.client, this.website);
    }
}

interface Gateway {
    public void connect(String client, String website);
}

enum ProxyServer implements Gateway {
    INSTANCE;

    private Server server = Server.INSTANCE;

    public void connect(String client, String website) {
        if (client.equals("Admin")) {
            server.connect(client, website);
            return;
        }
        System.out.println("Not Connected");
    }
}

enum Server implements Gateway {
    INSTANCE;

    public void connect(String client, String website) {
        System.out.println(client + " connected to " + website);
    }
}
