import java.util.Scanner;
class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    MonthData monthData = new MonthData();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int mounth = scanner.nextInt();// ввод и проверка номера месяца
        mounth = mounth - 1;
        if((mounth < 0) | (mounth >= 12)){
            System.out.println("Введите значение от 1 до 12");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();// ввод и проверка дня
        day = day - 1;
        if((day < 0) | (day >= 30)){
            System.out.println("Введите значение от 1 до 30");
            return;
        }

        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();// ввод и проверка количества шагов
        if (step <= 0){
            System.out.println("Значение не может быть 0 или менее");
            return;
        }

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[mounth];
        // Сохранение полученных данных
        monthData.days[day] = step;
    }
    void changeStepGoal(){
        System.out.println("Укажите цель, в виде количества шагов");
        goalByStepsPerDay = scanner.nextInt();
            if(goalByStepsPerDay <= 0){
                goalByStepsPerDay = 10000;
            System.out.println("Ошибка. Цель не может быть менее или равна 0.");
        }
    }
    void printStatistic(){
        System.out.println("Введите число месяца");
        int mounth = scanner.nextInt(); // ввод и проверка номера месяца
        mounth = mounth - 1;
        if((mounth < 0) | (mounth >= 12)){
            System.out.println("Ошибка, введите число от 1 до 12");
            return;
        } // ввод и проверка номера месяца

        monthData = monthToData[mounth];    // получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth();   // получение суммы шагов за месяц
         monthData.printDaysAndStepsFromMonth();    // количество пройденных шагов по дням;
         System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth()); // общее количество шагов за месяц;
         System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());  // максимальное пройденное количество шагов в месяце;
         System.out.println("Среднее количество шагов: " + (monthData.sumStepsFromMonth() / monthToData[mounth].days.length)); // среднее количество шагов;
         System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(sumSteps)); // пройденная дистанция (в км);
         System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps)); // количество сожжённых килокалорий;
         System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay) + " дня подряд");// лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
         System.out.println(); //дополнительный перенос строки
    }
}
