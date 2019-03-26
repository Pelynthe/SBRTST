class SolutionOld {
    public int [] incrementSubstringFinder (int [] entry) {
        int leight = entry.length;
        if (leight == 0) return null;
        int currentSequence = 0, maxSequence = 0, currentSequenceStartAt = 0, maxSequenceStartAt = 0;
        boolean sequenceContinues = false;
        for (int i = 1; i < leight; i++) {
            if (entry[i] > entry[i-1]) {
                if (!sequenceContinues) currentSequenceStartAt = i-1;
                currentSequence++;
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                    maxSequenceStartAt = currentSequenceStartAt;
                }
                sequenceContinues = true;
            }
            else {
                currentSequence = 0; //Забыто в задании
                sequenceContinues = false;
            }
        }
        int [] result = new int[maxSequence];
        for (int i = 0; i < maxSequence; i++) {
            result[i] = entry[maxSequenceStartAt+i];
        }
        return result;
    }
}