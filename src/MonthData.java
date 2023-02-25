class MonthData {
    int[] days = new int[30];
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]); // Вывод элементов массива в необходимом формате
        }
    }
    int sumStepsFromMonth(){
        int sumstep = 0;

        for (int day : days) {
            sumstep = sumstep + day; // Подсчет общего количества шагов
        }
        return sumstep;
    }
    int maxSteps(){
        int maxsteps = 0;

        for (int day : days) {
            maxsteps = day; // Подсчет максимального количества шагов за месяц
            for (int i : days) {
                if (i > maxsteps) {
                    maxsteps = i;
                }
            }
        }
        return maxsteps;
    }
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;

        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}