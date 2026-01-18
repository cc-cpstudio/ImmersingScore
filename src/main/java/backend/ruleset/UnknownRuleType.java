package backend.ruleset;

public class UnknownRuleType extends RuntimeException {
    public UnknownRuleType() {
        super("未知的规则类型");
    }
}
