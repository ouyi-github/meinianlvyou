package com.atguigu.test;

import com.atguigu.log.MyFormatter;
import com.atguigu.log.MyLogger;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestLogger {
    @Test
    public void testlogger() throws IOException, InterruptedException {
        MyLogger test = new MyLogger("test", "E:\\project\\javaee\\meinianlvyou_ouyi\\meinianlvyou\\meinian_parent\\logs\\test.log");
        test.info("666666");
        test.severe("7777777");
        test.warning("8888888");
    }
}
