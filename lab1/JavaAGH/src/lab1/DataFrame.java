package lab1;

import java.util.ArrayList;

public class DataFrame {

    String names[];
    String types[];

    ArrayList<Column> cols = new ArrayList<Column>();
    int howManyCols;
    int howManyRows;


    // CONSTRUCTOR
    DataFrame(String namesArray[], String typesArray[]) {
        names = namesArray;
        types = typesArray;

        howManyCols = namesArray.length;
        howManyRows = 0;

        for (int i = 0; i < howManyCols; i++) {
            cols.add(new Column(namesArray[i], typesArray[i]));
        }
    }

    DataFrame(Column columns []){
        howManyCols = columns.length;
        howManyRows = columns[0].size;

        String helpNames[]= new String[howManyCols];
        String helpTypes[]= new String[howManyCols];

        int i=0;
        for (Column column : columns) {

            if(column.size!=howManyRows){
                //throw ColumnsAreNotEqual
                System.out.println("columns are not equal");
            }
            cols.add(column); //reference??
            helpNames[i]= column.name;
            helpTypes[i]= column.type;


        }

        names= helpNames;
        types= helpTypes;

    }

    Column get(String colname) {
        for (Column s : cols)
            if (colname.equals(s.name)) {
                return s;

            }

        //throw new Exception("no such column");
        return new Column(); //handled by basic constructor
    }



    DataFrame get(String [] columns, boolean copy){
        Columns toConstructor [] = new Columns[columns.length];
        int i=0,j=0;
        int index;
        for(String name : columns){
            for (Column col : cols) { //stupid loop really
                if (col.name == name){
                    index =j;
                }
                j++;
            }



            if (copy){
                try{

                    Column c=(Column)(cols.get(index)).clone();
                    toConstructor[i] = c;
                }catch(CloneNotSupportedException c){}
            }

            else {
                toConstructor[i] = cols.get(index);
            }

            i++;
        }
        //find columns

        return DataFrame(toConstructor);

    }

    boolean addRow(Object objects []){
        if (objects.length != howManyCols){
            return false;
        }

        for (Column col : cols) {
            for (Object obj : objects) {

                col.addElement(obj);
            }
        }

        howManyRows++;
        return true;


    }

    int size(){
        return howManyRows;
    }

    void copyRowToNew(DataFrame df, int row){
        Object[] objectsOfSelected = new Object[howManyCols];
        int x=0;

        for (Column column: cols){
            objectsOfSelected[x]=column.returnElement(row);

        }

        //handle with if and throw
        df.addRow(objectsOfSelected);
    }


    DataFrame iloc(int from, int to) {
        // if i > howMany Rows
        // throw exception

        DataFrame df = new DataFrame(names, types);
        for (int i=from; i<=to; i++){
            copyRowToNew(df, i);
        }

        return df;

    }



    DataFrame iloc(int i) {
        // if i > howMany Rows
        // throw exception

        DataFrame df = new DataFrame(names, types);
        copyRowToNew(df, i);

        return df;


        // ###### MAKE BASIC DF #############

        /*String[] namesOfSelected = new String[howManyCols];
        String[] typesOfSelected = new String[howManyCols];
        int x=0;

        for (Column column: cols){
            namesOfSelected[x]=column.name;
            typesOfSelected[x]=column.type;
        }*/
    }





}




/*    ArrayList<String> names = new ArrayList<String>();
for (String s: namesArr)
        {
        names.add(s);


        }*/