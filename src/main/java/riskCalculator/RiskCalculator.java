package riskCalculator;

public class RiskCalculator {
    public String calculate(int impact, int likelihood) throws IllegalArgumentException {
        if (impact < 0 || impact > 4 || likelihood < 0 || likelihood > 4)
            throw new IllegalArgumentException();
        int riskInt = impact * impact + likelihood * likelihood;
        String riskStr;
        if (riskInt > 18) {
            riskStr = "high";
        } else if (riskInt > 8) {
            riskStr = "medium";
        } else if (riskInt > 0) {
            riskStr = "small";
        } else {
            riskStr = "zero";
        }
        return riskStr;
    }
}
