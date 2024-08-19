import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Windows {
    private static WSL wsl;

    public static void main(String[] args) throws IOException {
        System.out.println("Windows Starting");
        while (true) {
            String input = new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
            if (input.equals("w")) {
                wsl = new WSL(); // Download, Install, Activate WSL
                System.out.println(wsl.hashCode());
            }

            if (input.equals("i")) {
                System.out.println(wsl.hashCode());
                Linux linux = new Ubuntu();
                wsl.install(linux); // WSL Install Ubuntu
            }

            if (input.equals("s")) {
                wsl.start(); // WSL Launched Ubuntu
            }

            if (input.equals("e")) {
                wsl.end(); // WSL Terminates Ubuntu
            }
        }
    }
}

class WSL {
    private Linux linux;

    public void install(Linux linux) {
        // download linux file
        // install linux file
        this.linux = linux;
        System.out.println(this.linux);
        System.out.println("Installed");
    }

    public void end() {
        linux.end();
    }

    public void start() {
        linux.start();
    }
}

interface Linux {
    void start();

    void end();
}

class Ubuntu implements Linux {
    private List<Object> fileStorage = new ArrayList<>();

    @Override
    public void start() {
        System.out.println("Ubuntu Starting");
    }

    @Override
    public void end() {
        System.out.println("Ubuntu Ending");
    }
}
