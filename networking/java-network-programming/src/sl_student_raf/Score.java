package sl_student_raf;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Score {
    private int id;
    private double score;

    public Score(int id, double score) {
        this.id = id;
        this.score = score;
    }


    public Score() {
        super();
    }

    @Override
    public String toString() {
        return "Score [id=" + id + ", score=" + score + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void load(RandomAccessFile raf) throws IOException {

        id = raf.readInt();
        score = raf.readDouble();

    }


}
