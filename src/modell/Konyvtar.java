/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PauluszKristófCsanád
 */
public class Konyvtar implements Serializable {
    private ArrayList<Konyv> konyvek = new ArrayList<>();

    public Konyvtar() {
        Konyv k1 = new Konyv("A Gyűrük Ura", "J.R.R Tolkien", 1954);
        Konyv k2 = new Konyv("Harry Potter", "Rowling", 1991);
        addKonyv(k1);
        addKonyv(k2);
    }

    public Konyvtar(ArrayList<Konyv> beolvasas) {
        konyvek = beolvasas;
    }

    public ArrayList<Konyv> getKonyvek() {
        return konyvek;
    }

    public void addKonyv(Konyv konyv) {
        boolean ujKonyv = true;
        int index = 0;
        while (ujKonyv && index < konyvek.size()) {
            if (konyvek.get(index).getCim().equals(konyv.getCim())) {
                ujKonyv = false;
            }
            index += 1;
        }
        if (ujKonyv) konyvek.add(konyv);
    }

    public void mentes() {
        try {
            FileOutputStream fOuS = new FileOutputStream("konyvtar.bin");
            ObjectOutputStream oOuS = new ObjectOutputStream(fOuS);
            oOuS.writeObject(konyvek);
            oOuS.close();
            fOuS.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Konyvtar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Konyvtar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Konyv> beolvasas() {
        try {
            ObjectInputStream oInS = new ObjectInputStream(new FileInputStream("konyvtar.bin"));
            ArrayList<Konyv> valasz = (ArrayList<Konyv>) oInS.readObject();
            return valasz;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Konyvtar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Konyvtar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Konyvtar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean benneVan(String text) {
        boolean ujKonyv = true;
        int index = 0;
        while (ujKonyv && index < konyvek.size()) {
            if (konyvek.get(index).getCim().equals(text)) {
                ujKonyv = false;
            }
            index += 1;
        }
        return ujKonyv;
    }
    
}
