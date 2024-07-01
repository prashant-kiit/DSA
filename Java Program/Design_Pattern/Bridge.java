package Design_Pattern;

public class Bridge {
    public static void main(String[] args) {
        Player player = new Netflix("Dhoom", new HD());
        player.play();
    }
}

abstract class Player {
    protected String movie = null;
    protected Processor processor = null;

    public abstract void play();
}

class Youtube extends Player {
    public Youtube(String movie, Processor processor) {
        this.movie = movie;
        this.processor = processor;
    }

    @Override
    public void play() {
        this.processor.process("Youtube", this.movie);
    }
}

class Netflix extends Player {
    public Netflix(String movie, Processor processor) {
        this.movie = movie;
        this.processor = processor;
    }

    @Override
    public void play() {
        this.processor.process("Netflix", this.movie);
    }
}

class Hotstar extends Player {
    public Hotstar(String movie, Processor processor) {
        this.movie = movie;
        this.processor = processor;
    }

    @Override
    public void play() {
        this.processor.process("Hotstar", this.movie);
    }
}

abstract class Processor {
    public abstract void process(String platform, String movie);
}

class HD extends Processor {
    @Override
    public void process(String platform, String movie) {
        System.out.println("Movie " + movie + " processed into HD movie");
        System.out.println(platform + " is playing movie " + movie);
    }
}

class _4K extends Processor {
    @Override
    public void process(String platform, String movie) {
        System.out.println("Movie " + movie + " processed into 4K movie");
        System.out.println(platform + " is playing movie " + movie);
    }
}