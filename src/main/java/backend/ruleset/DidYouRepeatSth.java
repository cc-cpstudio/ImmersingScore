package backend.ruleset;

public class DidYouRepeatSth extends RuntimeException {
    public DidYouRepeatSth() {
        super("你是否重新设置了了某些规则？");
    }
}
