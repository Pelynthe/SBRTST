import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    int subSequenceStartAt, i;
    int [] sequenceExecutor (int [] digits) {
        i = 0;
        subSequenceStartAt = 0;
        List<int[]> list = new ArrayList();
        IntStream.of(digits)
                .reduce((previous, next) -> {
                    i++;
                    if (previous < next) {
                        if (i == digits.length - 1) {
                            list.add(Arrays.copyOfRange(digits, subSequenceStartAt, digits.length));
                        }
                    }
                    else {
                        if (i - subSequenceStartAt > 1) list.add(Arrays.copyOfRange(digits, subSequenceStartAt, i));
                        subSequenceStartAt = i;
                    }
                    return next;
                });
        int maxLength = 0, elementNumber = 0;
        for (int j = 0; j < list.size(); j++) {
            if (maxLength < list.get(j).length) {
                maxLength = list.get(j).length;
                elementNumber = j;
            }
        }
/*        //Вывод самой длинной возрастающей подстроки
        for (int digit: list.get(elementNumber)) {
            System.out.print(digit + "\t");
        }*/
        return list.get(elementNumber);
    }
}