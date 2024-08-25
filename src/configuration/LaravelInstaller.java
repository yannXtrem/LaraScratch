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

public class LaravelInstaller {

    public static void init(String projectName, String projectPath) {
        try {
            if (!isLaravelInstalled(projectPath)) {
                installLaravel(projectName, projectPath);
            } else {
                Print.line("Laravel is already installed.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isLaravelInstalled(String projectPath) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("composer show laravel/laravel -d " + projectPath);
        process.waitFor();
        return process.exitValue() == 0;
    }

    public static void installLaravel(String projectName, String projectPath) throws IOException, InterruptedException {
        String command = "composer create-project --prefer-dist laravel/laravel " + projectName;
        Process process = Runtime.getRuntime().exec(command, null, new java.io.File(projectPath));

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            Print.newLine(line);
        }

        process.waitFor();
        Print.line("Laravel installation completed.");
    }
}

