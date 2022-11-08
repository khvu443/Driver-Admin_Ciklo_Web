/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;

import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class SaveToJSON {

    public SaveToJSON() {
    }

    private FileWriter file;
    
    public void saveFile(JSONObject obj, String nameFile) {
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            
            //Nên sửa lại theo cái folder mình lưu json
            // - Khuyến khích là nên tạo 1 folder Admin riêng rồi dùng Redirect
            file = new FileWriter("E:/Project/SWP/CikloWeb/src/main/webapp/Driver/JSON/" + nameFile + ".json"); 
            file.write(obj.toJSONString());
            CrunchifyLog("Successfully Copied JSON Object to File...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public void CrunchifyLog(String str) {
        System.out.println(str);
    }

}
