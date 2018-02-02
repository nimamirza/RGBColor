
import com.sun.org.apache.xerces.internal.util.FeatureState;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author Nima Mirzaei
 */
public class ColorPointDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            ArrayList<Colorpoint> cps = new ArrayList<>();
            Colorpoint obj1 = new Colorpoint(100,100,20,20,20);
            
            cps.add(obj1);
            Colorpoint obj2 = new Colorpoint(0,0,10,10,10);
            cps.add(obj2);

            obj1.equals(obj2);

            System.out.println("obj1:" + obj1.toString());

            // call the wrtiters.
            Colorpoint[] countries = cps.toArray(new Colorpoint[cps.size()]);

            writeColorPointArray("colorPointsFile.dat", countries);
            System.out.println("Finished saving objects into a binary file!");
            Colorpoint[] readFromFile = readColorPointArray("colorPointsFile.dat");
            System.out.println("Finished reading Objects from binary file...");
            
            for (Colorpoint c : readFromFile) {
                System.out.printf(">> %s\n", c.toString());
            }
            
            
        } catch (Exception e) {
//            e.printStackTrace();
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static Colorpoint[] readColorPointArray(String fileName)
            throws IOException {

        ArrayList<Colorpoint> colorPoints = new ArrayList<>();
        try {
            File file = new File(fileName);
            // open the binary file
            if (file.exists()) {

                ObjectInputStream inputStream
                        = new ObjectInputStream(new FileInputStream(file));
                Colorpoint cp = null;
                try {
                    while (true) {
                        cp = (Colorpoint) inputStream.readObject();
                        colorPoints.add(cp);
                        System.out.printf("reading ColorPoints:%s\n",cp.toString());
                    }
                } catch (EOFException e) {
                    System.out.println("No more numbers in the file.");
                }
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file numbers.dat.");
        } catch (IOException e) {
            System.out.println("Problem with input from file numbers.dat.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //return (Colorpoint[]) colorPoints.toArray();
        return colorPoints.toArray(new Colorpoint[colorPoints.size()]);

    }

    public static void writeColorPointArray(String fileName, Colorpoint[] points)
            throws IOException {
        ObjectOutputStream outputStream = null;

        try {
            File file = new File(fileName);
            // open the binary file
            if (file.exists()) {
                file.delete();
            }

            if (file.createNewFile()) {
                System.out.println("created a new file!");
            } else {
                System.out.println("failed to create a new file!");
            }

            outputStream
                    = new ObjectOutputStream(new FileOutputStream(file));

            for (Colorpoint cp : points) {
                if (Objects.nonNull(cp)) {
                    outputStream.writeObject(cp);
                    System.out.printf("object is non null and added! cp: %s\n", cp);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file.");
        } catch (IOException e) {
            System.out.println("Problem with input from file.");
        }

        if (outputStream != null) {
            outputStream.close();
        }

    }
}
