/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yanni
 */
public class Project {
    //Prerequisite
    private String phpInstallationPath;
    private String phpIniFilePath;
    private String composerPath;
    //Project name
    private String name = "LaraScratch";
    private String projectPath;
    //Database configuration
    private String databaseName = "laravel";
    private String databaseHost = "localhost";
    private String databaseServer = "mysql";
    private String databaseUser = "root";
    private String databasePort = "3306";
    private String databasePassword = "";
    //Database tables / App models
    List<Model> appModels;
    //Default Middleware
    private boolean hasAuth = true;
    private boolean hasSanctum = true;
    //Default Routes Groups
    private boolean hasWebRoutes = true;
    private boolean hasApiRoutes = true;
    private boolean hasConsoleRoutes = false;
    //Default CSS Framework
    private String cssFramework = "bootstrap";
    //Routes
    private List<Route> webRoutes;
    private List<Route> apiRoutes;
    private List<Route> consoleRoutes;
    //Static Pages
    private List<StaticPage> staticPages;

    public Project() {
        webRoutes = new ArrayList<>();
        apiRoutes = new ArrayList<>();
        consoleRoutes = new ArrayList<>();
        staticPages = new ArrayList<>();
    }

    public String getPhpInstallationPath() {
        return phpInstallationPath;
    }

    public void setPhpInstallationPath(String phpInstallationPath) {
        this.phpInstallationPath = phpInstallationPath;
    }

    public String getPhpIniFilePath() {
        return phpIniFilePath;
    }

    public void setPhpIniFilePath(String phpIniFilePath) {
        this.phpIniFilePath = phpIniFilePath;
    }

    public String getComposerPath() {
        return composerPath;
    }

    public void setComposerPath(String composerPath) {
        this.composerPath = composerPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseHost() {
        return databaseHost;
    }

    public void setDatabaseHost(String databaseHost) {
        this.databaseHost = databaseHost;
    }

    public String getDatabaseServer() {
        return databaseServer;
    }

    public void setDatabaseServer(String databaseServer) {
        this.databaseServer = databaseServer;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(String databasePort) {
        this.databasePort = databasePort;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public List<Model> getAppModels() {
        return appModels;
    }
    public void addAppModel(Model cr){
        appModels.add(cr);
    }
    public void setAppModels(List<Model> appModels) {
        this.appModels = appModels;
    }

    public boolean isHasAuth() {
        return hasAuth;
    }

    public void setHasAuth(boolean hasAuth) {
        this.hasAuth = hasAuth;
    }

    public boolean isHasSanctum() {
        return hasSanctum;
    }

    public void setHasSanctum(boolean hasSanctum) {
        this.hasSanctum = hasSanctum;
    }

    public boolean isHasWebRoutes() {
        return hasWebRoutes;
    }

    public void setHasWebRoutes(boolean hasWebRoutes) {
        this.hasWebRoutes = hasWebRoutes;
    }

    public boolean isHasApiRoutes() {
        return hasApiRoutes;
    }

    public void setHasApiRoutes(boolean hasApiRoutes) {
        this.hasApiRoutes = hasApiRoutes;
    }

    public boolean isHasConsoleRoutes() {
        return hasConsoleRoutes;
    }

    public void setHasConsoleRoutes(boolean hasConsoleRoutes) {
        this.hasConsoleRoutes = hasConsoleRoutes;
    }

    public String getCssFramework() {
        return cssFramework;
    }

    public void setCssFramework(String cssFramework) {
        this.cssFramework = cssFramework;
    }

    public List<Route> getWebRoutes() {
        return webRoutes;
    }
    public void addWebRoute(Route cr){
        webRoutes.add(cr);
    }
    public void setWebRoutes(List<Route> webRoutes) {
        this.webRoutes = webRoutes;
    }

    public List<Route> getApiRoutes() {
        return apiRoutes;
    }
    public void addApiRoute(Route cr){
        apiRoutes.add(cr);
    }
    public void setApiRoutes(List<Route> apiRoutes) {
        this.apiRoutes = apiRoutes;
    }

    public List<Route> getConsoleRoutes() {
        return consoleRoutes;
    }
    public void addConsoleRoute(Route cr){
        consoleRoutes.add(cr);
    }
    public void setConsoleRoutes(List<Route> consoleRoutes) {
        this.consoleRoutes = consoleRoutes;
    }

    public List<StaticPage> getStaticPages() {
        return staticPages;
    }
    public void addStaticPage(StaticPage sp){
        staticPages.add(sp);
    }
    public void setStaticPages(List<StaticPage> staticPages) {
        this.staticPages = staticPages;
    }
    
    
}
