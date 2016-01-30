/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.moj.xmlschemat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pl.moj.xmlschemat.Płyta.Gatunek;
import pl.moj.xmlschemat.Płyta.WydawcaPłyty;

/**
 *
 * @author Przemyslaw Swiderski, Damian Deska
 */
public class DataModel
{

    public static TableModel getWykonawcyTableModel()
    {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        List resultList = GUI.płytoteka.wykonawcy.wykonawca;
        tableHeaders.add("Id");
        tableHeaders.add("Imie");
        tableHeaders.add("Nazwisko");
        for (Object o : resultList)
        {
            Wykonawca w = (Wykonawca) o;
            Vector<Object> oneRow = new Vector<Object>();

            oneRow.add(w.wykonawcaID);
            oneRow.add(w.imie);
            oneRow.add(w.nazwisko);

            tableData.add(oneRow);
        }
        return (new DefaultTableModel(tableData, tableHeaders));
    }

    public static TableModel getWydawcyTableModel()
    {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        List resultList = GUI.płytoteka.wydawcy.wydawca;
        tableHeaders.add("Id");
        tableHeaders.add("Nazwa");
        tableHeaders.add("Państwo");
        tableHeaders.add("Data Założenia");
        tableHeaders.add("Kontakt");
        for (Object o : resultList)
        {
            Wydawca wyd = (Wydawca) o;
            Vector<Object> oneRow = new Vector<Object>();

            oneRow.add(wyd.wydawcaID);
            oneRow.add(wyd.nazwa);
            oneRow.add(wyd.państwo);
            oneRow.add(wyd.dataZałożenia.dzień + "-" + wyd.dataZałożenia.miesiąc + "-" + wyd.dataZałożenia.rok);
            if (wyd.telefon == null)
            {
                oneRow.add(wyd.adresEmail);
            }
            if (wyd.adresEmail == null)
            {
                oneRow.add(wyd.telefon);
            }

            oneRow.add(wyd.telefon);

            tableData.add(oneRow);
        }
        return (new DefaultTableModel(tableData, tableHeaders));
    }

    public static TableModel getPłytyTableModel()
    {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        List resultList = GUI.płytoteka.katalogPłyt.płyta;
        tableHeaders.add("Id");
        tableHeaders.add("Polska");
        tableHeaders.add("inniWykonawcyIDS");
        tableHeaders.add("Tytuł");
        tableHeaders.add("Artysta");
        tableHeaders.add("Cena");
        tableHeaders.add("DataWydania");
        tableHeaders.add("WydawcaPłyty");
        tableHeaders.add("Gatunek");

        getWydawcyTableModel();

        for (Object o : resultList)
        {
            Płyta p = (Płyta) o;
            Vector<Object> oneRow = new Vector<Object>();

            oneRow.add(p.płytaID);
            oneRow.add(p.polska);
            StringBuilder tmpstr = new StringBuilder();
            if (p.inniWykonawcyIDS != null)
            {
                for (Wykonawca wyk : GUI.płytoteka.wykonawcy.wykonawca)
                {
                    for (Object obj : p.inniWykonawcyIDS)
                    {
                        if (wyk.equals(obj))
                        {
                            tmpstr.append(wyk.nazwisko);
                            tmpstr.append(" ");
                        }
                    }
                }
                oneRow.add(tmpstr.toString());
            } else
            {
                oneRow.add(" ");
            }
            oneRow.add(p.tytuł.replaceAll(" ", ""));
            oneRow.add(p.artysta.replaceAll(" ", ""));
            oneRow.add(p.cena.value + " " + p.cena.waluta.value());
            oneRow.add(p.dataWydania.dzień + "-" + p.dataWydania.miesiąc + "-" + p.dataWydania.rok);
            for (Wydawca wyd : GUI.płytoteka.wydawcy.wydawca)
            {
                if (wyd.getWydawcaID().equals(p.wydawcaPłyty.wydawcaID))
                {
                    oneRow.add(wyd.getNazwa());
                }
            }
            oneRow.add(p.gatunek.nazwa);

            tableData.add(oneRow);
        }
        return (new DefaultTableModel(tableData, tableHeaders));
    }

    public static void dodajWykonawce(String imie, String nazwisko)
    {
        String tmpWykonawcaID;
        Integer leng = (GUI.płytoteka.wykonawcy.wykonawca.get(GUI.płytoteka.wykonawcy.wykonawca.size() - 1).getWykonawcaID()).length();
        tmpWykonawcaID = (GUI.płytoteka.wykonawcy.wykonawca.get(GUI.płytoteka.wykonawcy.wykonawca.size() - 1).getWykonawcaID()).substring(3, leng);

        int tmpWykonawcaIDNumber = Integer.parseInt(tmpWykonawcaID);
        tmpWykonawcaIDNumber++;
        String newWykonawcaID = "wyk" + String.valueOf(tmpWykonawcaIDNumber);
        Wykonawca w = new Wykonawca();
        w.setImie(imie);
        w.setNazwisko(nazwisko);
        w.setWykonawcaID(newWykonawcaID);
        GUI.płytoteka.wykonawcy.wykonawca.add(w);
    }

