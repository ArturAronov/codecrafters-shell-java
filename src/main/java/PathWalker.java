import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;

public class PathWalker {
    private final String[] paths;

    public PathWalker() {
        this.paths = System.getenv("PATH").split(File.pathSeparator);
    }

    public String getAvailablePath(String dir) {
        for(String path: paths) {
            Path fullPath = Path.of(path, dir);

            if(Files.isRegularFile(fullPath)){
                return fullPath.toString();
            }
        }

        return null;
    }
}
