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

public class ChocolateyInstaller {

    public static void init() {
        try {
            if (!isChocolateyInstalled()) {
                installChocolatey();
            } else {
                Print.line("Chocolatey is already installed.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isChocolateyInstalled() throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("choco -v");
        process.waitFor();
        return process.exitValue() == 0;
    }

    public static void installChocolatey() throws IOException, InterruptedException {
        String command = "powershell -NoProfile -ExecutionPolicy Bypass -Command \"iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))\"";
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            Print.newLine(line);
        }

        process.waitFor();
        Print.line("Chocolatey installation completed.");
    }
}

