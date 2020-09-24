package Enums;

public enum DayOfWeek {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

    static String getWorkingHours(DayOfWeek dayOfWeek) {
        int time = 8; //количество часов в рабочем дне
        int workingDays = 5; // количество рабочих дней в неделе

        if (dayOfWeek.ordinal() <= 4) {
            return "" + ((workingDays - dayOfWeek.ordinal()) * time);
        }
        else
            return "Сегодня выходной";
    }
}
