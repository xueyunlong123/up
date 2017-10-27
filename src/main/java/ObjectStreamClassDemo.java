import java.io.ObjectStreamClass;
import java.io.Serializable;

/**
 * Created by xueyunlong on 17-8-25.
 */
public class ObjectStreamClassDemo {

    class SerializablePerson implements Serializable{

        private String name;

        private transient String age;
    }
    class UnSerializablePerson{

        private String name;

        private  String age;
    }

    public static void main(String[] args) {
        ObjectStreamClass objectStreamClass = ObjectStreamClass.lookup(SerializablePerson.class);
        System.out.println("stop");
    }
}
