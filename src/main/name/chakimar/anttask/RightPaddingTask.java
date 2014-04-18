package name.chakimar.anttask;

import name.chakimar.anttask.AbstractPaddingTask;
import org.apache.commons.lang.StringUtils;

public class RightPaddingTask extends AbstractPaddingTask {
    public String pad(String str, int size, String padStr) {
        return StringUtils.rightPad(str, size, padStr);
    }
}
