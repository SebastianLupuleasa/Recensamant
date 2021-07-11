import java.util.*;

public class Main {

    public static void main(String ...args) {

        Persoana ion = new Persoana("Ion", "Ionescu", "6000123");
        Persoana popescu = new Persoana("Ion", "Popescu", "698433");
        Persoana maria = new Persoana("Maria", "Mihaiescu", "1353256");
        Persoana ana = new Persoana("Ana", "Ionescu", "1341213");
        Persoana ion1 = new Persoana("Ion1", "Ionescu1", "60001232");
        Persoana popescu1 = new Persoana("Ion1", "Popescu1", "6984332");
        Persoana maria1 = new Persoana("Maria1", "Mihaiescu1", "13532562");
        Persoana ana1 = new Persoana("Ana1", "Ionescu1", "13412132");

        Adresa strada12 = new Adresa("Strada 12", 2);
        Adresa strada10 = new Adresa("Strada 10", 3);
        Adresa strada11 = new Adresa("Strada 11", 1);

        // nu am putut lasa cu new direct in paranteza pt ca pointerii in adresa erau diferiti si mapu credea ca e o keye diferita

        ion.setAdresa(strada12);
        popescu.setAdresa(strada10);
        maria.setAdresa(strada11);
        ana.setAdresa(strada12);
        ion1.setAdresa(strada10);
        popescu1.setAdresa(strada10);
        maria1.setAdresa(strada12);
        ana1.setAdresa(strada10);

        Map<Adresa, ArrayList<Persoana>> map = new HashMap<Adresa, ArrayList<Persoana>>();
        List<Persoana> persoane = new ArrayList<Persoana>();
        persoane.add(ion);
        persoane.add(popescu);
        persoane.add(maria);
        persoane.add(ana);
        persoane.add(ion1);
        persoane.add(popescu1);
        persoane.add(maria1);
        persoane.add(ana1);

        // adaugare elemente in map

         for (Persoana element : persoane) {
            if (map.get(element.getAdresa()) == null) {
                  map.put(element.getAdresa(), new ArrayList<Persoana>());}

            map.get(element.getAdresa()).add(element);


        }

        // adresa cu cele mai multe persoane

        Adresa maxim = new Adresa();
        int marime = 0;

        for (Adresa i : map.keySet()) {
            if(map.get(i).size()>marime)
          {
              marime=map.get(i).size();
              maxim = i;
          }
        }

        System.out.println("Adresa cu cei mai multi locatari este "+ maxim.getStrada() + " Bloc: "+maxim.getBloc() + " avand "+marime+ " locatari!");

        // numarul adreselor cu mai mult de o persoana

        marime =0;

        for (Adresa i : map.keySet()) {
            if(map.get(i).size()>1)
            {
                marime++;
            }
        }

        System.out.println("Sunt "+ marime + " adrese cu mai mult de 1 persoana!");

        // adresa unei persoane dupa nume

        Scanner scan = new Scanner(System.in);

        String cautatNume = scan.next();
        String cautatPrenume = scan.next();

        for(Adresa i : map.keySet()) {
           for(int j=0;j<map.get(i).size();j++)
               if(map.get(i).get(j).getNume().equals(cautatNume) && map.get(i).get(j).getPrenume().equals(cautatPrenume))
               {System.out.println(map.get(i).get(j).getNume()+" "+map.get(i).get(j).getPrenume()+" locuieste la adresa: "+i.getStrada()+" , Bloc: "+i.getBloc());
               break;
               }}

}}
