package me.geesy.remainder.util;

import java.text.SimpleDateFormat;

public class Logger {

    /**
     * Prints anything out with a tag.
     *
     * @param message The object you wish to print.
     * @author frosty
     */
    public static void info(Object message) {
        System.out.println("[CLIENT] " + message);
        String prefix = "["+(new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()))+"] ["+Thread.currentThread().getName()+"/INFO] [Remainder]: ";
        System.out.println(prefix + message);
    }

    /**
     * Prints anything out with a tag.
     *
     * @param message The object you wish to print.
     * @author frosty
     */
    public static void warning(Object message) {
        System.out.println("[CLIENT] " + message);
        String prefix = "["+(new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()))+"] ["+Thread.currentThread().getName()+"/WARN] [Remainder]: ";
        System.out.println(prefix + message);
    }

    /**
     * Prints anything out with a tag.
     *
     * @param message The object you wish to print.
     * @author frosty
     */
    public static void error(Object message) {
        System.err.println("[CLIENT] " + message);
        String prefix = "["+(new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()))+"] ["+Thread.currentThread().getName()+"/ERROR] [Remainder]: ";
        System.out.println(prefix + message);
    }

    public static void error(Object msg, Exception e) {
        String prefix = "["+(new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()))+"] ["+Thread.currentThread().getName()+"/ERROR] [Remainder]: ";
        System.out.println(prefix + msg);

        System.err.println(prefix + e.getClass().getName() + ": " + e.getMessage());

        StackTraceElement[] stackTraceElements = e.getStackTrace();

        for(StackTraceElement stackTraceElement : stackTraceElements) {
            System.err.println(prefix+stackTraceElement.toString());
        }
    }
}