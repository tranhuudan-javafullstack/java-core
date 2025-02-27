package saveStudent;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Student {
    public int id;
    public String name;
    public int bYear;
    public double avg;

    public Student(int id, String name, int bYear, double avg) {
        super();
        this.id = id;
        this.name = name;
        this.bYear = bYear;
        this.avg = avg;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", bYear=" + bYear + ", avg=" + avg + "]";
    }

    public void save(DataOutput dos) throws IOException {
        dos.writeInt(this.id);
        dos.writeUTF(this.name);
        dos.writeInt(this.bYear);
        dos.writeDouble(this.avg);

    }

    public void read(DataInput dis) throws IOException {

        id = dis.readInt();
        name = dis.readUTF();
        bYear = dis.readInt();
        avg = dis.readDouble();

    }

}
