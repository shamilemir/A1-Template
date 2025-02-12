package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathFactorizer {

    private StringBuilder factorizedPath;

    public PathFactorizer(StringBuilder factorizedPath) {
        this.factorizedPath = factorizedPath;
    }

    public String factorize(String path) {

        int freq = 0;
        for (int i = 0; i < path.length(); i++) {
            if (i == path.length() - 1) {
                freq++;
                factorizeAppend(freq, path.charAt(i));
            }
            else if (path.charAt(i) == ' ') {
                factorizeAppend(freq, path.charAt(i-1));
                freq = 0;
            }
            else {
                freq++;
            }
        }

        return factorizedPath.toString();

    }

    public void factorizeAppend(int freq, char c) {
        if (freq == 1) {
            factorizedPath.append(c).append(" ");
        }
        else {
            factorizedPath.append(freq).append(c).append(" ");
        }
    }

}