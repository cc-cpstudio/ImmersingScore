package backend.synchronizer;

public class ThisHasInitialized extends RuntimeException {
    public ThisHasInitialized() {
        super("这个类已经被初始化过了");
    }
}
