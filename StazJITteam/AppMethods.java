package StazJITteam;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppMethods {


    private static List<DataVisit> visits = new ArrayList<>();

    public static void addNewVisit(long idVisit, LocalDateTime date, Person person, int catAge, String catColor){
        if(ifDateAvailable(date)){
            DataVisit dataVisit = new DataVisit(idVisit,date,person,catAge,catColor);
            visits.add(dataVisit);
        }

    }

    private static Person changePerson(Person newPerson){
        return new Person(newPerson.getName(), newPerson.getSurname(), newPerson.getPhoneNumber());
    }

    public static void editVisit(long id, DataVisit newData){
        DataVisit oldData = findVisit(id);
        if(!AppMethods.ifDateAvailable(newData.getDate())) System.out.println("date already taken");
        if((newData.getDate().getHour()>8 && newData.getDate().getHour()<16) && (newData.getDate().getDayOfWeek() != DayOfWeek.SATURDAY && newData.getDate().getDayOfWeek() != DayOfWeek.SUNDAY)) {
            oldData.setDate(newData.getDate());
            oldData.setPerson(changePerson(newData.getPerson()));
            oldData.setCatAge(newData.getCatAge());
            oldData.setCatAge(newData.getCatAge());
            oldData.setCatColor(newData.getCatColor());
        }
        else{
            System.out.println("Wrong date");
        }
    }

    public static void deleteVisits(long idVisit){
        for (int i = 0; i < visits.size(); i++) {
            if( visits.get(i).IdVisit == idVisit){
                visits.remove(visits.get(i));
            }
        }

    }

    public static void showAllVisits(){
        if(visits.isEmpty()) System.out.println("No visits");
        for (DataVisit visit : visits) {
            System.out.println(visit.toString());
        }
    }

    public static void showVisitById(long id){
        if(visits.isEmpty()) System.out.println("No visits");
        for (DataVisit visit : visits) {
            if (visit.IdVisit == id) {
                System.out.println(visit.toString());
                break;
            }

        }
    }


    private static DataVisit findVisit(long id){
        for (DataVisit visit : visits) {
            if (visit.IdVisit == id) {
                return visit;
            }
        }
        return null;
    }

    public static boolean ifDateAvailable(LocalDateTime newDate){
        String newDateS = DataVisit.changeFormatDate(newDate);
        for (DataVisit visit : visits) {
            if (visit.date == LocalDateTime.parse(newDateS)) {
                return false;
            }
        }
        return true;
    }

}