    public static void dodajWydawce(String nazwa, String państwo, String dzień, String miesiac, String rok, String telefon, String adresMail)
    {
        Wydawca w = new Wydawca();
        String tmpWydawcaID;
        Integer leng = (GUI.płytoteka.wydawcy.wydawca.get(GUI.płytoteka.wydawcy.wydawca.size() - 1).getWydawcaID()).length();
        tmpWydawcaID = (GUI.płytoteka.wydawcy.wydawca.get(GUI.płytoteka.wydawcy.wydawca.size() - 1).getWydawcaID()).substring(1, leng);

        int tmpWydawcaIDNumber = Integer.parseInt(tmpWydawcaID);
        tmpWydawcaIDNumber++;
        String newWydawcaID = "w" + String.valueOf(tmpWydawcaIDNumber);
        w.setWydawcaID(newWydawcaID);
        w.setNazwa(nazwa);
        w.setPaństwo(państwo);
        DataZałożenia d = new DataZałożenia();
        d.setDzień(Integer.parseInt(dzień));
        d.setMiesiąc(Integer.parseInt(miesiac));
        d.setRok(Integer.parseInt(rok));
        w.setDataZałożenia(d);
        if (w.adresEmail == null)
        {
            w.setTelefon(telefon);
        }
        if (w.telefon == null)
        {
            w.setAdresEmail(adresMail);
        }
        GUI.płytoteka.wydawcy.wydawca.add(w);
    }

    public static void dodajPłyte(Boolean czyPolska, String inniWykonawcy, String tytuł, String artysta, String cena, String waluta, String dzień, String miesiac, String rok, String liczbaSztuk, String wydawca, String gatunek)
    {
        Płyta p = new Płyta();
        String tmpPlytaID;
        Integer leng = (GUI.płytoteka.katalogPłyt.płyta.get(GUI.płytoteka.katalogPłyt.płyta.size() - 1).getPłytaID()).length();
        tmpPlytaID = (GUI.płytoteka.katalogPłyt.płyta.get(GUI.płytoteka.katalogPłyt.płyta.size() - 1).getPłytaID()).substring(1, leng);

        int tmpPlytaIDNumber = Integer.parseInt(tmpPlytaID);
        tmpPlytaIDNumber++;
        String newPlytaID = "p" + String.valueOf(tmpPlytaIDNumber);
        p.setPłytaID(newPlytaID);
        if (czyPolska)
        {
            p.setPolska("tak");
        }
        if (inniWykonawcy != "")
        {
            String[] parts = inniWykonawcy.split(" ");

            for (Wykonawca wyk : GUI.płytoteka.wykonawcy.wykonawca)
            {
                for (String s : parts)
                {
                    if (wyk.getWykonawcaID().equals(s))
                    {
                        if (p.inniWykonawcyIDS == null)
                        {
                            p.inniWykonawcyIDS = new ArrayList<Object>();
                            p.inniWykonawcyIDS.add(wyk);
                        } else
                        {
                            p.inniWykonawcyIDS.add(wyk);
                        }
                    }
                }
            }
        }
        p.setTytuł(tytuł);
        p.setArtysta(artysta);
        Cena c = new Cena();
        c.value = new BigDecimal(cena);
        if (waluta == "złotych")
        {
            c.setWaluta(Waluta.ZŁOTYCH);
        }

        if (waluta == "euro")
        {
            c.setWaluta(Waluta.EURO);
        }

        if (waluta == "dolarów")
        {
            c.setWaluta(Waluta.DOLARÓW);
        }

        p.setCena(c);

        DataWydania d = new DataWydania();
        d.setDzień(Integer.parseInt(dzień));
        d.setMiesiąc(Integer.parseInt(miesiac));
        d.setRok(Integer.parseInt(rok));

        p.setDataWydania(d);

        p.setLiczbaSztuk(liczbaSztuk);
        WydawcaPłyty w = new WydawcaPłyty();
        w.setWydawcaID(wydawca);
        p.setWydawcaPłyty(w);

        Gatunek g = new Gatunek();
        g.setNazwa(gatunek);
        p.setGatunek(g);

        GUI.płytoteka.katalogPłyt.płyta.add(p);
    }

    public static DefaultComboBoxModel getWydawcyComboBoxModel()
    {
        List<String> labels = new ArrayList<String>();
        List<Wydawca> resultList = GUI.płytoteka.wydawcy.wydawca;
        for (Wydawca s : resultList)
        {
            labels.add(s.nazwa);
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(labels.toArray());
        return model;

    }
}
