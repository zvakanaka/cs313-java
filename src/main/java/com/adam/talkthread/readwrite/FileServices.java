/*
 * Content created by Adam Quinton
 */
package com.adam.talkthread.readwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adam
 */
public class FileServices {
    public static List<String> loadUsers(String url) throws FileNotFoundException, IOException {
        List<String> contentList = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            String content = "";
            reader = new BufferedReader(new FileReader(url));            
            while ((content = reader.readLine()) != null) {
                contentList.add(content);
            }
        } catch (Exception e) {
            e.printStackTrace();    
        } finally {
            
           reader.close();
           return contentList;           
        }
    }    
      //writes list to file, line by line
    public static void writeFile(List<String> commentList, String url) {
       try {            
            File file = new File(url);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
         //write out list of comments line by line
            for (String currComment : commentList) {
                bw.write(currComment + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
 
    //read file line by line into list
    public static List<String> readFile(String url) {
            List<String> commentList = new ArrayList<String>();
            try {
            BufferedReader bi = new BufferedReader(new FileReader(url));
            String line;
            while ((line = bi.readLine()) != null) {
                commentList.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return commentList;
    }
}