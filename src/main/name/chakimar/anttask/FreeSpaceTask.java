package name.chakimar.anttask;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.commons.io.FileSystemUtils;
import java.io.IOException;

public class FreeSpaceTask extends Task {
    private String path;
    private long requireFreeSpaceKb;
    private String property;

    @Override
    public void execute() throws BuildException {
        if (path == null) throw new BuildException("path must not be null.");
        if (requireFreeSpaceKb <= 0) throw new BuildException("requireFreeSpaceKb must over 0.");
        if (property == null) throw new BuildException("property must not be null.");

        long freeSpaceKb;
        try {
            freeSpaceKb = FileSystemUtils.freeSpaceKb(path);
        } catch (IOException e) {
            throw new BuildException(e);
        }
        if (freeSpaceKb >= requireFreeSpaceKb) {
            getProject().setProperty(property, "true");
        }
    }

    public void setPath(String path) {
        this.path = path;
    }
    public void setRequireFreeSpaceKb(long requireFreeSpaceKb) {
        this.requireFreeSpaceKb = requireFreeSpaceKb;
    }
    public void setProperty(String property) {
        this.property = property;
    }
}
