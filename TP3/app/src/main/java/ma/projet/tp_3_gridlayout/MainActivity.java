package ma.projet.tp_3_gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.security.auth.Destroyable;

public class MainActivity extends AppCompatActivity {

    TextView edit;
    public List<String> chiffres = new Vector<>();
    ArrayList<String> operateurs = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.textView);


        operateurs.add("/");
        operateurs.add("*");
        operateurs.add("-");
        operateurs.add("+");

        chiffres.add("0");
        chiffres.add("1");
        chiffres.add("2");
        chiffres.add("3");
        chiffres.add("4");
        chiffres.add("5");
        chiffres.add("6");
        chiffres.add("7");
        chiffres.add("8");
        chiffres.add("9");
        chiffres.add(".");
    }

    public void numberClick(View v) {
        String number = edit.getText().toString();
        Button item = findViewById(v.getId());
        number += item.getText().toString();
        edit.setText(number);
    }


    public void operatorClick(View view) {
        String number = edit.getText().toString();
        Button item = findViewById(view.getId());
        number += item.getText().toString();
        edit.setText(number);

    }

    public static ArrayList splitByOpertors(String string){
        ArrayList<String> inputList = new ArrayList<String>() ;
        String str = "";
        for(int i=0; i<string.length(); i++){
            if(String.valueOf(string.charAt(i)).matches("[/|+|*|-]")){
                inputList.add(str);
                inputList.add(String.valueOf(string.charAt(i)));
                str = "";
                i++;
            }
            str+= string.charAt(i);
        }
        inputList.add(str);
        return inputList;
    }
    public static ArrayList calculateDivision(ArrayList l){
        ArrayList<String> newArrayList = new ArrayList<String>();
        for(int i = 0; i<l.toArray().length; i++){
            if(l.get(i).toString().equals("/")){
                double value = Double.parseDouble(l.get(i - 1).toString()) /  Double.parseDouble(l.get(i + 1).toString());
                newArrayList.remove(newArrayList.size() - 1);
                newArrayList.add(String.valueOf(value));
                i++;
            } else {
                newArrayList.add(l.get(i).toString());
            }
        }
        return newArrayList;
    }
    public static ArrayList calculateMultiplication(ArrayList l){
        ArrayList<String> newArrayList = new ArrayList<String>();
        System.out.println(l);
        for(int i = 0; i<l.toArray().length; i++){
            if(l.get(i).toString().equals("*")){
                double value = Double.parseDouble(l.get(i - 1).toString()) *  Double.parseDouble(l.get(i + 1).toString());
                newArrayList.remove(newArrayList.size() - 1);
                newArrayList.add(String.valueOf(value));
                i++;
            } else {
                newArrayList.add(l.get(i).toString());
            }
        }
        return newArrayList;
    }
    public static ArrayList calculatePlusAndMinus(ArrayList l){
        ArrayList<String> newArrayList = new ArrayList<String>();
        System.out.println(l);
        for(int i = 0; i<l.toArray().length; i++){
            if(i == 0){
                newArrayList.add(l.get(i).toString());
            } else {
                if(l.get(i).toString().equals("+")){

                    double value = Double.parseDouble(newArrayList.get(newArrayList.size() - 1).toString()) +  Double.parseDouble(l.get(i + 1).toString());
                    newArrayList.remove(newArrayList.size() - 1);
                    newArrayList.add(String.valueOf(value));
                    i++;

                }
                else if(l.get(i).toString().equals("-")){
                    double value = Double.parseDouble(newArrayList.get(newArrayList.size() - 1).toString()) -  Double.parseDouble(l.get(i + 1).toString());
                    newArrayList.remove(newArrayList.size() - 1);
                    newArrayList.add(String.valueOf(value));
                    i++;

                }
                else {
                    newArrayList.add(l.get(i).toString());
                }
            }

        }
        return newArrayList;
    }

    public void equal(View v){
        String input = edit.getText().toString();
        ArrayList<String> inputList = splitByOpertors(input);
        String finalres = calculatePlusAndMinus(calculateMultiplication(calculateDivision(inputList))).get(0).toString();
        edit.setText(finalres);
    }


    public  void  clear(View v ){
        edit.setText("");
    }

}
