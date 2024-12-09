import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    public String runExecutable(String command) {
        try {
            String executablePath = getAvailablePath(command);
            if(executablePath == null) {
                return null;
            }

            Process process = new ProcessBuilder(executablePath).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println(reader.readLine());
            StringBuilder output = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null) {
                output.append(line);
            }

            process.waitFor();
            return output.toString().trim();
        } catch(Exception e) {
            return null;
        }
    }
}
