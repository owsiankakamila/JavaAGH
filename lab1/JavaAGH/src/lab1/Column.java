package lab1;

import java.util.ArrayList;

public class Column implements Cloneable {
    String name;
    String type;
    int size;
    ArrayList<Object> elements = new ArrayList<Object>();
    //albo object

    Column(){
        System.out.println("no column like this");
    }

    Column (String itsName, String itsType){
        name= itsName;
        type= itsType;
        size=0;
        /*try {
            Class T   = Class.forName(itsType);
        } catch (ClassNotFoundException e) {
        }*/

        //nazwa typu jako typ kolumny
    }


    void addElement (Object obj){
        elements.add(obj);
        size++;
    }

    Object returnElement(int index){
        return elements.get(index-1);
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}
