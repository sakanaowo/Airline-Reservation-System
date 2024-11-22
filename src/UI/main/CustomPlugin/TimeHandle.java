package UI.main.CustomPlugin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeHandle {

    String[] daysInVietnamese = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
    SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm"), dayFormat = new SimpleDateFormat("dd-MM-yyyy");
    Calendar calendar = Calendar.getInstance();

    public String getDiffTime(Date Dep, Date Arr) {
        long diffInMillis = Math.abs(Arr.getTime() - Dep.getTime());

        long hours = diffInMillis / (60 * 60 * 1000);
        long minutes = (diffInMillis / (60 * 1000)) % 60;
        return hours + " " + minutes;
    }

    public String getHour(Date date) {
        return hourFormat.format(date);
    }

    public String getTDMY(Date date) {
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] day = dayFormat.format(date).split("-");

        return daysInVietnamese[dayOfWeek - 1] + ", " + day[0] + " tháng " + day[1] + ", " + day[2];
    }

    public TimeHandle() {
    }
}
