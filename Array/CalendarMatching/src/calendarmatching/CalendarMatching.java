/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Time Complexity: O(c1 + c2) where c1 and c2 are respective numbers of meeting
 * Space Complexity: O(c1 + c2) because of merging both calendar schedules
 * @author souravpalit
 */
public class CalendarMatching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*String[][] firstSchedule = {{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};
        String[][] secondSchedule = {{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] bounds1 = {"9:00", "20:00"};
        String[] bounds2 = {"10:00", "18:30"};
        int meetingDuration = 30;*/
        /*String[][] firstSchedule = {{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};
        String[][] secondSchedule = {{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] bounds1 = {"9:00", "20:00"};
        String[] bounds2 = {"10:00", "18:30"};
        int meetingDuration = 45;*/
        /*String[][] firstSchedule = {{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};
        String[][] secondSchedule = {{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] bounds1 = {"8:00", "20:00"};
        String[] bounds2 = {"7:00", "18:30"};
        int meetingDuration = 45;*/
         String[][] firstSchedule = {{"10:00", "10:30"}, {"10:45", "11:15"}, {"11:30", "13:00"}, {"14:15", "16:00"}, {"16:00", "18:00"}};
        String[][] secondSchedule = {{"10:00", "11:00"}, {"12:30", "13:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] bounds1 = {"9:30", "20:00"};
        String[] bounds2 = {"9:00", "18:30"};
        int meetingDuration = 15;
        List<StringMeeting> calendar1 = new ArrayList<StringMeeting>();
        List<StringMeeting> calendar2 = new ArrayList<StringMeeting>();

        for (String[] meeting : firstSchedule) {
            calendar1.add(getMeeting(meeting));
        }

        for (String[] meeting : secondSchedule) {
            calendar2.add(getMeeting(meeting));
        }

        StringMeeting dailyBounds1 = getMeeting(bounds1);
        StringMeeting dailyBounds2 = getMeeting(bounds2);

        
        
        List<StringMeeting> availableTimes = matchCalendar(calendar1, dailyBounds1,
                calendar2, dailyBounds2, meetingDuration);
        
        for (StringMeeting meeting : availableTimes) {
            System.out.println("[" + meeting.start+", " + meeting.end+"]");
        }

    }

    public static List<StringMeeting> matchCalendar(List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
      // First Add boundaries to Calendar
      List<StringMeeting> boundedCalendar1 = addBoundsToCalendar(calendar1, dailyBounds1);
      List<StringMeeting> boundedCalendar2 = addBoundsToCalendar(calendar2, dailyBounds2);
      // Map String to Int time so that we can compare time
      List<IntMeeting> firstCalendar = mapStringToIntMeeting(boundedCalendar1);
      List<IntMeeting> secondCalendar = mapStringToIntMeeting(boundedCalendar2);
      // Merged both calendars
      List<IntMeeting> mergedCalendar = mergeCalendars(firstCalendar, secondCalendar);
      // Merged overlapping shcedules
      List<IntMeeting> flattenedCalendar = flattenCalendar(mergedCalendar);
      // Find available meeting time
      List<IntMeeting> availableMeetingTimes = findAvailableMeetingTimes(flattenedCalendar, meetingDuration);
      return mapIntMeetingToStringMeeting(availableMeetingTimes);
    }
    
    public static List<StringMeeting> addBoundsToCalendar(List<StringMeeting> calendar, 
            StringMeeting bounds) {
        List<StringMeeting> meetings = new ArrayList<StringMeeting>();
        meetings.add(new StringMeeting("0:00", bounds.start));
        meetings.addAll(calendar);
        meetings.add(new StringMeeting(bounds.end, "23:59"));
        return meetings;
    }
    
    public static List<IntMeeting> mapStringToIntMeeting(List<StringMeeting> calendar) {
        List<IntMeeting> meetings = new ArrayList<IntMeeting>();
        
        for (StringMeeting stringMeeting : calendar) {
            meetings.add(new IntMeeting(toIntTime(stringMeeting.start), toIntTime(stringMeeting.end)));
        }
        return meetings;
    }

    public static List<IntMeeting> mergeCalendars(List<IntMeeting> calendar1, 
            List<IntMeeting> calendar2) {
        List<IntMeeting> mergedCalendar = new ArrayList<IntMeeting>();
        
        int i = 0;
        int j = 0;
        
        while (i < calendar1.size() && j < calendar2.size()) {
            IntMeeting firstMeeting = calendar1.get(i);
            IntMeeting secondMeeting = calendar2.get(j);
            
            if (firstMeeting.start < secondMeeting.start) {
                mergedCalendar.add(firstMeeting);
                i++;
            } else {
                mergedCalendar.add(secondMeeting);
                j++;
            }
        }
        
        // Calendar length may vary so we need to add remaining schedules
        
        while (i < calendar1.size()) {
            mergedCalendar.add(calendar1.get(i));
                i++;
        }
        
        while (j < calendar2.size()) {
            mergedCalendar.add(calendar2.get(j));
                j++;
        }
        
        return mergedCalendar;
    }

    public static List<IntMeeting> flattenCalendar(List<IntMeeting> calendar) {
        List<IntMeeting> flattenedCalendar = new ArrayList<IntMeeting>();
        flattenedCalendar.add(calendar.get(0));
        
        for (int i = 1; i < calendar.size(); i++) {
            IntMeeting previousMeeting = flattenedCalendar.get(flattenedCalendar.size() - 1);
            IntMeeting currentMeeting = calendar.get(i);
            
            if (previousMeeting.end > currentMeeting.start) {
                IntMeeting newMeeting = new IntMeeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
                flattenedCalendar.set(flattenedCalendar.size() - 1, newMeeting);
            } else {
                flattenedCalendar.add(currentMeeting);
            }
        }
        
        return flattenedCalendar;
    }
    
    public static List<IntMeeting> findAvailableMeetingTimes(List<IntMeeting> calendar, int meetingDuration) {
        List<IntMeeting> availableTimes = new ArrayList<IntMeeting>();
        
        for (int i = 1; i < calendar.size(); i++) {
            
            int availableDuration = calendar.get(i).start - calendar.get(i - 1).end;
            
            if (availableDuration >= meetingDuration) {
                availableTimes.add(new IntMeeting(calendar.get(i - 1).end, calendar.get(i).start));
            }
        }
        
        return availableTimes;
    }
    
    public static List<StringMeeting> mapIntMeetingToStringMeeting(List<IntMeeting> meetings) {
        List<StringMeeting> stringMeetings = new ArrayList<StringMeeting>();
        
        for (IntMeeting intMeeting : meetings) {
            stringMeetings.add(new StringMeeting(toStringTime(intMeeting.start), toStringTime(intMeeting.end)));
        }
        
        return stringMeetings;
    }
    
    public static StringMeeting getMeeting(String[] meeting) {
        return new StringMeeting(meeting[0], meeting[1]);
    }

    public static int toIntTime(String time) {
        StringTokenizer token = new StringTokenizer(time, ":");
        List<String> timeComponent = new ArrayList<String>();

        while (token.hasMoreTokens()) {
            timeComponent.add(token.nextToken());
        }

        return Integer.valueOf(timeComponent.get(0)) * 60 + Integer.valueOf(timeComponent.get(1));
    }
    
    public static String toStringTime(int time) {
        int minute = time % 60;
        String start = "";
        
        if (minute < 9) {
             start += ((int) time / 60) + ":0" + minute;
        } else {
            start += ((int) time / 60) + ":" + minute;
        }
        
        return start;
    }

    static class StringMeeting {

        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

    }
    
    static class IntMeeting {

        public int start;
        public int end;

        public IntMeeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
