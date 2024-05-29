package StazJITteam;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataVisit {
    long IdVisit;
    LocalDateTime date;
//    String date;
    private Person person;
    private int catAge;
    private String catColor;
    private boolean ifAvailable = true;
    private static final int visitTime = 1;

    public void setIfAvailable(boolean ifAvailable) {
        this.ifAvailable = ifAvailable;
    }
    public static String changeFormatDate(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");
        String formatDate = formatter.format(date);
        return formatDate;
    }

    public DataVisit(long idVisit, LocalDateTime date, Person person, int catAge, String catColor) {
        if(!AppMethods.ifDateAvailable(date)) System.out.println("date already taken");
        if((date.getHour()>8 && date.getHour()<16) && (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY)) {
            this.IdVisit = idVisit;
            this.date = LocalDateTime.parse(changeFormatDate(date));
            this.person = person;
            this.catAge = catAge;
            this.catColor = catColor;
        }
        else{
            System.out.println("Doctor is close");
        }

    }

    public void setDate(LocalDateTime date) {
        this.date = LocalDateTime.parse(changeFormatDate(date));
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setCatAge(int catAge) {
        this.catAge = catAge;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }

    public long getIdVisit() {
        return IdVisit;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Person getPerson() {
        return person;
    }

    public int getCatAge() {
        return catAge;
    }

    public String getCatColor() {
        return catColor;
    }

    public boolean isIfAvailable() {
        return ifAvailable;
    }

    @Override
    public String toString() {
        return "DataVisit{" +
                "IdVisit=" + IdVisit +
                ", date=" + date +
                ", person= (" + person.toString() +
                ",) catAge=" + catAge +
                ", catColor='" + catColor + '\'' +
                ", ifAvailble=" + ifAvailable +
                '}';
    }
}
