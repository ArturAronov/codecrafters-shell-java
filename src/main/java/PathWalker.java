import java.util.Arrays;

public class PathWalker {
    public String returnPath;

    public String getAvailablePath(String[] paths, String dir) {
        for(String path: paths) {
            String[] dirs = path.split("/");
            Boolean hasDir = Arrays.stream(dirs).anyMatch(dir::equals);
            if(hasDir) {
                System.out.println(path);
                this.returnPath = path;
                break;
            }

            if(returnPath != null){
                break;
            }
        }

        return returnPath;
    }
}
