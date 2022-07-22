package me.geesy.remainder.util;

public class Logger {
    public static void info(Object message) {
        String prefix = "["+(new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()))+"] ["+Thread.currentThread().getName()+"/INFO] [Remainder]: ";
        System.out.println(prefix + message);
    }

    public static void warning(Object message) {
        String prefix = "["+(new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()))+"] ["+Thread.currentThread().getName()+"/WARN] [Remainder]: ";
        System.out.println(prefix + message);
    }

    public static void error(Object message) {
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
