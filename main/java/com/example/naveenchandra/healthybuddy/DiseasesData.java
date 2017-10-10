package com.example.naveenchandra.healthybuddy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NAVEENCHANDRA on 26-03-2017.
 */

public class DiseasesData {
    public static Map<String,String[]> Diseases = new HashMap<String, String[]>();

    public DiseasesData() {

        String symptoms[] = {"shaking chills that can range from moderate to severe",
                "high fever",
                "profuse sweating",
                "headache",
                "nausea",
                "vomiting",
                "diarrhea",
                "anemia",
                "muscle pain",
                "convulsions",
                "coma",
                "bloody stools"};
        Diseases.put("Malaria", symptoms);

        String a[] = {"Fever that starts low and increases daily, possibly reaching as high as 104.9 F (40.5 C)",
                "Headache",
                "Weakness and fatigue",
                "Muscle aches",
                "Sweating",
                "Dry cough",
                "Loss of appetite and weight loss",
                "Abdominal pain",
                "Diarrhea or constipation",
                "Rash",
                "Extremely swollen abdomen"};
        Diseases.put("Typhoid ", a);


        String b[] = {"Fatigue",
                "Nausea",
                "vomiting",
                "Abdominal pain",
                "especially in the area of your liver on your right side beneath your lower ribs",
                "Clay colored bowel movements",
                "Loss of appetite",
                "Low fever",
                "Dark urine",
                "Joint pain",
                "Yellowing of the skin and eyes",
                "jaundice",
                "Yellow tinge to the skin and the whites of the eyes",
                "normally starting at the head and spreading down the body",
                "Pruritis",
                "itchiness",
                "Fatigue",
                "Abdominal pain",
                "Weight loss",
                "Vomiting",
                "Fever",
                "Paler than usual stools"};
        Diseases.put("Hepatitis A", b);


        String c[] = {"Feeling very tired",
                "Mild fever",
                "Headache",
                "Not wanting to eat",
                "Feeling sick to your stomach or vomiting",
                "Belly pain",
                "Tan-colored bowel movements",
                "stools",
                "Dark urine",
                "Yellowish eyes and skin",
                "jaundice",
                "Yellow tinge to the skin and the whites of the eyes",
                "normally starting at the head and spreading down the body",
                "Pruritis",
                "itchiness",
                "Fatigue",
                "Abdominal pain",
                "Weight loss",
                "Vomiting",
                "Fever",
                "Paler than usual stools"};
        Diseases.put("Hepatitis B", c);


        String d[] = {
                "Jaundice",
                "Stomach pain",
                "Loss of appetite",
                "Nausea",
                "Fatigue",
                "Yellow tinge to the skin and the whites of the eyes",
                "normally starting at the head and spreading down the body",
                "Pruritis",
                "itchiness",
                "Fatigue",
                "Abdominal pain",
                "Weight loss",
                "Vomiting",
                "Fever",
                "Paler than usual stools"};
        Diseases.put("Hepatitis B", d);


        String e[] = {
                "Jaundice",
                "Yellow tinge to the skin and the whites of the eyes",
                "normally starting at the head and spreading down the body",
                "Pruritis",
                "itchiness",
                "Fatigue",
                "Abdominal pain",
                "Weight loss",
                "Vomiting",
                "Fever",
                "Paler than usual stools"
        };
        Diseases.put("Jaundice", e);

        String f[] = {
                "fever",
                "chills",
                "sudden headaches",
                "nausea",
                "vomiting",
                "loss of appetite",
                "muscle pain, particularly affecting the muscles in the calves and lower back",
                "conjunctivitis",
                "irritation and redness of the eyes",

                "swollen ankles, feet or hands",
                "chest pain",
                "symptoms of meningitis or encephalitis, such as headaches, vomiting and seizures",
                "shortness of breath",
                "coughing up blood"
        };
        Diseases.put("Leptospirosis ", f);


        String g[] = {
                "Loose, watery stools",
                "Abdominal cramps",
                "Abdominal pain",
                "Fever",
                "Blood in the stool",
                "Bloating",
                "Nausea",
                "Urgent need to have a bowel movement"
        };
        Diseases.put("Diarrhoeal", g);

        String h[] = {"diarrhea with blood or mucus",
                "abdominal pain",
                "fever",
                "distended abdomen",
                "pain or tenderness in the area of the liver (below the ribs on the right side)"
        };
        Diseases.put("Amoebiasis", h);

        String i[] = {" Rapid heart rate",
                "Loss of skin elasticity (the ability to return to original position quickly if pinched)",
                "Dry mucous membranes, including the inside of the mouth, throat, nose, and eyelids",
                "Low blood pressure",
                "Thirst",
                "Muscle cramps"
        };
        Diseases.put("Cholera", i);

        String k[] = {"Fever",
                "Chills",
                "Loss of appetite",
                "Sweats",
                "Weakness",
                "Fatigue",
                "Joint, muscle and back pain",
                "Headache"
        };
        Diseases.put("Brucellosis", k);

        String l[] = {"abdominal pain",
                "colic, or cramping and excessive crying in infants",
                "intestinal cramps",
                "nausea",
                "a fever",
                "blood in the stool",
                "a loss of appetite",
                "itchy rash"
        };
        Diseases.put("Hookworm Infection", l);

        String m[] = {
                "Fever",
                "Aching muscles, especially in your back, arms and legs",
                "Chills",
                "sweats",
                "Headache",
                "Dry, persistent cough",
                "Fatigue and weakness",
                "Nasal congestion",
                "Sore throat"
        };
        Diseases.put("Influenza", m);

        String n[] = {
                "Coughing that lasts three or more weeks",
                "Coughing up blood",
                "Chest pain, or pain with breathing or coughing",
                "Unintentional weight loss",
                "Fatigue",
                "Fever",
                "Night sweats",
                "Chills",
                "Loss of appetite"
        };
        Diseases.put("Tuberculosis", n);

    }

    public static Map<String, String[]> getDiseases() {
        return Diseases;
    }
}
