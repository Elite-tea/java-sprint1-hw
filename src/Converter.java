public class Converter {
    int convertToKm(int steps){
        return (int) (steps * 0.00075); // Конвертация шагов в км. 1см = 0.00075 километра.
    }
    int convertStepsToKilocalories(int steps){
        return (int) (steps / 20);// Конвертация шагов в калории. 1000/50=20.
    }
    }