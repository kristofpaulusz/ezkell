/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PauluszKristófCsanád
 */
public class Konyv implements Serializable {
    private String cim;
    private ArrayList<String> szerzo = new ArrayList<>();
    private int kiadas_eve;

    public Konyv(String cim, int kiadas_eve) {
        this.cim = cim;
        this.kiadas_eve = kiadas_eve;
    }
    public Konyv(String cim, String szerzo, int kiadas_eve) {
        this.cim = cim;
        this.kiadas_eve = kiadas_eve;
        this.szerzo.add(szerzo);
    }
    public Konyv(String cim, String[] szerzok, int kiadas_eve) {
        this.cim = cim;
        this.kiadas_eve = kiadas_eve;
        szerzo.add(szerzok[0]);
        setMasodikSzerzo(szerzok[1]);
    }

    public String getCim() {
        return cim;
    }

    public ArrayList<String> getSzerzo() {
        return szerzo;
    }

    public int getKiadas_eve() {
        return kiadas_eve;
    }
    public void setMasodikSzerzo(String masodikSzerzo) {
        if (szerzo.size() < 2) {
            szerzo.add(masodikSzerzo);
        }
 
    }
}
