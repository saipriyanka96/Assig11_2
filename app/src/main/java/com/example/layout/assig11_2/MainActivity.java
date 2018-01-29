package com.example.layout.assig11_2;
//Package objects contain version information about the implementation and specification of a Java package

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //here i have created main class
//public keyword is used in the declaration of a class,method or field;public classes,method and fields can be accessed by the members of any class.
//extends is for extending a class. implements is for implementing an interface
//AppCompatActivity is a class from e v7 appcompat library. This is a compatibility library that back ports some features of recent versions of
// Android to older devices.
    AutoCompleteTextView autoCompleteTextView;
    //An editable text view that shows completion suggestions automatically while the user is typing
    TextView textView;
    //A user interface element that displays text to the user.
    ArrayList<String> productname;
//ArrayList is a part of collection framework and It provides us dynamic arrays in Java.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Variables, methods, and constructors, which are declared protected in a superclass can be accessed only by the subclasses
        // in other package or any class within the package of the protected members class.
        //void is a Java keyword.  Used at method declaration and definition to specify that the method does not return any type,
        // the method returns void.
        //onCreate Called when the activity is first created. This is where you should do all of your normal static set up: create views,
        // bind data to lists, etc. This method also provides you with a Bundle containing the activity's previously frozen state,
        // if there was one.Always followed by onStart().
        //Bundle is most often used for passing data through various Activities.
// This callback is called only when there is a saved instance previously saved using onSaveInstanceState().
// We restore some state in onCreate() while we can optionally restore other state here, possibly usable after onStart() has
// completed.The savedInstanceState Bundle is same as the one used in onCreate().

        super.onCreate(savedInstanceState);
// call the super class onCreate to complete the creation of activity like the view hierarchy
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //  main is the xml you have created under res->layout->main.xml
        //  Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        // The other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        // the design
        textView=(TextView)findViewById(R.id.textView);
        //created an object and instantiated it
        productname=new ArrayList<>();
        //creating new array list
        productname.add("Hp Inkjet Printer");
        //adding the values to the array list
        productname.add("Googel Pixel");
        productname.add("Apple Mac Book");
        MyHelper myHelper=new MyHelper(this);
        //create the database object
        //this database helper will help us to maintain the database and helper will take the values from the main activity
        for(int i=0;i<productname.size();i++)
        {
            myHelper.Addproducts(productname.get(i));//here we will get the products and add to the database
        }
        ArrayList arrayList=myHelper.Databasetoarray();
        //creating an arraylist object and converting the database to array using myhelper
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        //created an objects
        //Finds a view that was identified by the android:id XML attribute that was processed in onCreate(Bundle).
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        autoCompleteTextView.setThreshold(1);
        //Specifies the minimum number of characters the user has to type in the edit box before the drop down list is shown.
        //When threshold is less than or equals 0, a threshold of 1 is applied.
        autoCompleteTextView.setAdapter(arrayAdapter);
        //Sets the adapter that provides the data and the views to represent the data in this widget
    }

}
