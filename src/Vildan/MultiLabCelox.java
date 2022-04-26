package Vildan;

import java.util.Scanner;

public class MultiLabCelox {

    public static final String START_MSG = "Измерьте окисленность и температуру металла кислородным зондом с помощью системы Целокс";
    public static final String ENTER_VALUE_MSG = "Введите полученное значение окисленности металла в ppm = ";
    public static final String END_MSG = "После окончание ввода алюминиевой катанки произведите усреднительную продувку металла с " +
            "продолжительностью не менее 4 минут. Измерьте температуру и промаркируйте отобранные пробы металла.";
    public static final String REMEASUREMENT_MSG = "Окисленность металла более 300 ppm, произведите повторное измерение";
    public static final String LESS_THEN_70_MSG = "Отбирите пробу, а затем введите алюминиевую катанку с расходом 100-150 м меньше" +
            " относительной рекомендации системы Целокс";
    public static final String QUESTION_MSG = "Имеются признаки попадания сталеплавильного шлака? Напишите - Да." +
            " Если признаков нет - напишите Нет или любое значение.";
    public static final String MORE_70_MSG = "Произведите ввод алюминиевой катанки с расходом в соотвествии с рекомендациями системы" +
            " Целокс, а затем возьмите пробу. ";


    public void obtainingOxidation(Metal metal) {

        Scanner console = new Scanner(System.in);
        System.out.println(START_MSG);
        System.out.println(ENTER_VALUE_MSG);

        int firstMeasurementOfOxidation = console.nextInt();
        int resultMeasurementOfOxidation = checkMinValue(console, firstMeasurementOfOxidation);

        if (resultMeasurementOfOxidation <= 70) {
            System.out.println(LESS_THEN_70_MSG);
            System.out.println(QUESTION_MSG);
            if (console.next().equalsIgnoreCase("Да")) {
                System.out.println("Увеличьте расход катанки на 100-200 м");
            }
        } else
            System.out.println(MORE_70_MSG);
        System.out.println(END_MSG);
    }

    private int checkMinValue(Scanner console, int firstMeasurementOfOxidation) {
        int secondMeasurementOfOxidation;
        int resultMeasurementOfOxidation;
        if (firstMeasurementOfOxidation > 300) {
            System.out.println(REMEASUREMENT_MSG);
            System.out.println(ENTER_VALUE_MSG);
            secondMeasurementOfOxidation = console.nextInt();

            if (firstMeasurementOfOxidation < secondMeasurementOfOxidation)
                resultMeasurementOfOxidation = firstMeasurementOfOxidation;
            else resultMeasurementOfOxidation = secondMeasurementOfOxidation;

        } else resultMeasurementOfOxidation = firstMeasurementOfOxidation;
        return resultMeasurementOfOxidation;
    }
}

