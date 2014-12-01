
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


/*
 Formatos: 
 *user.cfo contiene: 
 -int numero correlativo
 -String de username
 -String password
 -String nombre completo
 -int conteo de puntos obtenidos por el usuario

 */
public class connectFour {

    public static final String FOLDER_RAIZ = "Connect_four";
    RandomAccessFile rUsers;
    static Scanner lea = new Scanner(System.in);

    public connectFour() {
        try {
            rUsers = new RandomAccessFile(FOLDER_RAIZ + "/user.cfo", "rw");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean buscarUsuario(String name, String pass) throws IOException {
        rUsers.seek(0);
        while (rUsers.getFilePointer() < rUsers.length()) {
            rUsers.readInt();
            if (rUsers.readUTF().equalsIgnoreCase(name) && rUsers.readUTF().equalsIgnoreCase(pass)) {
                return true;
            }
            rUsers.readUTF();
            rUsers.readInt();
        }
        return false;
    }

    public void menuInicial() throws IOException {
        while (true) {
            System.out.println("1.Login \n2.Crear Usuario \n3.Salir");
            int op = lea.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Username: ");
                    String un=lea.next();
                    System.out.println("Password: ");
                    String pass=lea.next();
                    if (buscarUsuario(un, pass)) {
                        
                    }
                        break;
                case 2:

                    break;
                default:

                    System.out.println("Opcion Invalida,intente de nuevo");

            }
        }
    }

}
