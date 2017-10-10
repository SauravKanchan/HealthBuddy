package com.example.naveenchandra.healthybuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;

public class Diaognise extends AppCompatActivity {
    private static final String TAG = "Diaognise";
    public static final int LIMIT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaognise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String[] strings = {
                "Abdominal Cramps",
                "Abdominal Pain",
                "Aching Muscles, Especially In Your Back, Arms And Legs",
                "Belly Pain",
                "Bloating",
                "Blood In The Stool",
                "Chest Pain",
                "Chest Pain, Or Pain With Breathing Or Coughing",
                "Chills",
                "Colic, Or Cramping And Excessive Crying In Infants",
                "Conjunctivitis",
                "Coughing That Lasts Three Or More Weeks",
                "Coughing Up Blood",
                "Dark Urine",
                "Diarrhea With Blood Or Mucus",
                "Distended Abdomen",
                "Dry Mucous Membranes, Including The Inside Of The Mouth, Throat, Nose, And Eyelids",
                "Dry, Persistent Cough",
                "Fatigue And Weakness",
                "Fatigue",
                "Feeling Sick To Your Stomach Or Vomiting",
                "Feeling Very Tired",
                "Fever",
                "Headache",
                "Intestinal Cramps",
                "Irritation And Redness Of The Eyes",
                "Itchiness",
                "Itchy Rash",
                "Jaundice",
                "Joint, Muscle And Back Pain",
                "Loose, Watery Stools",
                "Loss Of Appetite",
                "Loss Of Skin Elasticity (The Ability To Return To Original Position Quickly If Pinched)",
                "Low Blood Pressure",
                "Mild Fever",
                "Muscle Cramps",
                "Muscle Pain, Particularly Affecting The Muscles In The Calves And Lower Back",
                "Nasal Congestion",
                "Nausea",
                "Night Sweats",
                "Normally Starting At The Head And Spreading Down The Body",
                "Not Wanting To Eat",
                "Pain Or Tenderness In The Area Of The Liver (Below The Ribs On The Right Side)",
                "Paler Than Usual Stools",
                "Pruritis",
                "Rapid Heart Rate",
                "Shortness Of Breath",
                "Sore Throat",
                "Stomach Pain",
                "Stools",
                "Sudden Headaches",
                "Sweats",
                "Swollen Ankles, Feet Or Hands",
                "Symptoms Of Meningitis Or Encephalitis, Such As Headaches, Vomiting And Seizures",
                "Tan-Colored Bowel Movements",
                "Thirst",
                "Unintentional Weight Loss",
                "Urgent Need To Have A Bowel Movement",
                "Vomiting",
                "Weakness",
                "Weight Loss",
                "Yellow Tinge To The Skin And The Whites Of The Eyes",
                "Yellowish Eyes And Skin"
        };

        final MultiSelectSpinner mySpin = (MultiSelectSpinner) findViewById(R.id.my_spin);
        mySpin.setItems(strings);

// ...


        final Button submit = (Button) findViewById(R.id.btnSubmit);
        final TreeMap<String, Integer> myMap = new TreeMap<String, Integer>();

        final Map<String, Integer> newMap = new TreeMap(Collections.reverseOrder());


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean ALL_CLEAR = true;
                boolean SYMPTOMS = false;

                List<String> selected = mySpin.getSelectedStrings();
                DiseasesData dataClass = new DiseasesData();
                Map<String, String[]> data = dataClass.getDiseases();
//                Arrays.asList();
                int i = 0;
                int count;
                boolean flag;
                TextView display = (TextView) findViewById(R.id.displayComments);
                TextView comments = (TextView) findViewById(R.id.displayDiseases);
                display.setText("");
                comments.setText("Disclaimer");

                for (Map.Entry<String, String[]> m : data.entrySet()) {
                    count = 0;
                    for (String str : selected) {
                        flag = false;
                        for (String symp : m.getValue()) {
                            if (symp.toLowerCase().equalsIgnoreCase(str.toLowerCase())) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            count++;
                        }
                    }
                    myMap.put(m.getKey(), count);
                    i++;
                }

                newMap.putAll(myMap);
                int c = 0;
                String danger[] = {"Blood In The Stool",
                        "Coughing That Lasts Three Or More Weeks",
                        "Coughing Up Blood",
                        "Diarrhea With Blood Or Mucus",
                        "Dry, Persistent Cough",
                        "Intestinal Cramps",
                        "Jaundice",
                        "Loss Of Appetite",
                        "Low Blood Pressure",
                        "Nausea",
                        "Pain Or Tenderness In The Area Of The Liver (Below The Ribs On The Right Side)",
                        "Rapid Heart Rate",
                        "Shortness Of Breath",
                        "Swollen Ankles, Feet Or Hands ",
                        "Unintentional Weight Loss"};

                for (TreeMap.Entry<String, Integer> m : newMap.entrySet()) {
                    if (m.getValue() > LIMIT && c < 3) {
                        display.append(m.getKey() + "\n");
                        c++;
                        ALL_CLEAR = false;
                    }

                }
                for (String str : danger) {
                    for (String slct : selected) {
                        Log.d(TAG, slct.toLowerCase()+"0090"+str.toLowerCase());
                        if(slct.toLowerCase()==str.toLowerCase()){
                            Log.d(TAG, "0090true");
                        }
                        else{
                            Log.d(TAG, "0090false");
                        }
                        if (str.toLowerCase().equalsIgnoreCase(slct.toLowerCase())) {
                            SYMPTOMS=true;
                            break;

                        }
                    }
                    if (SYMPTOMS) {
                        break;
                    }
                }
                if (ALL_CLEAR&&!SYMPTOMS) {
                    display.append("No disease detected");
                    comments.append("\nThe symptoms don't match any known diseases but is advised to consult your doctor if it prevails");
                    comments.setTextColor(BLUE);
                } 
                if(SYMPTOMS){
                    comments.append("\nYour symptoms are severe.You should visit your nerby doctor");
                    comments.setTextColor(BLUE);}
                
                if(!ALL_CLEAR) {
                    comments.append("\nThe predictions made by this app are generated through algorithms,therfore you are strictly " +
                            "requested to consult your doctor before any further consult or medicene");
                    comments.setTextColor(RED);
                }

            }
        });


    }
}
