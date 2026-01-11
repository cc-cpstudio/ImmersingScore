package backend.ruleset;

public class IncorrectScore extends RuntimeException {
    public IncorrectScore() {
        super("不正确的积分数值：必须是正数");
    }
}
