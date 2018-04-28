package com.example.kelimebulma;

import android.content.Context;

import com.example.kelimebulma.model.Soru;

import java.util.Random;

public class SoruYoneticisi {
    private static final Soru[] SORULAR = new Soru[]{
            new Soru("Tıbbi lazımlık.", "ördek"),
            new Soru("Sünnet sponsoru.", "kirve"),
            new Soru("Futbolun rus ruleti.", "penaltı"),
            new Soru("Toprak küskünlüğü.", "kuraklık"),
            new Soru("Trafik piyadesi.", "yaya"),
            new Soru("Erotik köfte.", "kadınbudu"),
            new Soru("Soğukkanlı beyaz eşya.", "buzdolabı"),
            new Soru("Pedagojik gezinti.", "atta"),
            new Soru("Asli görevinin yanı sıra, şişe açacağı olarak da kullanılan bir alet.", "çakmak"),
            new Soru("Bekar hayatında kariyer yapmak.", "evde kalmak"),
            new Soru("Vejetaryenlerin ancak yalancısının tadına bakabildiği tatlı", "tavukgöğsü"),
            new Soru("140 karakterle sınırlı kalmadan sevdayı kelimelere döken iletişim aracı.", "aşk mektubu"),
            new Soru("Ön görülen tarihin ve sürenin haricinde kullanılan beleş tatil.", "kafa izni"),
            new Soru("Merkezi sinir sisteminin merkezini dış etkilere karşı koruyan muhafaza.", "kafatası"),
            new Soru("Sinsi tabiatlı bir patlayıcı.", "mayın"),
            new Soru("Can borcu tahsildarı.", "Azrail"),
            new Soru("Cansız ekin bekçisi", "korkuluk"),
            new Soru("Pişmiş zerzevat harmanı", "türlü"),
            new Soru("Kitlesel olarak da yapılabilen cerrahi operasyon", "sünnet"),
            new Soru("Şoför feyadı.", "korna"),
            new Soru("Pedagojik aile kurma oyunu", "evcilik"),
            new Soru("Merhum forması.", "kefen"),
            new Soru("Alamet-i farikası kötü el yazısı olan şifa pusulası", "reçete"),
            new Soru("Sıvılaştırılmış emek", "alın teri"),
            new Soru("Kaynana asistanı.", "görümce"),
            new Soru("Sıvılaşmış keder", "gözyaşı")
    };

    public static void sorulariEkle(Context context) {
        AppDatabase.getInstance(context).soruDao().ekle(SORULAR);
    }

    public static Soru rastgeleSoruAl(Context context) {
        Random random = new Random();

        //TODO: Anahtar değerini kullanmaktan daha iyi bir yöntem bul
        return AppDatabase.getInstance(context).soruDao()
                .getSoru(random.nextInt(SORULAR.length));
    }
}
