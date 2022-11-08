/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;

import Model.Bill;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AvgEarningDriver {

    public AvgEarningDriver() {
    }

    CheckTime ct = new CheckTime();

    //Lưu Số tiền trung bình đã kiếm được theo từng tháng vào JSON
    public JSONObject EarningAvg(ArrayList<Bill> b) throws ParseException {

        JSONObject obj = new JSONObject(); // Có thể hiểu là gần giống với map
        JSONArray earn = new JSONArray(); // Tương tự với list or ArrayList

        double total = 0;
        int count = 0;

        //Để tạo ra 1 mảng string các tháng viết tắt tiếng anh
        // VD: Octobel => Otc 
        String[] shortMonths = new DateFormatSymbols().getShortMonths();

        // Chuyển đổi chuyển string theo format thành date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // => chuyển đổi date có format là yyyy-MM-dd HH:mm:ss thành kiểu date
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM"); //Chuyển đổi string có format MM thành kiểu date. Vd: 06 => Tháng 6 (June)
        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM"); // Chuyển đổi format có kiểu MMM => thành kiẻu date. VD Oct => tháng 10 trg kiểu date

        // Vòng lặp có độ dài là 12 tháng (trừ 1 bởi vì shortMonths có độ dài là 13)
        for (int j = 0; j < shortMonths.length - 1; j++) {
            //Map để lưu các key và value. Key là tên và value 
            // Key     :  value
            // "month" : "jan"
            // "earn" : "avg"
            Map<String, String> avg = new HashMap<>();

            // Tạo vòng lặp bill để chạy kiểm tra bên trong vòng lặp tháng để check tháng
            // khi j = 0 => tháng 1 
            // chạy hết hóa đơn rồi check xem có hóa đơn nào cùng tháng 1 không
            for (int i = 0; i < b.size(); i++) {

                //getDate() trong bill sẽ có kiểu là yyyy-MM-dd HH:mm:ss - 2022-10-12 15:22:30
                // nên ở điều kiên để check year sẽ dùng sdf để chuyển sáng date
                if (ct.isCurentYear(sdf.parse(b.get(i).getDate()))) // Kiểm tra xem hóa đơn đã quá cũ hay không (thưa thời điểm hiện tại 1 năm)
                {
                    //check xem tháng của từng hóa đơn có cùng tháng của j phần tử bên shortMonths không
                    // - tách getDate() của bill - 2022-10-12 15:22:30 bằng split("-") sẽ tạo ra 1 mảng là { 2022, 10, 12 15:22:30}
                    // rồi lấy phần tử thứ 2 - index = 1 để lấy tháng của bill
                    // - dùng hàm isCurrentMonth(date1, date2) để check xem có trùng không
                    if (ct.isCurrentMonth(sdf1.parse(b.get(i).getDate().split("-")[1]), sdf2.parse(shortMonths[j]))) {
                        total += b.get(i).getTotal(); // mỗi lần trùng thì sẽ cộng các hóa đơn lại
                        count += 1; // đếm số lần các tháng trùng

                    }
                }
            }
            
            // Lưu các avg theo từng tháng vào map
            avg.put("month", shortMonths[j]); //lưu từng tháng
            // kiểm tra xem count nó phải khác không nếu không khác 0 thì earn của tháng đó sẽ là 0
            if (count != 0) {
                avg.put("earn", String.valueOf(total));
            } else {
                avg.put("earn", "0");
            }
            
            // reset lại giá trị nếu không sẽ bị cộng dồn
            total = 0;
            count = 0;
            //Add map vào JSONArray
            earn.add(avg);
        }
        //Add JSONArray vào JSONObject gần giống với map
        // - JSONObject.put(key, value);
        // - value có thể là gì cũng được
        obj.put("EarningReport", earn);
        // trả về JSONObject để dùng cho bên save file
        return obj;
    }

    // Cách làm tương tự
    public JSONObject NumberTrip(ArrayList<Bill> b) throws ParseException {

        JSONObject obj = new JSONObject();
        JSONArray trips = new JSONArray();

        int count = 0;

        String[] shortMonths = new DateFormatSymbols().getShortMonths();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM");

        for (int j = 0; j < shortMonths.length - 1; j++) {
            Map<String, String> trip = new HashMap<>();

            for (int i = 0; i < b.size(); i++) {

                if (ct.isCurentYear(sdf.parse(b.get(i).getDate()))) {
                    if (ct.isCurrentMonth(sdf1.parse(b.get(i).getDate().split("-")[1]), sdf2.parse(shortMonths[j]))) {
                        count += 1;
                    }
                }
            }
            trip.put("month", shortMonths[j]);
            trip.put("trips", String.valueOf(count));

            count = 0;

            trips.add(trip);
        }
        obj.put("NumberTrip", trips);
        return obj;
    }

}
