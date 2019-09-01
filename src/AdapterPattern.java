import java.util.Calendar;
import java.util.Date;

interface Event{
    String getName();
    Date getStart();
    Date getEnd();
}

class CalendarClient implements Event {
    String name;
    Date start;
    Date end;

    public CalendarClient(String name, Date start, Date end){
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Date getStart() {
        return this.start;
    }

    @Override
    public Date getEnd() {
        return this.end;
    }
}

class PublicHoliday{
    private String name;
    private Date date;

    public PublicHoliday(String name, Date date){
        this.name = name;
        this.date = date;
    }

    public String getName(){
        return this.name;
    }

    public Date getDate(){
        return this.date;
    }
}

class PublicHolidayAdapter implements Event {

    PublicHoliday publicHoliday;

    public PublicHolidayAdapter(PublicHoliday publicHoliday){
        this.publicHoliday = publicHoliday;
    }

    @Override
    public String getName() {
        return this.publicHoliday.getName();
    }

    @Override
    public Date getStart() {
        return this.publicHoliday.getDate();
    }

    @Override
    public Date getEnd() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.publicHoliday.getDate());
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
}

public class AdapterPattern {
    public static void main( String[] args ) {
        CalendarClient calendarClient = new CalendarClient("A", new Date(), new Date());
        PublicHoliday publicHoliday = new PublicHoliday("Eid", new Date());

        PublicHolidayAdapter adapter = new PublicHolidayAdapter(publicHoliday);
    }
}
