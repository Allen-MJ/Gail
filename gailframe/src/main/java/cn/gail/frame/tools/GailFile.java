package cn.gail.frame.tools;

import android.os.Environment;

import java.io.File;

public class GailFile {

    private static GailFile gailFile;
    private String genFile;
    private static File gen;
    private final String genName = "Cache";

    public static enum FileType{
        IMAGE,
        VIDEO,
        AUDIO,
        DOCMENT,
        HTML,
        NONE
    }

    private GailFile(){
//        genFile = Environment.getExternalStorageDirectory() + "/" + genName;
        gen = new File(Environment.getExternalStorageDirectory(),genName);
        if (!gen.exists()) {
            gen.mkdirs();
        }
    }

    public static GailFile getInstance(){
        if(gailFile==null){
            synchronized (GailFile.class){
                if(gailFile==null){
                    gailFile = new GailFile();
                }
            }
        }
        return gailFile;
    }

    public File getGen(){
        return gen;
    }

    private String[] images(){
        String[] image = { "bmp", "png","jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd", "cdr",
                "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf" };
        return image;
    }

    private String[] videos(){
        String[] video = { "mp4", "avi", "mov", "mpeg", "mpg", "wmv", "asf", "navi", "3gp", "mkv", "f4v", "rmvb",
                "webm", "flv", "ts", "tb", "divx", "xvid", "m4v"};
        return video;
    }

    private String[] audios(){
        String[] audio = { "mp3", "wma", "wav", "mod", "ra", "cd", "md", "asf", "aac", "vqf", "ape", "mid", "ogg",
                "m4a", "vqf" };
        return audio;
    }
    private String[] docments(){
        String[] docment = { "doc", "docx", "xls", "rtf", "wpd", "pdf", "ppt","pps","xlsx","txt","pptx" };
        return docment;
    }
    private String[] htmls(){
        String[] html = { "html", "aspx", "htm", "jsp","chm" };
        return html;
    }
}
