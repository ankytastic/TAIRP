import java.util.*;
import java.io.*;
import javax.swing.*;

class PersonInfo{
    String name;
    String address;
    String phone;

    PersonInfo(String n,String a,String p){
        name=n;
        address=a;
        phone=p;
    }

    void display(){
        JOptionPane.showMessageDialog(null,"Name: " + name + "\nAddress: " + address+"\nPhone no.: "+phone);
    }
}

class AddressBook{
    ArrayList<PersonInfo> persons;

    AddressBook() {
        persons = new ArrayList<>();
        loadPersons();
    }

    void addPerson(){
        String name=JOptionPane.showInputDialog("Enter the name: ");
        String address=JOptionPane.showInputDialog("Enter the address: ");
        String phone=JOptionPane.showInputDialog("Enter the phone no.: ");
        PersonInfo p =new PersonInfo(name,address,phone);
        persons.add(p);
    }
    void searchPerson(String n){
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p=(PersonInfo) persons.get(i);
            if(n.equals(p.name)){
                p.display();
            }
        }
    }
    void updatePerson(String n){
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p=(PersonInfo) persons.get(i);
            if(n.equals(p.name)){
                String address=JOptionPane.showInputDialog("Enter the updated address: ");
                String phone=JOptionPane.showInputDialog("Enter the updated phone no.: ");
                p.address=address;
                p.phone=phone;
            }
        }
    }
    void deletePerson(String n){
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p=(PersonInfo) persons.get(i);
            if(n.equals(p.name)){
                persons.remove(i);
            }
        }
    }
    void displayPersons(){
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p=(PersonInfo) persons.get(i);
            p.display();
        }
    }
    void savePersons(){
        try {
            PersonInfo p;
            String line;
            FileWriter fw =new FileWriter("persons.txt");
            PrintWriter pw =new PrintWriter(fw);
            for (int i = 0; i < persons.size(); i++) {
                p=(PersonInfo) persons.get(i);
                line=p.name+","+p.address+","+p.phone;
                pw.println(line);
            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx);
        }
    }
    void loadPersons(){
        String token[]=null;
        String name, add, ph;
        try {
            FileReader fr = new FileReader( "persons.txt");
            BufferedReader br= new BufferedReader(fr);
            String line=br.readLine();
            while(line!=null){
                token=line.split(",");
                name=token[0];
                add=token[1];
                ph=token[2];
                PersonInfo p=new PersonInfo(name, add, ph);
                persons.add(p);
                line=br.readLine();
            }
            br.close();
            fr.close();
        }
        catch(IOException ioEx){
            System.out.println(ioEx);
        }
    }
}
public class Test{
    public static void main(String[] args) {
        AddressBook ab=new AddressBook();
        String input,s;
        int ch;
        while(true){
            input=JOptionPane.showInputDialog("Enter 1 to Add\nEnter 2 to Search\nEnter 3 to Display all Contacts\nEnter 4 to Update\nEnter 5 to Delete\nEnter 6 to Exit");
            ch=Integer.parseInt(input);
            switch(ch){
                case 1:
                    ab.addPerson();
                    break;
                case 2:
                    s=JOptionPane.showInputDialog("Enter the name: ");
                    ab.searchPerson(s);
                    break;
                case 3:
                    ab.displayPersons();
                    break;
                case 4:
                    s=JOptionPane.showInputDialog("Enter the name: ");
                    ab.updatePerson(s);
                    break;
                case 5:
                    s=JOptionPane.showInputDialog("Enter the name: ");
                    ab.deletePerson(s);
                    break;
                case 6:
                    ab.savePersons();
                    System.exit(0);
            }
        }
    }
}