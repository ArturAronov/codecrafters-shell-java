import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class PathWalker {
    private final String[] paths;

    public PathWalker() {
        this.paths = System.getenv("PATH").split(File.pathSeparator);
    }

    public String getAvailablePath(String dir) {
        for(String path: paths) {
            Path fullPath = Path.of(path, dir);
//            System.out.println(path + " -> " + fullPath + " -> " + Files.isRegularFile(fullPath));

            if(Files.isRegularFile(fullPath)){
                return fullPath.toString();
            }
        }

        return null;
    }
}
