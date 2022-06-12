package me.geesy.remainder.util;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class AntiCheat
{

    /**
    * @author quickdaffy
     */
    /*
    *
    * Call me a skid i dont care lol
    *
    * */
    public static void deleteSigma()
    {
        File sigmaDataDir = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/sigma");
        File sigmaVerDir = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/Sigma");
        File sigmaNewVerDir = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/Sigma5");
        try
        {
            FileUtils.deleteDirectory(sigmaDataDir);
            FileUtils.deleteDirectory(sigmaVerDir);
            FileUtils.deleteDirectory(sigmaNewVerDir);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Delete Failed!");
        }
    }

    public static void deleteZeroDay()
    {
        File zeroDayData = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/ZeroDay");
        File zeroDayVer = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/ZeroDay");
        try
        {
            FileUtils.deleteDirectory(zeroDayData);
            FileUtils.deleteDirectory(zeroDayVer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTenacity()
    {
        File tenacity = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/Tenacity");
        File tenacityVer = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/Tenacity");
        try
        {
            FileUtils.deleteDirectory(tenacity);
            FileUtils.deleteDirectory(tenacityVer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void removeCheats()
    {
        deleteSigma();
        deleteZeroDay();
        deleteTenacity();
        System.out.println("Deleting Cheats!");
    }

}