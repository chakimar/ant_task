package name.chakimar.anttask;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public abstract class AbstractPaddingTask extends Task {
    private String str;
    private int size;
    private String padStr;
    private String property; 

    @Override
    public void execute() throws BuildException {
        if (str == null) throw new BuildException("str must not be null.");
        if (size <= 0) throw new BuildException("str must over 0.");
        if (padStr == null) throw new BuildException("padStr must not be null.");
        if (property == null) throw new BuildException("property must not be null.");

        getProject().setProperty(property, pad(str,size,padStr));
    }

    public void setStr(String str) {
        this.str = str;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setPadStr(String padStr) {
        this.padStr = padStr;
    }
    public void setProperty(String property) {
        this.property = property;
    }

    public abstract String pad(String str, int size, String padStr);
}
