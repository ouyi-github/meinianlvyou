package com.atguigu.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MyLogger {
    private String loggerName;
    private String fileName;
    private Logger logger;

    public MyLogger(String loggerName, String fileName) {
        this.loggerName = loggerName;
        this.fileName = fileName;
    }

    public MyLogger() {
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Logger getLogger() throws IOException {
        if (this.logger != null) {
            return this.logger;
        } else {
            Logger resLogger = Logger.getLogger(this.loggerName);
            FileHandler fileHandler = new FileHandler(this.fileName, true);
            fileHandler.setEncoding("utf8");
            fileHandler.setFormatter(new MyFormatter());
            resLogger.addHandler(fileHandler);
            this.logger = resLogger;
            return this.logger;
        }
    }

    public void info(String message){
        try {
            this.getLogger().info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void warning(String message){
        try {
            this.getLogger().warning(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void severe(String message){
        try {
            this.getLogger().severe(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
