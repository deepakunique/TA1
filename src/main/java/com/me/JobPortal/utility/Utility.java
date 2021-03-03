package com.me.JobPortal.utility;

import java.sql.Timestamp;
import java.util.Calendar;

public class Utility {
	
	public static Timestamp getCurrentDateTime() {
		
		Calendar calendar = Calendar.getInstance();
        Timestamp startDate = new Timestamp(calendar.getTimeInMillis());
        return startDate;
        
		
	}

}
