/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;
import app.Print;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author yanni
 */
public class PhpInstaller {
    public static void init() {
        try {
            if (!isPHPInstalled()) {
                installPHP();
            } else {
                Print.line("PHP is already installed.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPHPInstalled() throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("php -v");
        process.waitFor();
        return process.exitValue() == 0;
    }

    public static void installPHP() throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        Process process;

        if (os.contains("win")) {
            // Windows installation command (example using Chocolatey)
            ChocolateyInstaller.init();
            process = Runtime.getRuntime().exec("choco install php");
        } else if (os.contains("mac")) {
            // macOS installation command (example using Homebrew)
            process = Runtime.getRuntime().exec("brew install php");
        } else {
            // Linux installation command (example using apt-get)
            process = Runtime.getRuntime().exec("sudo apt-get install php");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            Print.newLine(line);
        }

        process.waitFor();
        Print.line("PHP installation completed.");
    }
}
