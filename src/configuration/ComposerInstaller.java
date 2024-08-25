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

public class ComposerInstaller {

    public static void init() {
        try {
            if (!isComposerInstalled()) {
                installComposer();
            } else {
                Print.line("Composer is already installed.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isComposerInstalled() throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("composer -v");
        process.waitFor();
        return process.exitValue() == 0;
    }

    public static void installComposer() throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        Process process;

        if (os.contains("win")) {
            // Windows installation command
            process = Runtime.getRuntime().exec("powershell -NoProfile -ExecutionPolicy Bypass -Command \"[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; iex ((New-Object System.Net.WebClient).DownloadString('https://getcomposer.org/installer'))\"");
        } else if (os.contains("mac") || os.contains("nix") || os.contains("nux")) {
            // macOS and Linux installation command
            process = Runtime.getRuntime().exec("curl -sS https://getcomposer.org/installer | php && sudo mv composer.phar /usr/local/bin/composer");
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + os);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            Print.newLine(line);
        }

        process.waitFor();
        Print.line("Composer installation completed.");
    }
}

