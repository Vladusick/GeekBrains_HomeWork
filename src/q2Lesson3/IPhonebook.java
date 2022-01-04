package q2Lesson3;

import java.util.*;

public interface IPhonebook {

    void add(String surname, String phoneNumber);

    Set<String> get(String surname);

    Set<String> getAllSurnames();




}
