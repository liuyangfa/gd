package org.gateway.gd.util;

import java.util.Date;

public class IntervalDays {
	public static Long getIntervalDays(Date startday,Date endday){        
		        if(startday.after(endday)){
		            Date cal=startday;
		            startday=endday;
		            endday=cal;
		        }        
		        long sl=startday.getTime();
		        long el=endday.getTime();       
		        long ei=el-sl;           
		        return ei/(1000*60*60*24);
		    }
}
