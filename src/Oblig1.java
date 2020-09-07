import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    /*
       Nar blir det flest ombyttinger?
       Det blir flest ombyttinger nar det storste tallet har index 0 i arrayet.

       Nar blir det forrest?
       Det blir forrest nar arrayet er sortert i stigende rekkefolge.

       Hvor mange blir det i gjennomsnitt?
       Hvis vi har en tabell med lenge n, skjer byttet i snitt 1/2 + 2/3 + ... (n-1)/n ganger

       Eksempel:
        *    Gitt permutasjonene:
        *    1,2,3(0)
        *    1,3,2(1)
        *    2,1,3(1)
        *    2,3,1(1)
        *    3,1,2(2)
        *    3,2,1(2)
        *    = 7(bytter)/6(permutasjoner) = 1/2 + 2/3 = 1,1667 bytter i snitt.
        *
        * Denne metoden er marginalt darligere enn andre vi har sett pa fordi:
        *
        * Programkode 1.1.4 i kompendiet kjorer 5n-8+3x operasjoner.
        * Denne programkoden kjorer 5n-8+7x operasjoner.

    */
    public static int maks(int[] a) {
        int n = a.length - 1;

        if(n < 0)
            throw new NoSuchElementException("Tabellen er tom!");

        for(int i = 1; i < a.length; i++) {
            if(a[i-1] > a[i]) bytt(a,i-1,i);
        }

        return a[n];
    }

    private static void bytt(int[] a, int v, int h) {
        int temp = a[v];
        a[v] = a[h];
        a[h] = temp;
    }

    public static int ombyttinger(int[] a) {
        int n = a.length - 1;

        if(n < 0)
            throw new NoSuchElementException("Tabellen er tom!");

        int antall = 0;

        for(int i = 0; i < n; i++) {
            if(a[i] > a[i+1]) {
                bytt(a,i,i+1);
                antall++;
            }
        }

        return antall;
    }

    public static int antallUlikeSortert(int[] a) {
        int antall = a.length;

        for(int i = 1; i < a.length; i++) {
            if(a[i-1] == a[i]) antall--;
            else if(a[i-1] > a[i]) throw new IllegalStateException("a[" + (i-1) + "] > a[" + i + "]!");

        }

        return antall;
    }

    public static int antallUlikeUsortert(int[] a) {
        int antall = a.length;

        for(int i = 0; i < a.length - 1; i++) {
            int j = i + 1;
            int like = 0;

            while(j < a.length && like == 0)
                if(a[i] == a[j++]) like = 1;

            antall -= like;
        }

        return antall;
    }

    public static void delsortering(int[] a) {
        int v = 0;
        int h = a.length - 1;

        while(v <= h) {

            if((a[v] & 1) == 1) v++;
            else {
                if((a[h] & 1) == 0) h--;
                else bytt(a, v++, h--);
            }
        }

        Arrays.sort(a, 0, v);
        Arrays.sort(a, v, a.length);
    }

    public static void rotasjon(char[] a) {
        if(a.length < 2)
            return;

        int n = a.length - 1;
        char temp = a[n];

        for(int i = n; i >= 1; i--) a[i] = a[i-1];

        a[0] = temp;
    }

    public static String flett(String s, String t) {
        String u = new String();
        int i = 0, j = 0;

        while(i < s.length() && j < t.length())
            u = u + s.charAt(i++) + t.charAt(j++);

        while(i < s.length())
            u = u + s.charAt(i++);

        while(j < t.length())
            u = u + t.charAt(j++);

        return u;
    }


    public static String flett(String... s) {
        String u = new String();
        int n = 0;
        int j = 0;

        while(j < s.length) {
            j = 0;
            for(int i = 0; i < s.length; i++) {
                if(n < s[i].length()) u = u + s[i].charAt(n);
                else j++;
            }
            n++;
        }

        return u;
    }
}
