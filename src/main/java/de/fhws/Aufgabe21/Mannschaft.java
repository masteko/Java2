package de.fhws.Aufgabe21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mannschaft implements Comparable<Mannschaft>
{
  String name;
  int anzahlGespielteSpiele;
  int tore;
  int gegentore;
  int punkte;
  
  public Mannschaft(String name, int anzahlGespielteSpiele, int tore, int gegentore, int punkte)
  {
    this.name = name;
    this.anzahlGespielteSpiele = anzahlGespielteSpiele;
    this.tore = tore;
    this.gegentore = gegentore;
    this.punkte = punkte;
  }
  
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + anzahlGespielteSpiele;
    result = prime * result + gegentore;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + punkte;
    result = prime * result + tore;
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Mannschaft other = (Mannschaft) obj;
    if (anzahlGespielteSpiele != other.anzahlGespielteSpiele) return false;
    if (gegentore != other.gegentore) return false;
    if (name == null)
    {
      if (other.name != null) return false;
    }
    else if (!name.equals(other.name)) return false;
    if (punkte != other.punkte) return false;
    if (tore != other.tore) return false;
    return true;
  }

  @Override
  public String toString()
  {
    return String.format("%14s %3s %7s %3s", name, anzahlGespielteSpiele, tore + ":" + gegentore, punkte);
  }

  @Override
  public int compareTo(Mannschaft m)
  {
    if (this.punkte < m.punkte) return 1; //wenn Punkte kleiner sind als die von der anderen Mannschaft, kommt this sp�ter in der Liste
    else if (this.punkte > m.punkte) return -1;
    else
    {
      if (this.tore - this.gegentore < m.tore - m.gegentore) return 1;
      else if (this.tore - this.gegentore > m.tore - m.gegentore) return -1;
    }
    //return 0;
    return this.name.compareTo(m.name);
  }
  
  public static List<Mannschaft> createTabelle()
  {
    List<Mannschaft> tabelle = new ArrayList<Mannschaft>(18);
    tabelle.add(new Mannschaft("Bay.M�nchen", 32, 75, 15, 82));
    tabelle.add(new Mannschaft("Bor.Dortmund", 32, 52, 36, 77));
    tabelle.add(new Mannschaft("B.Leverkusen", 32, 80, 31, 57));
    tabelle.add(new Mannschaft("B.M'gladbach", 32, 64, 49, 49));
    tabelle.add(new Mannschaft("Hertha BSC", 32, 41, 40, 49));
    tabelle.add(new Mannschaft("FC Schalke 04", 32, 46, 47, 48));
    tabelle.add(new Mannschaft("FSV Mainz 05", 32, 43, 41, 46));
    tabelle.add(new Mannschaft("1.FC K�ln", 32, 36, 40, 41));
    tabelle.add(new Mannschaft("FC Ingolstadt", 32, 30, 37, 40));
    tabelle.add(new Mannschaft("VfL Wolfsburg", 32, 43, 48, 39));
    tabelle.add(new Mannschaft("Hamburger SV", 32, 37, 44, 38));
    tabelle.add(new Mannschaft("FC Augsburg", 32, 40, 48, 37));
    tabelle.add(new Mannschaft("Hoffenheim", 32, 38, 49, 37));
    tabelle.add(new Mannschaft("Darmstadt 98", 32, 36, 50, 35));
    tabelle.add(new Mannschaft("Werder Bremen", 32, 49, 65, 34));
    tabelle.add(new Mannschaft("VfB Stuttgart", 32, 48, 69, 33));
    tabelle.add(new Mannschaft("Ein.Frankfurt", 32, 33, 51, 33));
    tabelle.add(new Mannschaft("Hannover 96", 32, 29, 59, 22));

    Collections.sort(tabelle);
    return tabelle;
  }
}
