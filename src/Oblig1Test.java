import static org.junit.jupiter.api.Assertions.*;

////// Testprogram for Oblig 1 ////////////////////////


import java.util.*;


public class Oblig1Test {

    ///// Oppgave 1 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave1() {
        int antallFeil = 0;

        boolean unntak = false;
        int[] tom = {};
        try {
            Oblig1.maks(tom);  // kaller maks-metoden
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException)) {
                System.out.println("Opgave 1: a) Feil unntak for en tom tabell!");
                antallFeil++;
            }
        }

        if (!unntak) {
            System.out.println("Opgave 1: b) Kast unntak for en tom tabell!");
            antallFeil++;
        }

        int[] a = {3};
        int[] b = {5, 2, 8, 4, 7, 6};
        int[] c = {5, 4, 3, 2, 1};
        int[] d = {1, 2, 3, 4, 5};
        if (Oblig1.maks(a) != 3 || Oblig1.maks(b) != 8 ||
                Oblig1.maks(c) != 5 || Oblig1.maks(d) != 5) {
            System.out.println("Oppgave 1: c) Maks-metoden: Feil resultat!");
            antallFeil++;
        }

        int[] e = {1, 4, 3, 7, 6, 5, 10, 2, 9, 8};
        int[] f = {1, 3, 4, 6, 5, 7, 2, 9, 8, 10};

        Oblig1.maks(e);
        if (!Arrays.equals(e, f)) {
            System.out.println("Oppgave 1: d) Maks-metoden: feil i ombyttingene!");
            antallFeil++;
        }

        a = new int[]{6, 5, 4, 3, 2, 1};
        b = new int[]{1, 2, 3, 4, 5};
        c = new int[]{4, 9, 3, 6, 1, 5, 7, 8, 10, 2};
        d = new int[]{2, 5, 8, 4, 3, 10, 1, 7, 6, 9};

        if (Oblig1.ombyttinger(a) != 5 || Oblig1.ombyttinger(b) != 0
                || Oblig1.ombyttinger(c) != 7 || Oblig1.ombyttinger(d) != 6) {
            System.out.println("Oppgave 1: e) Feil opptelling i ombyttingsmetoden!");
            antallFeil++;
        }
        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 1");
    }

    ///// Oppgave 2 /////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave2() {
        int antallFeil = 0;

        int[] a = {};
        int[] b = {1};
        int[] c = {1, 2, 3, 4, 5, 4};

        try {
            Oblig1.antallUlikeSortert(a);  // kaller metoden
            Oblig1.antallUlikeSortert(b);  // kaller metoden
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 2: a) Ikke unntak for tabell med 0 eller 1 verdi!");
            antallFeil++;
        }

        boolean unntak = false;

        try {
            Oblig1.antallUlikeSortert(c);  // kaller metoden
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof IllegalStateException)) {
                System.out.println
                        ("Oppgave 2: b) Feil unntak for en usortert tabell!");
                antallFeil++;
            }
        }

        if (!unntak) {
            System.out.println
                    ("Oppgave 2: c) Kast et unntak for en usortert tabell!");
            antallFeil++;
        }

        int[] d = {1, 1};
        int[] e = {1, 2, 3, 4, 5, 6, 7};
        int[] f = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7};

        if (Oblig1.antallUlikeSortert(a) != 0
                || Oblig1.antallUlikeSortert(b) != 1
                || Oblig1.antallUlikeSortert(d) != 1
                || Oblig1.antallUlikeSortert(e) != 7
                || Oblig1.antallUlikeSortert(f) != 7) {
            System.out.println("Oppgave 2: d) Metoden gir feil resultat!");
            antallFeil++;
        }
        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 2");
    }

    ///// Oppgave 3 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave3() {
        int antallFeil = 0;

        int[] a = {};   // skal ikke kaste unntak her!
        int[] b = {1};  // skal ikke kaste unntak her!
        int[] c = {1, 1};
        int[] d = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] dkopi = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] e = {5, 4, 3, 2, 1};
        int[] f = {1, 2, 2, 2, 2, 2, 3};

        try {
            Oblig1.antallUlikeUsortert(a);  // kaller metoden
            Oblig1.antallUlikeUsortert(b);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 3: a) Ikke unntak for tabell med 0 eller 1 verdi!");
            antallFeil++;
        }

        if (Oblig1.antallUlikeUsortert(a) != 0
                || Oblig1.antallUlikeUsortert(b) != 1
                || Oblig1.antallUlikeUsortert(c) != 1
                || Oblig1.antallUlikeUsortert(d) != 6
                || Oblig1.antallUlikeUsortert(e) != 5
                || Oblig1.antallUlikeUsortert(f) != 3) {
            System.out.println("Oppgave 3: b) Metoden gir feil resultat!");
            antallFeil++;
        }

        if (!Arrays.equals(d, dkopi)) {
            System.out.println("Oppgave 3: c) Metoden endrer tabellen!");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 3");
    }

    ///// Oppgave 4 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave4() {
        int antallFeil = 0;

        int[] a = {};   // skal ikke kaste unntak her!

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: a) Ikke unntak for en tom tabell!");
            antallFeil++;
        }

        a = new int[]{5};
        int[] b = {5};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: b) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: c) Metoden gjÃ¸r feil for en tabell en verdi!");
            antallFeil++;
        }

        a = new int[]{4};
        b = new int[]{4};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: d) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: e) Metoden gjÃ¸r feil for en tabell en verdi!");
            antallFeil++;
        }

        a = new int[]{4, 2, 6, 10, 8};
        b = new int[]{2, 4, 6, 8, 10};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: f) Det gÃ¥r galt hvis det kun er partall!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: g) Det blir feil hvis det kun er partall!");
            antallFeil++;
        }

        a = new int[]{9, 5, 3, 1, 7};
        b = new int[]{1, 3, 5, 7, 9};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: h) Det gÃ¥r galt hvis det kun er oddetall!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: i) Det blir feil hvis det kun er oddetall!");
            antallFeil++;
        }

        a = new int[]{1, 2, 3, 4, 5, 6};
        b = new int[]{1, 3, 5, 2, 4, 6};
        boolean flere = true;

        do {
            int[] c = a.clone();
            Oblig1.delsortering(c);

            if (!Arrays.equals(c, b)) {
                System.out.println
                        ("Oppgave 4: j) Gitt tabell:     " + Arrays.toString(a));
                System.out.println
                        ("              Metoden skal gi: " + Arrays.toString(b));
                System.out.println
                        ("              Du fikk:         " + Arrays.toString(c));

                antallFeil++;
                break;
            }
        } while (nestePermutasjon(a));

        a = new int[]{-4, -1, 3, 0, 2, -3, -2, 4, 1};
        b = new int[]{-3, -1, 1, 3, -4, -2, 0, 2, 4};

        try {
            Oblig1.delsortering(a);  // kaller metoden
        } catch (Exception ex) {
            System.out.println
                    ("Oppgave 4: k) Skal ikke kastes unntak her!");
            antallFeil++;
        }

        if (!Arrays.equals(a, b)) {
            System.out.println
                    ("Oppgave 4: l) Metoden gjÃ¸r feil for negative verdier!");
            antallFeil++;
        }

        if (antallFeil == 0) {
            a = randPerm(100000);
            long tid = System.currentTimeMillis();
            Oblig1.delsortering(a);
            tid = System.currentTimeMillis() - tid;

            for (int i = 0; i < 50000; i++) {
                if (a[i] != 2 * i + 1) {
                    System.out.println
                            ("Oppgave 4: m) Feil resultat for denne tabellen!");
                    antallFeil++;
                    break;
                }
            }

            for (int i = 50000; i < 100000; i++) {
                if (a[i] != 2 * (i - 49999)) {
                    System.out.println
                            ("Oppgave 4: n) Feil resultat for denne tabellen!");
                    antallFeil++;
                    break;
                }
            }

            if (tid > 100) {
                System.out.println
                        ("Oppgave 4: o) Tid: " + tid + ". Metoden er for ineffektiv!");
                System.out.println
                        ("              Hint: Bruk en partisjoneringsteknikk!");
                antallFeil++;
            }
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 4");
    }

    ///// Oppgave 5 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave5() {
        int antallFeil = 0;

        char[] a = {};

        try {
            Oblig1.rotasjon(a);  // kaller metoden
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 5: a) Skal ikke kaste unntak for en tom tabell!!");
            antallFeil++;
        }

        char[] b = {'A'};
        char[] b0 = {'A'};
        Oblig1.rotasjon(b);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 5: b) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        char[] c = {'A', 'B'};
        char[] c0 = {'B', 'A'};
        Oblig1.rotasjon(c);
        if (!Arrays.equals(c, c0)) {
            System.out.println("Oppgave 5: c) Feil hvis tabellen har to elementer!");
            antallFeil++;
        }

        char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] d0 = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        Oblig1.rotasjon(d);
        if (!Arrays.equals(d, d0)) {
            System.out.println("Oppgave 5: d) Feil hvis tabellen har flere elementer!");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 5");
    }

    ///// Oppgave 7 //////////////////////////////////////
    @org.junit.jupiter.api.Test
    void oppgave7() {
        int antallFeil = 0;
        String s = null;

        try {
            s = Oblig1.flett("", "");  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println
                    ("Oppgave 7a: a) Skal ikke kaste unntak for to tomme tegnstrenger!!");
            antallFeil++;
        }

        if (s.compareTo("") != 0) {
            System.out.println
                    ("Oppgave 7a: b) Svaret skal bli lik en tom streng!");
            antallFeil++;
        }

        try {
            s = Oblig1.flett("", "AB");  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println
                    ("Oppgave 7a: c) Skal ikke kaste unntak for en tom tegnstreng!!");
            antallFeil++;
        }

        if (s.compareTo("AB") != 0) {
            System.out.println
                    ("Oppgave 7a: d) Svaret skal bli lik AB");
            antallFeil++;
        }

        try {
            s = Oblig1.flett("AB", "");  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println
                    ("Oppgave 7a: e) Skal ikke kaste unntak for en tom tegnstreng!!");
            antallFeil++;
        }

        if (s.compareTo("AB") != 0) {
            System.out.println
                    ("Oppgave 7a: f) Svaret skal bli lik AB");
            antallFeil++;
        }

        s = Oblig1.flett("A", "BCDEF");

        if (s.compareTo("ABCDEF") != 0) {
            System.out.println
                    ("Oppgave 7a: g) Svaret skal bli lik ABCDEF");
            antallFeil++;
        }

        s = Oblig1.flett("ABCDE", "F");

        if (s.compareTo("AFBCDE") != 0) {
            System.out.println
                    ("Oppgave 7a: h) Svaret skal bli lik AFBCDE");
            antallFeil++;
        }

        s = Oblig1.flett("ACEGIK", "BDFHJLMN");

        if (s.compareTo("ABCDEFGHIJKLMN") != 0) {
            System.out.println
                    ("Oppgave 7a: i) Svaret skal bli lik ABCDEFGHIJKLMN");
            antallFeil++;
        }

        String[] a = {};

        try {
            s = Oblig1.flett(a);  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println
                    ("Oppgave 7b: a) Skal ikke kaste unntak for en tom tabell!");
            antallFeil++;
        }

        if (s.compareTo("") != 0) {
            System.out.println
                    ("Oppgave 7b: b) Svaret skal bli lik en tom streng!");
            antallFeil++;
        }

        try {
            s = Oblig1.flett("", "ABC", "");  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println
                    ("Oppgave 7b: c) Skal ikke kaste unntak for en tom streng!");
            antallFeil++;
        }

        if (s.compareTo("ABC") != 0) {
            System.out.println
                    ("Oppgave 7b: d) Svaret skal bli lik ABC");
            antallFeil++;
        }

        s = Oblig1.flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");

        if (s.compareTo("ALGORITMER OG DATASTRUKTURER") != 0) {
            System.out.println
                    ("Oppgave 7b: e) Svaret skal bli ALGORITMER OG DATASTRUKTURER!");
            antallFeil++;
        }

        s = Oblig1.flett("AFK", "BGLP", "CHMQT", "DINRUW", "EJOSVXY");

        if (s.compareTo("ABCDEFGHIJKLMNOPQRSTUVWXY") != 0) {
            System.out.println
                    ("Oppgave 7b: f) Svaret skal bli ABCDEFGHIJKLMNOPQRSTUVWXY!");
            antallFeil++;
        }

        assertEquals(0, antallFeil, "Du har for mange feil i oppgave 7");
    }

    ///// Hjelpemetoder /////////////////////////////

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean nestePermutasjon(int[] a) {
        int n = a.length;
        int i = n - 2;

        while (i >= 0 && a[i] > a[i + 1]) i--;

        if (i < 0) return false;

        int verdi = a[i];
        int j = n - 1;

        while (verdi > a[j]) j--;
        bytt(a, i, j);

        i++;
        j = n - 1;
        while (i < j) bytt(a, i++, j--);
        return true;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall
        for (int i = 0; i < n; i++)
            a[i] = i + 1;                  // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // lÃ¸kke som gÃ¥r n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k

            int temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }

        return a;                        // permutasjonen returneres
    }

} // class Oblig1Test